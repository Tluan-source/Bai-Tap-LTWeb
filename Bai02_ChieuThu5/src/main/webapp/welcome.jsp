<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="jakarta.servlet.http.*" %>
<%
    // Lấy session có sẵn trong JSP
    String user = (String) session.getAttribute("username");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Xin chào, <%= user %>!</h2>
    <a href="login.jsp">Đăng xuất</a>
</body>
</html>
