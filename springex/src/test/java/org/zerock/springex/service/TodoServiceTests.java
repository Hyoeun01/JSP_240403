package org.zerock.springex.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.PageResponseDTO;
import org.zerock.springex.dto.TodoDTO;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTests {

    @Autowired
    private TodoService todoService;

    @Test
    public void testRegister(){

        // 새로운 Todo를 등록할 때는 제목, 만료일, 작성자가 필요하므로 TodoDTO로 구성해서 TodoServiceImpl을 테스트
        TodoDTO todoDTO = TodoDTO.builder()
                .title("Test......")
                .dueDate(LocalDate.now())
                .writer("user1")
                .build();

        todoService.register(todoDTO);
    }

    // 페이징 테스트
    // 화면에서 page=1&size=10 받으면 서버에서 계산하고 결과로
    // 페이지당 게시글 10개, 전체 게시글 수 , PageRequestDTO 반환
    @Test
    public void testPaging(){
        // 화면에서 전달받은 파라미터 값
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(2)
                .size(10)
                .build();

        //서버에서 계산하는 테스트
        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);
        log.info(responseDTO);

        // 10개의 게시글 순회해서 하나씩 확인하기
        responseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));
    }
}
