package org.zerock.springex.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

@Log4j2
/*  JUnit 5에서 스프링 테스트를 실행할 때 사용되는 어노테이션
    테스트 클래스 또는 테스트 메서드에 붙여서 사용되며,
    해당 테스트를 스프링 테스트 컨텍스트와 함께 실행하도록 지시함
    이를 통해 테스트 클래스나 메서드에서 스프링의 기능 사용 가능
    보통 스프링 기반의 테스트를 작성할 때 테스트 컨텍스트를 로드하고 의존성 주입 등의 스프링 기능을 활용
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTime(){
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert(){

        TodoVO todoVO = TodoVO.builder()
                .title("스프링 테스트")
                .dueDate(LocalDate.of(2022,10,10))
                .writer("user00")
                .build();

        todoMapper.insert(todoVO);

    }

    @Test
    public void testSelectAll(){

        // 가장 나중에 추가된 데이터가 우선적으로 보인다
        List<TodoVO> voList = todoMapper.selectAll();
        voList.forEach(vo-> log.info(vo));
    }

    @Test
    public void testSelectOne(){
        TodoVO todoVO = todoMapper.selectOne(1L);
        log.info(todoVO);
    }
}
