package org.zerock.springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.PageResponseDTO;
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
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        // 서버에서 계산한 멤버들을 반환값으로 보내기 위한 준비단계
        // 기존 서비스에서 사용했던 메서드 들을 재사용 할 예정

        // 해당 페이지의 게시글 목록
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);

        // TodoVO에서 TodoDTO로 변환
        // voList = 페이지당 게시글 10개의 요소가 들어있음
        // stream().map : 요소를 병렬 처리하는 기능
        // voList의 10개의 요소들을 하나씩 순회하면서 각각 실행
        // vo > 10개의 요소중 하나의 요소가 들어가고
        // modelMapper.map  > vo타입을 TodoDTO의 클래스 타입으로 변환
        // collect : 모아주기
        // Collectors.toList()  > list 타입으로 변환
        // 리스트의 vo타입을 DTO타입으로 변환
        List<TodoDTO> dtoList = voList.stream().map(vo->modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        // 전체 개수를 알아야 페이징 가능
        int total = todoMapper.getCount(pageRequestDTO);

        // 실제로 서버에서 계산한 재료를 담아놓은 인스턴스 > 위의 내용을 서버에서 재계산해서 화면에 최종적으로 전달하기위한 준비
        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }


    @Override
    public List<TodoDTO> getAll() {

        // stream()을 이용해서 각 TodoVO는 map()을 통해 TodoDTO로 바꾸고, collect를 이용해서 List<TodoDTO>로 묶는다
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }


    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO = todoMapper.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.update(todoVO);
    }
}
