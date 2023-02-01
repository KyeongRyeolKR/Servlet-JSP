<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    int cnt = 100;  // 기본값
    String cnt_ = request.getParameter("cnt");
    if(cnt_ != null && !cnt_.equals("")){
        cnt = Integer.parseInt(cnt_);
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%for (int i = 0; i < cnt; i++) {%>
    안녕 JSP!<br/>
    <%}%>
</body>
</html>
