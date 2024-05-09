package org.zerock.b01.service;

import org.zerock.b01.domain.Board;
import org.zerock.b01.dto.*;

public interface BoardService {
    Long register(BoardDTO boardDTO); // 등록작업

    BoardDTO readOne(Long bno); // 조회작업

    void modify(BoardDTO boardDTO); // 수정작업

    void remove(Long bno); // 삭제작업

    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
    // 게시글 목록에 댓글 개수 표시하기
    PageResponseDTO<BoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);

    default Board dtoToEntity(BoardDTO boardDTO) {
        Board board = Board.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(boardDTO.getWriter())
                .build();

        if(boardDTO.getFileNames() != null) {
            boardDTO.getFileNames().forEach(fileName -> {
                String[] arr = fileName.split("_");
                board.addImage(arr[0],arr[1]);
            });
        }
        return  board;
    }
}
