package org.zerock.bookmarket.service;

import org.zerock.bookmarket.dto.BookDTO;

import java.util.List;

public interface BookService {
    void addBook(BookDTO bookDTO);
    List<BookDTO> getBooks(BookDTO bookDTO);
    BookDTO getOneBook(String id);
    void deleteBook(String id);
    void modifyBook(BookDTO bookDTO);
}
