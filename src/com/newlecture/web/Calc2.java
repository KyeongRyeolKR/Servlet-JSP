package com.newlecture.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getSession().getServletContext();  // 어플리케이션 전역적인 저장소
        HttpSession session = req.getSession();     // 사용자(세션)마다 달라지는 저장소

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String v_ = req.getParameter("value");
        String op = req.getParameter("operator");

        int v = 0;
        if (!v_.equals("")) {
            v = Integer.parseInt(v_);
        }

        // 계산
        if (op.equals("=")) {
//            int x = (Integer) application.getAttribute("value");  // Object 타입으로 반환하기 때문에 (Integer)로 형변환
            int x = (Integer) session.getAttribute("value");
            int y = v;
//            String operator = (String) application.getAttribute("op");
            String operator = (String) session.getAttribute("op");

            int result = 0;

            if (operator.equals("+")) {
                result = x + y;
            } else {
                result = x - y;
            }
            out.println("<br/>결과 : " + result);
        } else {    // 값 저장
//            application.setAttribute("value", v);
            session.setAttribute("value", v);
//            application.setAttribute("op", op);
            session.setAttribute("op", op);
        }

    }
}
