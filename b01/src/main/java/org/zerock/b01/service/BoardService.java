package org.zerock.b01.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.b01.dto.*;

public interface BoardService {
    Long register(BoardDTO boardDTO); // 등록작업

    BoardDTO readOne(Long bno); // 조회작업

    void modify(BoardDTO boardDTO); // 수정작업

    void remove(Long bno); // 삭제작업

    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
    // 게시글 목록에 댓글 개수 표시하기
    PageResponseDTO<BoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);

}
