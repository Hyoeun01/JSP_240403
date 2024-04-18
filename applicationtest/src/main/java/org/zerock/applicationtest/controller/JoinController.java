package org.zerock.applicationtest.controller;

import org.zerock.applicationtest.dto.MemberDTO;
import org.zerock.applicationtest.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(value = "/join")
public class JoinController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String agreeParam = req.getParameter("agree");
        boolean agree = agreeParam != null && agreeParam.equals("on");

        MemberDTO memberDTO = MemberDTO.builder()
                .member_id(req.getParameter("email1"))
                .member_pw(req.getParameter("member_pw"))
                .name(req.getParameter("name"))
                .phone(req.getParameter("phone"))
                .email1(req.getParameter("email1"))
                .email2(req.getParameter("email2"))
                .gender(req.getParameter("gender"))
                .agree(agree)
                .build();


        try {
            memberService.addMember(memberDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/");
    }
}
