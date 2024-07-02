package com.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class AwsS3Service {

	@Autowired
	private AmazonS3 amazonS3;

	@Value("${aws.s3.bucketName}")
	private String bucketName;

	public void uploadFile(MultipartFile multipartFile) throws IOException {
		File convertedFile = new File(multipartFile.getOriginalFilename());
 		convertedFile.createNewFile();
 		FileUtils.writeByteArrayToFile(convertedFile, multipartFile.getBytes());
 		String fileName = multipartFile.getOriginalFilename();
		amazonS3.putObject(new PutObjectRequest(bucketName, fileName, convertedFile));
		convertedFile.delete(); // delete the temporary file
	}

}
