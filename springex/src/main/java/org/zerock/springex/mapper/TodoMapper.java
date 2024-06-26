package org.zerock.springex.mapper;

import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    // void = 리턴이 없다 = 데이터베이스에서 가져오는 값이 없다
    void insert(TodoVO todoVO);

    // 가장 최근에 등록된 TodoVO가 우선적으로 나올 수 있도록 selectAll() 추가하기
    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);

    // 페이징 관련 메서드 추가 부분
    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    // 전체 갯수를 알아야 페이징 나누기 가능하기때문에
    int getCount(PageRequestDTO pageRequestDTO);
}
