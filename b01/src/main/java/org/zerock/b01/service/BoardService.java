package org.zerock.b01.service;

import org.zerock.b01.dto.BoardDTO;

public interface BoardService {
    Long register(BoardDTO boardDTO); // 등록작업

    BoardDTO readOne(Long bno); // 조회작업

    void modify(BoardDTO boardDTO); // 수정작업
}
