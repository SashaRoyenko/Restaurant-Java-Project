<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 29.05.2019
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>User account</h1>
    <form action="${pageContext.request.contextPath}/tasty-restaurant/logOut">
        <button type="submit" class="logout">Logout</button>
    </form>
</body>
</html>
