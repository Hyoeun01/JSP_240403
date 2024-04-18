package org.zerock.applicationtest.controller;

import org.zerock.applicationtest.dto.NoticeDTO;
import org.zerock.applicationtest.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/notice_add")
public class NoticeAddController extends HttpServlet {

    NoticeService noticeService = NoticeService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/notice_add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        NoticeDTO noticeDTO = NoticeDTO.builder()
                .title(req.getParameter("title"))
                .content(req.getParameter("contents"))
                .build();

        try{
            noticeService.addNotice(noticeDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/notice_list");
    }
}
