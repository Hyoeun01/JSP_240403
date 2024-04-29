package org.zerock.b01.repository.boardSearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.b01.domain.Board;

public interface BoardSearch {
    Page<Board> search1(Pageable pageable);
    Page<Board> searchALL(String[] types, String keyword, Pageable pageable);
}