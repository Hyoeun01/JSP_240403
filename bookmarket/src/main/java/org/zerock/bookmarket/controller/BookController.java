package org.zerock.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.bookmarket.domain.BookVO;
import org.zerock.bookmarket.dto.BookDTO;
import org.zerock.bookmarket.service.BookService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/book")
@Log4j2
@RequiredArgsConstructor

public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    public void getBooks(@Valid BookDTO bookDTO, Model model) {
        log.info("books....");
        model.addAttribute("books", bookService.getBooks(bookDTO));
    }
    @GetMapping("/book")
    public void readBook(String id, Model model) {
        model.addAttribute("book",bookService.getOneBook(id));
    }



    @GetMapping("/add")
    public void add() {

    }

    @PostMapping("/add")
    public String bookPost(MultipartFile file, @Valid BookDTO bookDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
        log.info("POST todo register...........");
        log.info(file.getOriginalFilename()); // 실제 파일 이름 출력하기
        log.info(file.getSize()); // 파일의 크기 출력
        log.info(file.getContentType()); // 파일의 확장자

        file.transferTo(new File("c://files//" + file.getOriginalFilename()));
        bookDTO.setImgFileName(file.getOriginalFilename());
        if (bindingResult.hasErrors()) {
            log.info("has errors,,,,,,,,,,,,,");

            // 처리과정에서 잘못된 결과는 RedirectAttributes의 addFlashAttribute()를 이용해서 전달
            // redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/book/add";
        }
        log.info(bookDTO);

        bookService.addBook(bookDTO);

        return "redirect:/book/books";
    }

    @GetMapping("/edit")
    public void edit(BookDTO bookDTO, Model model) {
        model.addAttribute("books", bookService.getBooks(bookDTO));
    }
    @PostMapping("/modify")
    public String editBook(BookDTO bookDTO) {
        bookService.modifyBook(bookDTO);
        return "redirect:/book/edit";
    }

    @GetMapping("/modify")
    public void update(String id, Model model) {
        log.info("book update....");
        model.addAttribute("book",bookService.getOneBook(id));
    }

}
