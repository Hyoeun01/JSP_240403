package org.zerock.springex.mapper;

import org.zerock.springex.domain.TodoVO;

public interface TodoMapper {
    String getTime();

    // void = 리턴이 없다 = 데이터베이스에서 가져오는 값이 없다
    void insert(TodoVO todoVO);
}
