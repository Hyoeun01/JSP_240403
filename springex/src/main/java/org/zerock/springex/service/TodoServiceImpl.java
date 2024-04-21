package org.zerock.springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.mapper.TodoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2

// 클래스의 모든 필수(non-null) 속성을 초기화하는 생성자를 생성할 때 사용한다.
// 이 생성자는 클래스의 모든 final 필드 또는 @NonNull 로 표시된 필드를 인자로 받아 초기화
@RequiredArgsConstructor


// 설계도 역할
public class TodoServiceImpl implements TodoService {

    // 의존성 주입이 필요한 객체의 타입을 final로 고정
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    // 매개변수랑 리턴타입을 확인해야하므로 자동완성으로 오버라이드 하자
    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);

        // modelMapper를 이용해서 TodoDTO를 TodoVO로 변환하고 todoMapper 를 통해서 insert 처리
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        log.info(todoVO);

        todoMapper.insert(todoVO);
    }

    @Override
    public List<TodoDTO> getAll() {

        // stream()을 이용해서 각 TodoVO는 map()을 통해 TodoDTO로 바꾸고, collect를 이용해서 List<TodoDTO>로 묶는다
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }
}
