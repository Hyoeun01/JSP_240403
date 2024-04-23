package org.zerock.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.service.TodoService;

import javax.validation.Valid;

// 파일 추가 확인중

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor

public class TodoController {

    private final TodoService todoService;

    @RequestMapping("/list")
    public void list(Model model) { // 최종경로 /todo/list
        log.info("todo list............");

        // TodoService를 처리하고 Model에 데이터를 담아서 JSP로 전달해야함
        // Model에 dtoList라는 이름으로 목록 데이터를 담았으므로 JSP 에서는 JSTL을 이용해서 목록을 출력
        model.addAttribute("dtoList", todoService.getAll());
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

    @GetMapping({"/read", "/modify"})
    public void read(Long tno, Model model) {
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
    }

    @PostMapping("/register")
    public String registerPOST(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("POST todo register...........");
        // 검증에 문제가 있다면 다시 입력화면으로 리다이렉트 되게 함
        if(bindingResult.hasErrors()){
            log.info("has errors,,,,,,,,,,,,,");

            // 처리과정에서 잘못된 결과는 RedirectAttributes의 addFlashAttribute()를 이용해서 전달
            // redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/todo/register";
        }
        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes){
        log.info("-------------------remove--------------");
        log.info("tno : "+tno);

        todoService.remove(tno);
        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            log.info("has errors,,,,,,,,,,,,,,");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }
        log.info(todoDTO);
        todoService.modify(todoDTO);
        return "redirect:/todo/list";
    }
}
