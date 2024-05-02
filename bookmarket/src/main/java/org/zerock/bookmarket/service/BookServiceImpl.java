package org.zerock.bookmarket.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.bookmarket.domain.BookVO;
import org.zerock.bookmarket.dto.BookDTO;
import org.zerock.bookmarket.mapper.BookMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookMapper bookMapper;
    private final ModelMapper modelMapper;

    @Override
    public void addBook(BookDTO bookDTO) {
        BookVO bookVO = modelMapper.map(bookDTO, BookVO.class);
        bookMapper.addBook(bookVO);
    }

    @Override
    public List<BookDTO> getBooks(BookDTO bookDTO) {
        List<BookDTO> dtoList = bookMapper.getAllBooks().stream()
                .map(bookVO -> modelMapper.map(bookVO, BookDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public BookDTO getOneBook(String id) {
        BookVO bookVO = bookMapper.selectOneBook(id);
        BookDTO bookDTO = modelMapper.map(bookVO, BookDTO.class);
        return bookDTO;
    }

    @Override
    public void deleteBook(String id) {
        bookMapper.deleteBook(id);
    }
    @Override
    public void modifyBook(BookDTO bookDTO) {
    BookVO bookVO = modelMapper.map(bookDTO, BookVO.class);
    bookMapper.updateBook(bookVO);
    }
}
