package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import lombok.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller // 해당 클래스가 스프링MVC에서 컨트롤러 역할을 하고, 스프링의 빈(bean)으로 처리되기 위함
@Log4j2
public class SampleController {

    // GET방식으로 들어오는 요청을 처리하기 위해서 사용. /hello 라는 경로를 호출할 때 동작
    @GetMapping("/hello")
    public void hello() {
        log.info("hello................................");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1.........................");
        log.info("name : "+name);
        log.info("age : "+age);
    }

    @GetMapping("/ex2")
    public void ex2(@RequestParam(name="name", defaultValue = "AAA") String name, @RequestParam(name="age", defaultValue = "22") int age) {
        log.info("ex2.........................");
        log.info("name : "+name);
        log.info("age : "+age);

    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3.........................");
        log.info("dueDate : "+dueDate);
    }

    @GetMapping("/ex4")
    public void ex4( Model model) {

        log.info("------------------------");
        model.addAttribute("message","hello world");
    }
}
