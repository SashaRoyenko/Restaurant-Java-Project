<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 29.05.2019
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 29.05.2019
  Time: 8:59
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
    <jsp:include page="parts/link.jsp"/>
    <title><fmt:message key="label.login.title"/></title>
</head>
<body>
<jsp:include page="parts/nav.jsp"/>

<section class="home-slider owl-carousel">
    <div class="slider-item" style="background-image: url(${pageContext.request.contextPath}/images/bg_1.jpg);" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text align-items-center justify-content-center">
                <div class="col-md-10 col-sm-12 ftco-animate text-center">
                    <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Reservation</span></p>
                    <h1 class="mb-3">Login</h1>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="login_wrapper">
    <div class="login">
        <form action="${pageContext.request.contextPath}/tasty-restaurant/loginUser" method="post">
            <p><span class="fontawesome-user"></span>
                <input type="email" placeholder="Email" name = "login" required></p>
            <p><span class="fontawesome-lock"></span>
                <input type="password" placeholder="Password" name = "login_password" required></p>
            <p><input type="submit" value="ВОЙТИ"></p>
        </form>
        <p>Нет аккаунта? &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/tasty-restaurant/registration">Регистрация</a><span class="fontawesome-arrow-right"></span></p>
    </div>
</div>

<jsp:include page="parts/footer.jsp"/>