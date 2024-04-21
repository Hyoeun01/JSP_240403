package org.zerock.springex.service;

import org.zerock.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    // 여러개의 파라미터 대신 TodoDTO로 묶어서 전달받도록 구성하기
    void register(TodoDTO todoDTO);

    // TodoMapper가 반환하는 데이터의 타입이 List<TodoVO>이기 때문에
    // List<TodoDTO>로 변환하는 작업이 필요하다
    List<TodoDTO> getAll();

    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);
}
