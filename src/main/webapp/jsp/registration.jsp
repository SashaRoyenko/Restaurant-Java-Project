<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 29.05.2019
  Time: 8:58
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
    <title><fmt:message key="label.registration.title"/></title>
</head>
<body>
<jsp:include page="parts/nav.jsp"/>
<section class="home-slider owl-carousel">
    <div class="slider-item" style="background-image: url(${pageContext.request.contextPath}/images/bg_1.jpg);" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text align-items-center justify-content-center">
                <div class="col-md-10 col-sm-12 ftco-animate text-center">
                    <p class="breadcrumbs"><span class="mr-2"><a href="${pageContext.request.contextPath}/tasty-restaurant/home">
                        <fmt:message key="label.home.title"/></a></span> <span><fmt:message key="label.registration.title"/></span></p>
                    <h1 class="mb-3"><fmt:message key="label.registration.title"/></h1>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section">
    <div class="container">
        <div class="row no-gutters justify-content-center mb-5 pb-5">
            <div class="col-md-7 text-center heading-section ftco-animate">
                <h2><fmt:message key="label.registration.title"/></h2>
            </div>
        </div>
        <div class="row d-flex">
            <div class="col-md-4 ftco-animate img"
                 style="background-image: url(${pageContext.request.contextPath}/images/bg_1.jpg);"></div>
            <div class="col-md-8 ftco-animate makereservation p-5 bg-light">
                <form action="${pageContext.request.contextPath}/tasty-restaurant/registerUser" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">First Name</label>
                                <input type="text" class="form-control" placeholder="First Name" name="firstName">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">Last Name</label>
                                <input type="text" class="form-control" placeholder="Last Name" name="lastName">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">Email</label>
                                <input type="email" class="form-control" placeholder="Email" name="email">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">Phone</label>
                                <input type="text" class="form-control" placeholder="Phone" name="phone">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">Enter Password</label>
                                <input type="password" class="form-control" placeholder="Password" name="password">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="">Confirm Password</label>
                                <input type="password" class="form-control" placeholder="Confirm Password"
                                       name="confirmedPassword">
                            </div>
                        </div>

                    </div>
                    <div class="col-md-12 mt-3">
                        <div class="form-group">
                            <input type="submit" value="<fmt:message key="label.btn.confirm"/>"
                                   class="btn btn-primary py-3 px-5">
                        </div>
                    </div>
                </form>
                <c:if test="${param.correctName==false}">
                    <p>Un correct first name or last name</p>
                </c:if>
                <c:if test="${param.correctPhone==false}">
                    <p>Un correct phone</p>
                </c:if>
                <c:if test="${param.correctEmail==false}">
                    <p>Un correct email</p>
                </c:if>
                <c:if test="${param.correctPassword==false}">
                    <p>Un correct password. It shout consist at least one uppercase letter, number and have at least 8
                        characters</p>
                </c:if>
                <c:if test="${param.emailExist==true}">
                    <p>User with such email is exist</p>
                </c:if>
                <c:if test="${param.phoneExist==true}">
                    <p>User with such phone is exist</p>
                </c:if>
                <c:if test="${param.passwordMatch==false}">
                    <p>Passwords are not equal</p>
                </c:if>
            </div>

        </div>
    </div>

</section>

<jsp:include page="parts/footer.jsp"/>