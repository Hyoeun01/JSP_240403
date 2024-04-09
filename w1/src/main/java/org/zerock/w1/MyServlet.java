package org.zerock.w1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// @WebServlet : 브라우저의 경로와 해당 서블릿을 연결
@WebServlet(name = "myServlet", urlPatterns = "/my")

// HttpServlet 클래스를 상속한다 = 서블릿클래스를 생성한다
public class MyServlet extends HttpServlet {

        @Override
        // doGet() : 브라우저의 주소를 직접 변경해서 접근하는 경우에 호출되는 메소드
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");

            // 일반적인 자바의 sout = 서블릿의 PrintWriter 객체
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h1>My Servlet</h1>");
            out.println("</body></html>");
        }
    }
