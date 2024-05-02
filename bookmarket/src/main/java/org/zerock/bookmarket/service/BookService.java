package org.zerock.bookmarket.service;

import org.zerock.bookmarket.dto.BookDTO;
import java.util.List;
public interface BookService {
    void insertBook(BookDTO bookDTO);
    List<BookDTO> getAll();
    BookDTO getBookById(String  id);
    void updateBook(BookDTO bookDTO);
    void deleteBook(String  id);

}
