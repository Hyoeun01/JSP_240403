package org.zerock.bookmarket.mapper;

import org.zerock.bookmarket.domain.BookVO;

import java.util.List;

public interface BookMapper {
    void addBook(BookVO bookVO);
    List<BookVO> getAllBooks();
    BookVO selectOneBook(String id);
    void updateBook(BookVO bookVO);
    void deleteBook(String id);

}
