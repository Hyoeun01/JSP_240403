package org.zerock.b01copy.controller.advice;


import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
@Log4j2
public class CustomRestAdvice {
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<Map<String, String>> handleBindException(BindException e) {
        log.error(e);
        Map<String, String> errorMap = new HashMap<>();

        if(e.hasErrors()) {
            BindingResult bindingResult = e.getBindingResult();
            bindingResult.getFieldErrors().forEach(fieldError -> {
                errorMap.put(fieldError.getField(), fieldError.getCode());
            });
        }
        return ResponseEntity.badRequest().body(errorMap);
    }

    // 실행시점에 오류코드 등 로그 기록하는 설정
    // 사용할 수 없는 bno로 작성시 발생하는 예외 처리하기
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<Map<String,String>> handleFKExction(Exception e) {
        log.error(e);
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("time", ""+System.currentTimeMillis());
        errorMap.put("msg", "constraint fails");
        return ResponseEntity.badRequest().body(errorMap);
    }

    // 존재하지 않는 데이터를 조회한 경우의 처리
    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<Map<String,String>> handleNoSuchElement(Exception e) {
        log.error(e);
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("time", ""+System.currentTimeMillis());
        errorMap.put("msg", "No Such Element Exception");
        return ResponseEntity.badRequest().body(errorMap);
    }


}
