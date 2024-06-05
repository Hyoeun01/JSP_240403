package org.zerock.apps3.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class S3UploaderTest {
    @Autowired
    private S3Uploader s3uploader;

    @Test
    public void testUpload() {
        try {
            String filePath = "C:\\files\\100.jpg";
            String uploadName = s3uploader.upload(filePath);
            log.info(uploadName);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void testRemove(){
        try {
            s3uploader.removeS3File("100.jpg");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
