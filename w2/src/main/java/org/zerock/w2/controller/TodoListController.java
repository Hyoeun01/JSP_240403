package org.zerock.w2.controller;


import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController", value = "/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("todo list..................");

        // HttpServletRequest에는 getServletContext() 메소드를 이용해서 ServletContext이용가능
        ServletContext servletContext = req.getServletContext();

        log.info("appName: "+servletContext.getAttribute("appName"));

        try{
            List<TodoDTO> dtoList = todoService.listAll();
            // setAttribute() :TodoService가 반환하는 데이터를 저장하고
            req.setAttribute("dtoList", dtoList);
            // RequestDispatcher를 이용해서 JSP로 전달
            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("list error");
        }
    }
}
