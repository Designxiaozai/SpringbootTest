package com.ljm.minio;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Data
@Component
public class MinioConfig {
    @Value("${minio.endpoint}")
    public String endpoint;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;


    @Bean
    public MinioClient minioClient(){
        MinioClient minioClient =  MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
//                .httpClient(okHttpClient)
                .build();
        System.out.println("客户端链接成功");
        return minioClient;
    }




}
