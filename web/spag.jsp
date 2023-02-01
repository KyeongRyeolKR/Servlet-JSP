<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%-- 입력과 제어 부분 : Controller (자바 코드) --%>
<%
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
%>
<%-- 출력 담당 : View (HTML 코드) --%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=model%>입니다.   <%-- 출력 데이터 : Model --%>
</body>
</html>
