package org.zerock.springex.service;

import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.PageResponseDTO;
import org.zerock.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    // 여러개의 파라미터 대신 TodoDTO로 묶어서 전달받도록 구성하기
    void register(TodoDTO todoDTO);

    // TodoMapper가 반환하는 데이터의 타입이 List<TodoVO>이기 때문에
    // List<TodoDTO>로 변환하는 작업이 필요하다
    List<TodoDTO> getAll();

    // 페이징 관련 추상 메서드 추가
    // 화면에서 url주소  http://localhost:8080/todo/list?page=1&size=10
    // 서버에서 계산후 페이징 재료를 화면에 전달하고, 화면에서 페이징처리
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);
}
