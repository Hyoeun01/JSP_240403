package org.zerock.w1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {
    /*
    1. 서블릿의 객체는 경로에 맞게 하나만 만들어진다
    2. 매번 호출시에 자동으로 doGet()/doPost()를 이용해서 처리된다
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet...."+this);
    }

    @Override
    public void destroy() {
        System.out.println("destroy....");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init(ServletConfig)......");
    }

    /*
    브라우저에 /sample을 호출하면 init()의 메소드와 doGet()이 실행되는 것을 확인할 수 있다.
    이 상태에서 /sample을 여러번 호출하면 init.부분은 더이상 출력되지 않고 doGet 부분만 여러번 출력된다.
    중요한 점은 this의 결과로 출력되는 @이하의 값이 모두 같다는 점이다. 이것은 동일하게 하나의 객체로 처리된다는 뜻
    (doGet....org.zerock.w1.SampleServlet@7165688 가 여러번 나옴)
    마지막으로 톰캣을 종료하면 destroy()가 호출된다.
     */
}
