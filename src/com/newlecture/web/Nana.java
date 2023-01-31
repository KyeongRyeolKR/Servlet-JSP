package com.newlecture.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hi")
public class Nana extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        int cnt = 100;  // 기본값
        String cnt_ = request.getParameter("cnt");  // 키워드(cnt)에서 요청받은 값을 cnt_에 저장함
        if(cnt_ != null && !cnt_.equals("")){   // 사용자 요청 값이 null이 아니고 빈 문자열도 아닐 때 숫자로 변환함
            cnt = Integer.parseInt(cnt_);
        }

        for(int i=0; i<cnt; i++){
            out.println((i+1) + ": 안녕 Servlet!<br/>");
        }
    }
}
