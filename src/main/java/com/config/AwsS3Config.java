package com.config;

public class AwsS3Config {

//	@Value("${aws.accessKey}")
	private String accessKey;

//	@Value("${aws.secretKey}")
	private String secretKey;

//	@Value("${aws.region}")
	private String region;

//	@Bean
//	public AmazonS3 amazonS3Client() {
//		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
//		return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
//				.withRegion(region).build();
//	}
}
