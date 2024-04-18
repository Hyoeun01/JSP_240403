package org.zerock.applicationtest.controller;

import org.zerock.applicationtest.dto.NoticeDTO;
import org.zerock.applicationtest.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/notice_list")
public class NoticeListController extends HttpServlet {

    private NoticeService noticeService = NoticeService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<NoticeDTO> list= noticeService.listAll();
            req.setAttribute("list", list);

        }catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/views/notice_list.jsp").forward(req, resp);
    }


}
