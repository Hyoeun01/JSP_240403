package org.zerock.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;

import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {
    private TodoService todoService;

    @BeforeEach
    public void ready(){
        todoService = TodoService.INSTANCE;
    }

    @Test
        public void testRegister() throws Exception {
            TodoDTO todoDTO = TodoDTO.builder()
                    .title("JDBC test title")
                    .dueDate(LocalDate.now())
                    .build();

            log.info("-----------------"); //테스트코드의 Log4j2설정확인
            log.info(todoDTO);

            todoService.register(todoDTO);

            //10:12:44.390 [Test worker] INFO  org.zerock.jdbcex.service.TodoService - TodoVO(tno=null, title=JDBC test title, dueDate=2024-04-11, finished=false) >>  log4j2.xml 에 로그 루트레벨을 info로 설정했기때문
        }
    }

