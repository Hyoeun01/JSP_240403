package org.zerock.b01.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.b01.dto.MemberDTO;
import org.zerock.b01.service.MemberService;


@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String join(MemberDTO memberDTO) {

        return "/ex/join";
    }

    @PostMapping("/join")
    public String addMember(MemberDTO memberDTO) {
        memberDTO.setEmail1(memberDTO.getMember_id());
        memberService.register(memberDTO);

        return "redirect:/ex/index";
    }

    @GetMapping("/login")
    public String login(MemberDTO memberDTO) {
        return "/ex/login";
    }

    @PostMapping("/login")
    public String loginMember(String member_id, String member_pw, HttpServletRequest req) {

        MemberDTO loginInfo = memberService. login(member_id, member_pw);
        HttpSession session = req.getSession();
        session.setAttribute("loginInfo", loginInfo);

        return "redirect:/ex/index";
    }

    @GetMapping("/logout")
        public String logout(HttpServletRequest req) {
        // session을 변수로 설정하면 중복사용이된다
        // HttpSession session = req.getSession();
        // session.removeAttribute("loginInfo");
        // session.invalidate();
        req.getSession().invalidate();
        return "redirect:/ex/index";
        }

}


