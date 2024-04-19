package org.zerock.springex.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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
}
