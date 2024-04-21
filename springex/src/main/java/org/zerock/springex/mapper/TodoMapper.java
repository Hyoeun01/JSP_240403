package org.zerock.springex.mapper;

import org.zerock.springex.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    // void = 리턴이 없다 = 데이터베이스에서 가져오는 값이 없다
    void insert(TodoVO todoVO);

    // 가장 최근에 등록된 TodoVO가 우선적으로 나올 수 있도록 selectAll() 추가하기
    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);
}
