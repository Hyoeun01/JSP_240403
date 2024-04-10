package org.zerock.w1.todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    // GET방식으로 호출되는 경우에는 입력할 수 있는 화면을 보여주고, POST 방식으로 호출되는 경우에는 등록이 처리된 후에 다시 목록 페이지('/todo/list') 를 호출(sendRedirect)하게된다.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("입력 화면을 볼 수 있도록 구성");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("입력을 처리하고 목록 페이지로 이동");

        /*
        새로고침을 많이하면 서버에서 동일한 호출이 여러번 이루어지기때문에 이를 막기 위해서 PRG패턴을 적용하도록 sendRedirect()가 필요하다. sendRedirect()는 브라우저를 아예 다른 주소로 이동시키기 때문에 사용자가 반복적인 POST 요청을 보내는 것을 막을 수 있다. PRG 패턴은 등록 뿐 아니라 POST 방식으로 해야 하는 모든 기능에 적용할 수 있다. POST 방식은 무언가를 변경하거나 처리를 요구하는 작업이므로 수정/삭제 작업에서도 사용한다.
         */

        // 브라우저가 호출해야 하는 주소
        resp.sendRedirect("/todo/list");
    }
}
