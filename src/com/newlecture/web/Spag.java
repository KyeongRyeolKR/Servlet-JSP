package com.newlecture.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/spag2")
public class Spag extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = 0;
        String num_ = request.getParameter("n");
        if (num_ != null && !num_.equals("")) {
            num = Integer.parseInt(num_);
        }

        String model = "";
        if (num % 2 != 0) {
            model = "홀수";
        } else {
            model = "짝수";
        }

        request.setAttribute("model", model);  // 값을 request에 담음

        // forward
        RequestDispatcher dispatcher = request.getRequestDispatcher("spag2.jsp");
        dispatcher.forward(request, response);  // 값이 담긴 request를 다음 서블릿(spag.jsp)에 포워딩 해줌
    }
}
