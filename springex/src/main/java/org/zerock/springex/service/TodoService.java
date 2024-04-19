package org.zerock.springex.service;

import org.zerock.springex.dto.TodoDTO;

public interface TodoService {

    // 여러개의 파라미터 대신 TodoDTO로 묶어서 전달받도록 구성하기

    void register(TodoDTO todoDTO);
}
