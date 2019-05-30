<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 30.05.2019
  Time: 18:43
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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><fmt:message key="label.home.title"/></title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.theme.default.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aos.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ionicons.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.timepicker.css">


    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/icomoon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<%--<h1><c:out value="${sessionScope.loggedUser.firstName}"/></h1>--%>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/tasty-restaurant/home">Tasty</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="${pageContext.request.contextPath}/tasty-restaurant/home" class="nav-link"><fmt:message key="label.home.title"/></a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/tasty-restaurant/menu" class="nav-link"><fmt:message key="label.menu.title"/></a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/tasty-restaurant/about" class="nav-link"><fmt:message key="label.about.title"/></a></li>
                <li class="nav-item" id ="user">
                    <a  class="nav-link">
                        <svg class="nav-svg ">
                            <use x="0" y="0" xlink:href="${pageContext.request.contextPath}/images/user.svg#user"></use>
                        </svg>
                    </a>
                </li>
                <li class="nav-item"><a href="#" class="nav-link">
                    <svg class="nav-svg">
                        <use x="0" y="0" xlink:href="${pageContext.request.contextPath}/images/shopping-cart.svg#cart"></use>
                    </svg>
                </a></li>
                <li class="nav-item">
                    <div class="nav-link dropdown">
                        <div class="dropbtn">UA</div>
                        <div class="dropdown-content">
                            <a href="?locale=ua">UA</a>
                            <a href="?locale=en">EN</a>
                        </div>
                    </div>
            </ul>
        </div>
    </div>
</nav>

</body>
</html>
