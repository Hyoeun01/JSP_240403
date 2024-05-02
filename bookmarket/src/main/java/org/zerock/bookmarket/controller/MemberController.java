package org.zerock.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.bookmarket.dto.MemberDTO;
import org.zerock.bookmarket.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
    public String joinPost(@Valid MemberDTO memberDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception{
        log.info("post member join......");

        if(bindingResult.hasErrors()){
            log.info("has errors....");
            return "redirect:/member/join";
        }
        log.info(memberDTO);
        memberService.join(memberDTO);
        return "redirect:/";
    }

    @GetMapping("/login")
    public void loginGet(){
        log.info("get member login......");
    }

    @PostMapping("/login")
    public String loginMember(MemberDTO memberDTO, HttpServletRequest req, RedirectAttributes redirectAttributes) {
        try{
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo",  memberService.login(memberDTO));
        } catch (Exception e){
            e.printStackTrace();
            // redirectAttributes.addFlashAttribute("error", "아이디와 비밀번호를 확인해주세요...");
            return "redirect:/member/login?error=fail";
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logoutGet(HttpServletRequest req) throws Exception{
        log.info("logout...");
        HttpSession session = req.getSession();
        session.invalidate();

        return "redirect:/";

    }
}
