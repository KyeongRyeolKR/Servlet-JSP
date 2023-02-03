package com.newlecture.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getSession().getServletContext();  // 어플리케이션 전역적인 저장소
        HttpSession session = req.getSession();     // 사용자(세션)마다 달라지는 저장소
        Cookie[] cookies = req.getCookies();    // 사용자 브라우저에 저장할 수 있는 저장소


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
//            int x = (Integer) session.getAttribute("value");
            int x = 0;
            for(Cookie c : cookies){
                if(c.getName().equals("value")){
                    x = Integer.parseInt(c.getValue());
                    break;
                }
            }
            int y = v;
//            String operator = (String) application.getAttribute("op");
//            String operator = (String) session.getAttribute("op");
            String operator = "";
            for(Cookie c : cookies){
                if(c.getName().equals("op")){
                    operator = c.getValue();
                    break;
                }
            }
            int result = 0;

            if (operator.equals("+")) {
                result = x + y;
            } else {
                result = x - y;
            }
            out.println("<br/>결과 : " + result);
        } else {    // 값 저장
//            application.setAttribute("value", v);
//            application.setAttribute("op", op);
//            session.setAttribute("value", v);
//            session.setAttribute("op", op);
            Cookie valueCookie = new Cookie("value", String.valueOf(v));  // 쿠키는 문자열로만 저장해야함
            Cookie opCookie = new Cookie("op", op);
            valueCookie.setPath("/calc2");   // 쿠키를 저장할 경로를 지정해줌
            valueCookie.setMaxAge(24*60*60);    // 쿠키의 만료 날짜 설정(초단위)
            opCookie.setPath("/calc2");
            resp.addCookie(valueCookie);
            resp.addCookie(opCookie);

            resp.sendRedirect("calc2.html");  // 값 저장이 끝난 후 calc2.html로 리디렉트
        }

    }
}
