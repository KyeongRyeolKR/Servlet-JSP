package com.newlecture.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add2")
public class Add2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String[] num_ = req.getParameterValues("num");  // getParameterValues(S) : S의 name을 가진 모든 값들을 배열로 반환함

        int result = 0;

        for(int i=0; i<num_.length; i++){
            int num = Integer.parseInt(num_[i]);
            result += num;
        }

        out.println("<br/>결과 : " + result);
    }
}
