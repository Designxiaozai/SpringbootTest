package com.ljm.minio;


import io.minio.BucketExistsArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MinioUtil {
    private OkHttpClient okHttpClient;
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
    public  void  testupload() throws NoSuchAlgorithmException, ServerException, InsufficientDataException, InternalException, InvalidResponseException, InvalidKeyException, XmlParserException, ErrorResponseException, IOException, KeyManagementException {
        OkHttpClient okHttpClient = creatClient();
        this.okHttpClient=okHttpClient;
        MinioClient minioClient =  MinioClient.builder()
                .endpoint("https://192.168.32.114:9528")
                .credentials("admin", "root123456")
                .httpClient(okHttpClient)
                .build();
        System.out.println("客户端链接成功");
        boolean test2 = minioClient.bucketExists(BucketExistsArgs.builder().bucket("test2").build());
        System.out.println(test2);

    }
}
