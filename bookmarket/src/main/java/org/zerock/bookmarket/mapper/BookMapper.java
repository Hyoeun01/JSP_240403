package org.zerock.bookmarket.mapper;

import org.zerock.bookmarket.domain.BookVO;

import java.util.List;

public interface BookMapper {
    void insertBook(BookVO bookVO);
    List<BookVO> selectAll();
    BookVO selectBookById(String id);
    void updateBook(BookVO bookVO);
    void deleteBook(String id);

}
