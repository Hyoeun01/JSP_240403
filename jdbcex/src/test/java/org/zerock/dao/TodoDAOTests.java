package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;

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
}
