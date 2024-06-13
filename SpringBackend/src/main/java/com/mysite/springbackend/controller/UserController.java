package com.mysite.springbackend.controller;

import com.mysite.springbackend.entity.User;
import com.mysite.springbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    // 스프링 프레임워크에서 비동기통신(API)를 구현하기위해 @RequestBody 와 @ResponseBody 어노테이션 사용
    // @RequestBody : 클라이언트 > 서버 요청 :: json 기반의 HTTP body를 자바 객체로 변환
    // @ResponseBody : 서버 > 클라이언트 응답
    public User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
