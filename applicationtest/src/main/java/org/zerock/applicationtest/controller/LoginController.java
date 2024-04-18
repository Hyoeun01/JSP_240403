package org.zerock.applicationtest.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.applicationtest.dao.MemberDAO;
import org.zerock.applicationtest.dto.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login")
@Log4j2
public class LoginController extends HttpServlet {

    private MemberDAO memberDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        memberDAO = new MemberDAO();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username = req.getParameter("id");
        String password = req.getParameter("pw");

        try {
            // 데이터베이스에서 사용자 정보를 조회합니다.
            MemberDTO user = memberDAO.selectOne(username);

            if (user != null && user.getMember_pw().equals(password)) { // 사용자가 존재하고 비밀번호가 일치하는 경우
                // 세션에 사용자 정보를 저장합니다.
                HttpSession session = req.getSession();
                session.setAttribute("loggedInUser", user);

                // 홈 페이지로 리다이렉트합니다.
                resp.sendRedirect("/");
            } else { // 사용자가 존재하지 않거나 비밀번호가 일치하지 않는 경우
                // 로그인 실패 처리를 위해 로그인 페이지로 리다이렉트합니다.
                resp.sendRedirect("/login");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 예외가 발생하면 로그인 실패 처리를 위해 로그인 페이지로 리다이렉트합니다.
            resp.sendRedirect("/login");
        }

    }
}
