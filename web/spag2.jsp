<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%-- 출력 담당 : View (HTML 코드) --%>
<html>
<head>
  <title>Title</title>
</head>
<%
  pageContext.setAttribute("model", "hello");
%>
<body>
<%=request.getAttribute("model")%>입니다.<br>   <%-- 출력 데이터 : Model --%>
${requestScope.model}<br>        <%--request 저장소--%>
${names[1]}<br>                  <%--request 저장소--%>
${notice.title}<br>              <%--request 저장소--%>
${pageScope.model}<br>                         <%--pageContext 저장소--%>
${empty param.n ? "값이 비어 있습니다." : param.n}<br>
${header.accept}
</body>
</html>
