package com.mhc3.mhc3_3tory.config.S3;

import com.amazonaws.services.s3.AmazonS3Client;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
@Service
@RequiredArgsConstructor
public class S3Service {

    public static AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    public String bucketName;

    @Autowired
    public S3Service(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    public String getThumbnailPath(String path) {
        return amazonS3Client.getUrl(bucketName, path).toString();
    }
}
