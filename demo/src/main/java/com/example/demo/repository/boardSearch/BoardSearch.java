package com.example.demo.repository.boardSearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.domain.Board;
import com.example.demo.dto.*;

public interface BoardSearch {
    Page<Board> search1(Pageable pageable);
    Page<Board> searchALL(String[] types, String keyword, Pageable pageable);

    // 댓글 표시해서 목록 출력하기
    Page<BoardListReplyCountDTO> searchWithReplyCount(String[] types, String keyword, Pageable pageable);

    // Page<BoardListReplyCountDTO> searchWithAll(String[] types, String keyword, Pageable pageable);
    Page<BoardListAllDTO> searchWithAll(String[] types, String keyword, Pageable pageable);

}
