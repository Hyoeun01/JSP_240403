package org.zerock.b01.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.b01.dto.ReplyDTO;


import java.util.Map;

@RestController
@RequestMapping("/replies")
@Log4j2
public class ReplyController {

    @Tag(name="Replies POST", description = "POST 방식으로 댓글 등록")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    // ResponseEntity : 데이터를 HTTP 상태코드와 같이 앞단에 전달하는역할
    // JSON 타입의 문자열로 전달시 사용
    // 서버에 도착하면 JSON > ReplyDTO 타입으로 자동변환( jackson 라이브러리가 컨버터역할을 해서 - 스프링부트 자동내장)
    public ResponseEntity<Map<String, Long>> register(@RequestBody ReplyDTO replyDTO) {
        log.info(replyDTO);
        Map<String, Long> resultMap = Map.of("rno",123L);
        return ResponseEntity.ok(resultMap);
    }
}
