package org.zerock.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.bookmarket.service.BookService;

@Controller
@RequestMapping("/book")
@Log4j2
@RequiredArgsConstructor

public class BookController {
    private final BookService bookService;

    @GetMapping("")
}
