package org.zerock.applicationtest.controller;

import org.zerock.applicationtest.dto.NoticeDTO;
import org.zerock.applicationtest.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/notice")
public class NoticeViewController extends HttpServlet {
    NoticeService noticeService = NoticeService.INSTANCE;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{

            int no = Integer.parseInt(req.getParameter("no")) ;
            NoticeDTO noticeDTO = noticeService.getNotice(no);

            req.setAttribute("notice", noticeDTO);

            req.getRequestDispatcher("/WEB-INF/views/notice_view.jsp").forward(req, resp);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int no = Integer.parseInt(req.getParameter("no")) ;
        try{
            noticeService.removeNotice(no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/notice_list");
    }
}
