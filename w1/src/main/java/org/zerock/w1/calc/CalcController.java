package org.zerock.w1.calc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// urlPatterns 속성값이 /calc/makeResult 이르모 브라우저에서 form태그의 submit경로를 수정해야 함
@WebServlet(name = "calcController", urlPatterns = "/calc/makeResult")
public class CalcController extends HttpServlet {
    // doPost를 오버라이드 >> 브라우저에서 POST방식으로 호출하는 경우에만 호출됨
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
        req.gerParameter() 메소드를 이용해서 쿼리 스트링으로 전달되는 num1,num2 파라미터를 숫자가 아닌 문자열로 처리하고있는데,
        JSP에서는 ${param.num1}과 같이 단순하게 처리했지만, 서블릿에서는 HttpServletRequest API를 이용해야한다
         */

        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        System.out.printf(" num1 : %s", num1);
        System.out.printf(" num2 : %s", num2);

        // calcController의 응답이 브라우저에서 /index 경로로 가도록 함.
        // 브라우저는 응답(Response) 헤더에 Location이 포함되면 브라우저의 주소창을 변경하고 해당 주소를 GET방식으로 호출

        // 지금은 /index에 해당하는 컨트롤러가 존재하지 않기때문에 404 error가 난다.
        resp.sendRedirect("/index");
    }
}
