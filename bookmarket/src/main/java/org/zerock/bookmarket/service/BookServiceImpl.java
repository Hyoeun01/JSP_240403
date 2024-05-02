package org.zerock.bookmarket.service;

import org.modelmapper.ModelMapper;
import org.zerock.bookmarket.domain.BookVO;
import org.zerock.bookmarket.dto.BookDTO;
import org.zerock.bookmarket.mapper.BookMapper;

import java.util.List;

public class BookServiceImpl implements BookService{

    private final BookMapper bookMapper;
    private final ModelMapper modelMapper;
    @Override
    public void insertBook(BookDTO bookDTO) {
        BookVO bookVO = modelMapper.map(bookDTO, BookVO.class);
        bookMapper.insertBook(bookVO);
    }

    @Override
    public List<BookDTO> getAll() {

    }

    @Override
    public BookDTO getBookById(String id) {
        return null;
    }

    @Override
    public void updateBook(BookDTO bookDTO) {

    }

    @Override
    public void deleteBook(String id) {

    }
}
