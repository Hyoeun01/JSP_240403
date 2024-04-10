package org.zerock.jdbcex.service;

import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

public enum TodoService {
    INSTANCE;

    // TodoDAO와 ModelMapper를 이용할 수 있도록 구성
    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // 새로운 TodoDTO를 등록하는 기능
    public void register(TodoDTO todoDTO) throws Exception{

        // TodoDTO를 파라미터로 받아서 TodoVO로 변환하는 과정 필요
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        // ModelMapper로 처리된 TodoVO를 println으로 확인
        System.out.println("todoVO: "+todoVO);

        // TodoDAO를 이용해서 insert()실행해서 TodoVO 등록
        dao.insert(todoVO); // int를 반환하므로 이를 이용해서 예외 처리도 가능
    }
}
