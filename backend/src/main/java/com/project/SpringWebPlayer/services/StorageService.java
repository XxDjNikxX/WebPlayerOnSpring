package com.project.SpringWebPlayer.services;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageService {
    private final AmazonS3 space;

    public StorageService() {
        AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(
                new BasicAWSCredentials("YCAJEqRLNrFsIsQHVSOdDUaZC","YCPZzFtP_7q3he34fmQPpFCyz657e37vXJ_qmPz3")
        );

        space = AmazonS3ClientBuilder
                .standard()
                .withCredentials(awsCredentialsProvider)
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("storage.yandexcloud.net","ru-central1")
                )
                .build();
    }

    public List<String> getSongFileNames() {
        ListObjectsV2Result result = space.listObjectsV2("musicarchiveobjectstorage");
        List<S3ObjectSummary> objects = result.getObjectSummaries();

        return objects.stream()
                .map(s3ObjectSummary -> s3ObjectSummary.getKey()).collect(Collectors.toList());
    }
    public List<String> getSongFileName() {
        ListObjectsV2Result result = space.listObjectsV2("musicarchiveobjectstorage");
        List<S3ObjectSummary> objects = result.getObjectSummaries();

        return objects.stream()
                .map(s3ObjectSummary -> s3ObjectSummary.getKey()).collect(Collectors.toList());
    }

    public void uploadSong(MultipartFile file) {
        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            space.putObject(new PutObjectRequest("musicarchiveobjectstorage",
                    file.getOriginalFilename(),
                    file.getInputStream(),
                    objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
