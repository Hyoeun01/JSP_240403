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
import org.zerock.springex.dto.PageRequestDTO;
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
    //기존 단순 전체갯수 출력 > 페이징 처리해서, 화면에 전달하는 코드 수정하기
    //화면에서 전달된 파라미터를 pageRequestDTO가 자동변환해줌
    // 페이지, 사이즈 등 의 유효성을 검사( 1, 또는 최소, 최대 양수 등 )하고 오류 발생하면 기본페이지로 이동(page=1,size=10)
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) { // 최종경로 /todo/list
        log.info(pageRequestDTO);

        //에러가 존재한다면 출력후 출력후 리다이렉트
        if(bindingResult.hasErrors()) {
            pageRequestDTO=PageRequestDTO.builder().build();
        }

        // responseDTO안에는 페이징 관련 준비물이 들어있다
        // 화면에서 responseDTO.page >> 페이지번호 사용가능 -list.jsp
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }
/*
    public void list(Model model) { // 최종경로 /todo/list
        log.info("todo list............");

        // TodoService를 처리하고 Model에 데이터를 담아서 JSP로 전달해야함
        // Model에 dtoList라는 이름으로 목록 데이터를 담았으므로 JSP 에서는 JSTL을 이용해서 목록을 출력
        model.addAttribute("dtoList", todoService.getAll());
    }
*/
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
    public void read(Long tno, Model model, PageRequestDTO pageRequestDTO) {
        // 화면에서 페이지의 정보를 전달하면, 서버에서는 pageRequestDTO 타입으로 받아둔다.
        // 화면에서 pageRequestDTO 사용
        model.addAttribute("dto", todoService.getOne(tno));
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
// 기존의 url 파라미터를 사용하는 메서드 방식은 get방식이었고, post는 폼에 히든으로 숨겨서 전달
    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes, PageRequestDTO pageRequestDTO){
        log.info("-------------------remove--------------");
        log.info("tno : "+tno);

        todoService.remove(tno);

        // 페이지와 사이즈 정보를 화면에 전달하기
        redirectAttributes.addAttribute("page",pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size",pageRequestDTO.getSize());
        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes,PageRequestDTO pageRequestDTO){
        if(bindingResult.hasErrors()){
            log.info("has errors,,,,,,,,,,,,,,");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }
        log.info(todoDTO);
        todoService.modify(todoDTO);
        // 페이지와 사이즈 정보를 화면에 전달하기
        redirectAttributes.addAttribute("page",pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size",pageRequestDTO.getSize());
        return "redirect:/todo/read";
    }
}
