package org.zerock.w1.todo;

import org.zerock.w1.todo.dto.TodoDTO;
import org.zerock.w1.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/list");

        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();

        // setAttribute()를 이용해서 list라는 이름으로 List<TodoDTO> 객체 보관하도록 작성.
        // 보관된 데이터는 JSP에서 EL(${list})로 간단하게 확인 가능 >> list.jsp
        req.setAttribute("list", dtoList);

        req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
    }
}
