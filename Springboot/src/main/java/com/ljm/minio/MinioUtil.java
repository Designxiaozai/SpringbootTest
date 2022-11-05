package com.ljm.minio;


import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MinioUtil {
    @Autowired
    private MinioClient minioClient;
    @Autowired
    private MinioConfig minioConfig;
    private OkHttpClient okHttpClient;
    private static final String BUCKET_PARAM = "${bucket}";
    private static final String READ_ONLY = "{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:GetBucketLocation\",\"s3:ListBucket\"],\"Resource\":[\"arn:aws:s3:::" + BUCKET_PARAM + "\"]},{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:GetObject\"],\"Resource\":[\"arn:aws:s3:::" + BUCKET_PARAM + "/*\"]}]}";
    /**
     * bucket权限-只读
     */
    private static final String WRITE_ONLY = "{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:GetBucketLocation\",\"s3:ListBucketMultipartUploads\"],\"Resource\":[\"arn:aws:s3:::" + BUCKET_PARAM + "\"]},{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:AbortMultipartUpload\",\"s3:DeleteObject\",\"s3:ListMultipartUploadParts\",\"s3:PutObject\"],\"Resource\":[\"arn:aws:s3:::" + BUCKET_PARAM + "/*\"]}]}";
    /**
     * bucket权限-读写
     */
    private static final String READ_WRITE = "{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:GetBucketLocation\",\"s3:ListBucket\",\"s3:ListBucketMultipartUploads\"],\"Resource\":[\"arn:aws:s3:::" + BUCKET_PARAM + "\"]},{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:DeleteObject\",\"s3:GetObject\",\"s3:ListMultipartUploadParts\",\"s3:PutObject\",\"s3:AbortMultipartUpload\"],\"Resource\":[\"arn:aws:s3:::" + BUCKET_PARAM + "/*\"]}]}";

    private  OkHttpClient creatClient() throws NoSuchAlgorithmException, KeyManagementException {
        X509TrustManager trustManager = new X509TrustManager() {

            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new X509TrustManager[]{trustManager}, null);
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .hostnameVerifier((s, sslSession) -> true)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .followSslRedirects(true)
                .hostnameVerifier((s, sslSession) -> true)
                .protocols(Arrays.asList(new Protocol[]{Protocol.HTTP_1_1, Protocol.HTTP_2}))
                .connectTimeout(60, TimeUnit.SECONDS)//设置连接超时时间
                .readTimeout(60, TimeUnit.SECONDS)//设置读取超时时间
                .sslSocketFactory(sslSocketFactory, trustManager)
                .build();
        return okHttpClient;
    }
    @Test
    public  void   createBluket(String name) throws NoSuchAlgorithmException, ServerException, InsufficientDataException, InternalException, InvalidResponseException, InvalidKeyException, XmlParserException, ErrorResponseException, IOException, KeyManagementException {
//        OkHttpClient okHttpClient = creatClient();
//        this.okHttpClient=okHttpClient;
        boolean flag = bucketExists(name);
        if (!flag){
          minioClient.makeBucket(MakeBucketArgs.builder().bucket(name).build());
        }
    }
//    判断桶是否存在
    public boolean bucketExists( String name) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
        boolean  flag = minioClient.bucketExists(BucketExistsArgs.builder().bucket(name).build());
        return flag;
    }

   public String upload(MultipartFile file,String name) throws Exception {

       minioClient.putObject(PutObjectArgs.builder()
               .bucket(name)
               .object("avatar"+"/"+file.getOriginalFilename())
               .stream(file.getInputStream(),file.getSize(),-1)
               .contentType(file.getContentType())
               .build());
      setBucketPolicy(name,"read-write");
       Map<String, String> reqParams = new HashMap<>();
       reqParams.put("response-content-type", "application/json");
       String url = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
               .bucket(name).object("avatar"+"/"+ file.getOriginalFilename())
               .method(Method.GET)
               .extraQueryParams(reqParams) /*非必须有默认的*/
               .build());
       System.out.println(url);
//       String   url2= MinioEnum.ADDRESS.getValue()+"/"+MinioEnum.BUCKET_NAME.getValue()+"/"+MinioEnum.AVATAR.getValue()+"/"+file.getOriginalFilename();
       String url2 = minioConfig.endpoint+"/"+name+"/"+"avatar"+"/"+file.getOriginalFilename();
       return url2;
   }
    public  void setBucketPolicy(String bucket, String policy) throws Exception {

        switch (policy) {
            case "read-only":
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucket).config(READ_ONLY.replace(BUCKET_PARAM, bucket)).build());
                break;
            case "write-only":
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucket).config(WRITE_ONLY.replace(BUCKET_PARAM, bucket)).build());
                break;
            case "read-write":
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucket).config(READ_WRITE.replace(BUCKET_PARAM, bucket)).build());
                break;
            case "none":
            default:
                break;

        }
    }

//    删除文件
    public String delete(String name) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, ServerException, ErrorResponseException, XmlParserException, InsufficientDataException, InternalException {

        boolean flag = bucketExists("docker-test");
        if (!flag){
            return "桶不存在";
        }
        RemoveObjectArgs objectArgs = RemoveObjectArgs.builder().object(name).bucket("docker-test").build();
        minioClient.removeObject(objectArgs);
        return "删除成功";
    }




//

}
