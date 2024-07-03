package com.service;

public class AwsS3Service {

	//@Autowired
	//private AmazonS3 amazonS3;

	//@Value("${aws.s3.bucketName}")
	private String bucketName;

//	public void uploadFile(MultipartFile multipartFile) throws IOException {
//		File convertedFile = new File(multipartFile.getOriginalFilename());
// 		convertedFile.createNewFile();
// 		FileUtils.writeByteArrayToFile(convertedFile, multipartFile.getBytes());
// 		String fileName = multipartFile.getOriginalFilename();
//		amazonS3.putObject(new PutObjectRequest(bucketName, fileName, convertedFile));
//		convertedFile.delete(); // delete the temporary file
//	}

}
