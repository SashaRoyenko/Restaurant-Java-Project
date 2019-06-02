<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 29.05.2019
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="${locale}">
<head>
    <title>Title</title>
</head>
<body>
    <h1>Admin Account</h1>

    <form action="${pageContext.request.contextPath}/tasty-restaurant/logOut">
        <button type="submit" class="logout">Logout</button>
    </form>
    <h1>
    </h1>
    <c:forEach items="${requestScope.orderList}" var="order">
                <p><c:out value="${order.id}"/></p>
                <p><c:out value="${order.date}"/>
                <p><c:out value="${order.bill}"/>
                <p><c:out value="${order.address}"/></p>
                <p><c:out value="${order.paid}"/></p>
                <p><c:out value="${order.user.firstName}"/></p>
    </c:forEach>
</body>
</html>
