package org.zerock.b01.service;

import org.zerock.b01.dto.BoardDTO;
import org.zerock.b01.dto.PageRequestDTO;
import org.zerock.b01.dto.PageResponseDTO;

public interface BoardService {
    Long register(BoardDTO boardDTO); // 등록작업

    BoardDTO readOne(Long bno); // 조회작업

    void modify(BoardDTO boardDTO); // 수정작업

    void remove(Long bno); // 삭제작업

    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
