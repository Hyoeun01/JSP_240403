package org.zerock.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.bookmarket.service.MemberService;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor

public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public void joinGet(){
        log.info("get member join......");
    }

    @PostMapping("/join")
    public void joinPost(){
        log.info("post member join......");
    }
}
