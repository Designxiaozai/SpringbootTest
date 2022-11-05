package com.ljm.minio;

import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@RestController
public class MinioController {

    @Autowired
    private MinioClient minioClient;
    @Autowired
    private MinioUtil minioUtil;
    @PostMapping
    public String upload(MultipartFile multipartFile) throws Exception {
        minioUtil.createBluket("docker-test");
        String url = minioUtil.upload(multipartFile, "docker-test");
        return url;
    }
    @DeleteMapping
    private String delete(String name) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InsufficientDataException, ErrorResponseException {
        minioUtil.delete(name);
        return "删除成功";
    }
}
