package org.zerock.w2.controller;

import lombok.extern.java.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
@Log

// 브라우저 실행해서 /login 으로 접속후 아이디 비밀번호 입력하고 LOGIN버튼 누르면 /todo/list로 리다이렉트 됨
// 리다이렉트 된 화면에서 /todo/register를 호출하면 로그인한 사용자로 간주되어서 정상적으로 작성화면이 나옴
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login get...................");
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login post...................");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        String str=mid+mpw;

        HttpSession session = req.getSession();

        session.setAttribute("loginInfo", str);

        resp.sendRedirect("/todo/list");
    }
}
