package org.zerock.applicationtest.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션을 무효화하여 사용자 정보를 삭제합니다.
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        resp.sendRedirect("/");
    }

}
