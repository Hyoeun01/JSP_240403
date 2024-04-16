package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

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

    @GetMapping("/ex4_1")
    public void ex4Extra(Model model) {
        log.info("ex4Extra...............");
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(20L)
                .title("sample data")
                .dueDate(LocalDate.parse("2024-02-10"))
                .finished(true)
                .writer("test writer")
                .build();

        model.addAttribute("todoDTO",todoDTO);
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        log.info("ex5........................");
        // 리다이렉트할 때 쿼리 스트링이 되는 값을 지정
        redirectAttributes.addAttribute("name","ABC");

        // 일회용으로만 데이터를 전달하고 삭제되는 값을 지정 : url에는 보이지 않지만 jsp에서 사용가능하다
        redirectAttributes.addFlashAttribute("result","success");

        return "redirect:/ex6";
    }
    @GetMapping("/ex6")
    public void ex6(String name,Model model){
        log.info("ex6....................name: "+name);
        model.addAttribute("name",name);
    }

    @GetMapping("/ex7")
    public void ex7(String p1, int p2) {
        log.info("p1......"+p1);
        log.info("p2......"+p2);
    }
}
