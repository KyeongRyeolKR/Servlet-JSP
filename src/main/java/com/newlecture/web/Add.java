package com.newlecture.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class Add extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String x_ = req.getParameter("x");
        String y_ = req.getParameter("y");

        int x = 0;
        int y = 0;
        try {
            if (!x_.equals("")) {
                x = Integer.parseInt(x_);
            }
            if (!y_.equals("")) {
                y = Integer.parseInt(y_);
            }
        } catch (Exception e) {
            out.printf("숫자가 아닌 값이 있습니다. ( x : %s | y : %s )", x_, y_);
        }
        out.println("<br/>결과 : " + (x + y));
    }
}
