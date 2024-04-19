package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

@Controller
@RequestMapping("/todo")
@Log4j2
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
    public String registerPOST(TodoDTO todoDTO, RedirectAttributes redirectAttributes){
        log.info("POST todo register...........");
        log.info(todoDTO);

        return "redirect:/todo/list";
    }
}
