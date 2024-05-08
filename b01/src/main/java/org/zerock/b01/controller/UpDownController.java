package org.zerock.b01.controller;


import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


@RestController
@Log4j2
public class UpDownController {

//    @Tag(name = "Upload POST", description = "Post방식으로 파일등록")
//    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String upload(UploadFileDTO uploadFileDTO) {
//        log.info(uploadFileDTO);
//
//        return null;
//    }

    @Value("${org.zerock.upload.path}")
    private  String uploadPath;

    @Tag(name = "Upload POST", description = "Post방식으로 파일등록")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(MultipartFile file) {
        log.info(file);
        if(!file.isEmpty()) {
            String originalName = file.getOriginalFilename();
            log.info(originalName);
            String uuid = UUID.randomUUID().toString();
            Path savePath = Paths.get(uploadPath,uuid+"_"+originalName);
            try{
                file.transferTo(savePath);
            }catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
