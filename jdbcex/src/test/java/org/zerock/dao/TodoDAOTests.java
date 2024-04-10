package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    // 모든 테스트 전에 TodoDAO타입의 객체 todoDAO 생성
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    // TodoDAO 에 작성한 getTime()이 정상적으로 동작하는지 확인한다
    @Test
    public void testTime() throws Exception{
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testInsert() throws Exception{
        //@Builder : 생성자와 달리 필요한 만큼만 데이터를 세팅할 수 있다는 장점이 있다. finished 속성은 false로 기본 지정되어 있고, 변경할 필요가 없기 때문에 세팅하는 부분도 없다.
        TodoVO todoVO = TodoVO.builder()
                .title("test title...")
                .dueDate(LocalDate.of(2023,4,3))
                .build();

        todoDAO.insert(todoVO);
    }
}
