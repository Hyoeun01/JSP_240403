package org.zerock.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor

public class TodoController {

    @RequestMapping("/list")
    public void list(Model model) { // 최종경로 /todo/list
        log.info("todo list............");
    }

    /* @RequestMapping(value = "/register", method = RequestMethod.GET) // /todo/register
    public void register(){
        log.info("todo register...........");
    }
    */

    @GetMapping("/register")
    public void registerGET(){
        log.info("GET todo register...........");
    }

    @PostMapping("/register")
    public String registerPOST(TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("POST todo register...........");
        // 검증에 문제가 있다면 다시 입력화면으로 리다이렉트 되게 함
        if(bindingResult.hasErrors()){
            log.info("has errors,,,,,,,,,,,,,");

            // 처리과정에서 잘못된 결과는 RedirectAttributes의 addFlashAttribute()를 이용해서 전달
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/todo/register";
        }
        log.info(todoDTO);

        return "redirect:/todo/list";
    }
}
