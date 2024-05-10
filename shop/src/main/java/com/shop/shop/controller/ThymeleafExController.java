package com.shop.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// url에 "/thymeleaf"경로로 오는 요청을 ThymeleafExController 가 처리
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {
    @GetMapping(value = "/ex01")
    public String thymeleafEx01(Model model){
        model.addAttribute("data","타임리프 예제");
        return "thymeleafEx/thymeleafEx01";
    }
}
