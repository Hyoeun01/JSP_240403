package org.zerock.apps3.util;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@RequiredArgsConstructor
@Log4j2
public class S3Uploader {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    public String bucket;

    // S3로 파일 업로드하기
    public String upload(String filePath) throws RuntimeException {
        // UploadLocal 에서 저장한 파일의 전체 경로를 이용해서 파일 불러오기
        File targetFile = new File(filePath);
        // putS3 메소드를 이용하여 S3스토리지에 파일 저장
        String uploadImageUrl = putS3(targetFile,targetFile.getName());
        // c:/upload 에 저장된 파일을 삭제
        removeOriginalFile(targetFile);
        return uploadImageUrl;
    }
    // S3 업로드
    private String putS3(File uploadFile, String fileName) throws  RuntimeException {
        // putObject 메소드를 이용하여 S3스토리지에 파일 저장
        amazonS3Client.putObject(new PutObjectRequest(bucket,fileName, uploadFile)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        // S3에 저장된 파일을 불러올 수 있는 주소 반환
        return amazonS3Client.getUrl(bucket,fileName).toString();
    }
    private void removeOriginalFile(File targetFile) {
        // 파일이 존재하는지 + 파일을 삭제한 후 정상적으로 삭제가 되면
        if(targetFile.exists() && targetFile.delete()) {
            log.info("file delete success");
            return;
        }
        log.info("fail to remove original file");
    }

    public void removeS3File(String  fileName) {
        final DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucket, fileName);
        amazonS3Client.deleteObject(deleteObjectRequest);

    }
}
