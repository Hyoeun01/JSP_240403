package org.zerock.jdbcex.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", value = "/todo/read")
@Log4j2

// 조회기능은 GET방식으로 동작하고 tno라는 파라미터를 쿼리 스트링으로 번호를 전달하는 방식이다.
// TodoService에서는 TodoDTO를 반환하고 이를 컨트롤러에서 HttpServletRequest에 담아 JSP에 출력한다.
public class TodoReadController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Long tno = Long.parseLong(req.getParameter("tno"));
            TodoDTO todoDTO = todoService.get(tno);

            // 데이터 담기
            req.setAttribute("dto", todoDTO);

            // read.jsp로 TodoDTO를 전달
            req.getRequestDispatcher("/WEB-INF/views/todo/read.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("read error!");
        }
    }
}
