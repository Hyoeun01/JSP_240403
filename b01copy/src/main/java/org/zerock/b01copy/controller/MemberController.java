package org.zerock.b01copy.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.b01copy.dto.MemberJoinDTO;
import org.zerock.b01copy.dto.PageRequestDTO;
import org.zerock.b01copy.service.MemberService;

@Controller
@Log4j2
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public void loginGET(String errorCode, String logout) {
        log.info("login get.............");
        log.info("logout: "+logout);

        if(logout != null) {
            log.info("user logout...................");
        }
    }

    @GetMapping("/join")
    public void joinGET() {
        log.info("join get..................");
    }

    @PostMapping("/join")
    public String joinPOST(MemberJoinDTO memberJoinDTO, RedirectAttributes redirectAttributes) {
        log.info("join post..................");
        log.info(memberJoinDTO);
        try{
            memberService.join(memberJoinDTO);
        }catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "mid");
            return "redirect:/member/join";
        }
        redirectAttributes.addFlashAttribute("result", "success");
        return "redirect:/member/login";
    }

    @GetMapping("/modify")
    public void modifyGET(){
        log.info("modify get..........");
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO, @Valid MemberJoinDTO memberJoinDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("member POST modify..."+memberJoinDTO);
        memberService.modify(memberJoinDTO);
        redirectAttributes.addFlashAttribute("result","modified");
        redirectAttributes.addAttribute("bno",memberJoinDTO.getMid());
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(MemberJoinDTO memberJoinDTO, RedirectAttributes redirectAttributes, HttpSession httpSession){

            log.info("회원탈퇴");
            memberService.remove(memberJoinDTO);
            redirectAttributes.addFlashAttribute("result","removed");
            httpSession.invalidate();
            return "redirect:/board/list";

    }
}
