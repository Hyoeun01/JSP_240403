package org.zerock.applicationtest.controller;

import org.zerock.applicationtest.dto.NoticeDTO;
import org.zerock.applicationtest.dto.ProgramDTO;
import org.zerock.applicationtest.service.ProgramService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/program")
public class ProgramController extends HttpServlet {

    private ProgramService programService = ProgramService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        try {
            List<ProgramDTO> list= programService.listAll();
            req.setAttribute("list", list);

        }catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/WEB-INF/views/program.jsp").forward(req, resp);
    }
}
