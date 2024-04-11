package org.zerock.jdbcex.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
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

        /*
        ModelMapper로 처리된 TodoVO를 println으로 확인
        System.out.println("todoVO: "+todoVO);
        */

        log.info(todoVO);
        // TodoDAO를 이용해서 insert()실행해서 TodoVO 등록
        dao.insert(todoVO); // int를 반환하므로 이를 이용해서 예외 처리도 가능
    }

    // TodoDAO에서 가져온 TodoVO의 목록을 모두 TodoDTO로 변환해서 반환
    // ModelMapper와 자바스트림의 map()을 이용
    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("volist......................");

        log.info(voList);

        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    // 조회기능 구현하기
    public TodoDTO get(Long tno) throws Exception {
        log.info("tno: "+tno);
        TodoVO todoVO = dao.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    public void remove(Long tno) throws Exception {
        log.info("tno: "+tno);
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO todoDTO) throws Exception {
        log.info("todoDTO: "+todoDTO);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        dao.updateOne(todoVO);
    }
}
