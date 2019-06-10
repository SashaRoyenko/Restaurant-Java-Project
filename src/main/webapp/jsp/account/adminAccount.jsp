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
    <jsp:include page="../parts/link.jsp"/>
</head>
<body>
<jsp:include page="../parts/nav.jsp"/>
<section class="home-slider owl-carousel">
    <div class="slider-item" style="background-image: url(${pageContext.request.contextPath}/images/bg_1.jpg);"
         data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text align-items-center justify-content-center">
                <div class="col-md-10 col-sm-12 ftco-animate text-center">
                    <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span>
                        <span>Admin account</span></p>
                    <h1 class="mb-3"><fmt:message key="label.registration.title"/></h1>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="user_account__section container mt-5">
    <div class="user_account__wrap d-flex flex-row">
        <div class="nav flex-column nav-pills col-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <a class="nav-link my_nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home"
               role="tab" aria-controls="v-pills-home" aria-selected="true">Кабінет</a>
            <a class="nav-link my_nav-link " id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile"
               role="tab" aria-controls="v-pills-profile" aria-selected="false">Не підтвердженні замовлення</a>
            <a class="nav-link my_nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages"
               role="tab" aria-controls="v-pills-messages" aria-selected="false">Оплачені замовлення</a>
        </div>

        <div class="tab-content col-9" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                <div class="user_cabinet offset-1">
                    <ul class="user_cabinet__list d-flex flex-column">
                        <li class="user_cabinet__list-item d-flex flex-row align-items-baseline">
                            <h6 class="user_cabinet__title">${sessionScope.sessionUser.firstName}</h6><i
                                class="user_cabinet__edit fas fa-edit" id="editname"></i>
                            <form class="form-group slide" action="" method="post" id="slidename">
                                <input class="form-control" type="text" placeholder="First Name">
                            </form>
                        </li>
                        <li class="user_cabinet__list-item d-flex flex-row align-items-baseline">
                            <h6 class="user_cabinet__title">${sessionScope.sessionUser.lastName}</h6><i
                                class="user_cabinet__edit fas fa-edit" id="editsurname"></i>
                            <form class="form-group" action="" method="post" id="slidesurname">
                                <input class="form-control" type="text" placeholder="Last Name">
                            </form>
                        </li>
                        <li class="user_cabinet__list-item d-flex flex-row align-items-baseline">
                            <h6 class="user_cabinet__title">${sessionScope.sessionUser.email}</h6><i
                                class="user_cabinet__edit fas fa-edit" id="editemail"></i>
                            <form class="form-group" action="" method="post" id="slideemail">
                                <input class="form-control" type="email" placeholder="Email">
                            </form>
                        </li>
                        <li class="user_cabinet__list-item d-flex flex-row align-items-baseline">
                            <h6 class="user_cabinet__title">${sessionScope.sessionUser.phone}</h6><i
                                class="user_cabinet__edit fas fa-edit" id="editphone"></i>
                            <form class="form-group" action="" method="post" id="slidephone">
                                <input class="form-control" type="phone" placeholder="Phone">
                            </form>
                        </li>
                        <li class="user_cabinet__list-item d-flex flex-row align-items-baseline">
                            <h6 class="user_cabinet__title">********</h6><i class="user_cabinet__edit fas fa-edit"
                                                                            id="editpassword"></i>
                            <form class="form-group d-flex flex-row user_account__form" action="" method="post">
                                <div id="slidepassword">
                                    <input class="form-control mr-4" type="password" placeholder="Password">
                                    <input class="form-control" type="password" placeholder="Confirm Password">
                                </div>
                            </form>
                        </li>
                    </ul>
                    <form action="${pageContext.request.contextPath}/tasty-restaurant/logOut">
                        <button type="submit" class="logout btn">Logout</button>
                    </form>
                </div>
            </div>
            <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                <ul class="d-flex flex-column">
                    <c:forEach items="${requestScope.uncheckedOrders}" var="uncheck">
                        <li class="order_item d-flex flex-row justify-content-between align-items-center">
                            <p><c:out value="${uncheck.date}"/></p>
                            <p><c:out value="${uncheck.bill}"/></p>
                            <p><c:out value="${uncheck.address}"/></p>
                            <p><c:out value="${uncheck.user.firstName}"/></p>
                            <p><c:out value="${uncheck.user.phone}"/></p>
                            <form action="${pageContext.request.contextPath}/tasty-restaurant/order?action=confirmOrder&id=<c:out value="${uncheck.id}"/>" method="post">
                                <input class="btn menu_btn" type="submit">
                            </form>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                <ul class="d-flex flex-column">
                    <c:forEach items="${requestScope.paidOrders}" var="paid">
                        <li class="order_item d-flex flex-row justify-content-between align-items-center">
                            <p><c:out value="${paid.date}"/></p>
                            <p><c:out value="${paid.bill}"/></p>
                            <p><c:out value="${paid.address}"/></p>
                            <p><c:out value="${paid.user.firstName}"/></p>
                            <p><c:out value="${paid.user.phone}"/></p>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../parts/footer.jsp"/>
</body>
</html>
