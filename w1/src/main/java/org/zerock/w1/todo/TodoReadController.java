package org.zerock.w1.todo;

import org.zerock.w1.todo.dto.TodoDTO;
import org.zerock.w1.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")

// 특정한 번호의 조회기능 > GET방식으로 동작하게 설정
public class TodoReadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/read");

        // HttpServletRequest의 getParameter()는 항상 문자열로 결과가 나오기 때문에 Long타입으로 처리하기 위한 변환을 한다
        // /todo/read?tno=123
        Long tno = Long.parseLong(req.getParameter("tno"));

        TodoDTO dto = TodoService.INSTANCE.get(tno);

        // TodoService의 get()을 통해서 나온 TodoDTO객체를 dto라는 이름으로 설정한다
        req.setAttribute("dto", dto);
        // 설정한 dto를 JSP에 전달한다
        req.getRequestDispatcher("WEB-INF/todo/read.jsp").forward(req, resp);
    }
}
