<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 09.06.2019
  Time: 15:39
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
    <title><fmt:message key="label.menu.title"/></title>
</head>
<body>
<jsp:include page="parts/nav.jsp"/>
<section class="home-slider owl-carousel">
    <div class="slider-item" style="background-image: url(${pageContext.request.contextPath}/images/bg_1.jpg);"
         data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text align-items-center justify-content-center">
                <div class="col-md-10 col-sm-12 ftco-animate text-center">
                    <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Menu</span></p>
                    <h1 class="mb-3">Basket</h1>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="ftco-section bg-light">
    <div class="container">
        <div class="row justify-content-center mb-5 pb-5">
            <div class="col-md-7 text-center heading-section ftco-animate">
                <span class="subheading">Our Menu</span>
                <h2>Discover Our Exclusive Menu</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 dish-menu">
                <!-- END -->
                <div class="tab-content py-5" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel"
                         aria-labelledby="v-pills-home-tab">
                        <div class="row ">
                            <c:forEach items="${sessionScope.userDishes}" var="dish">
                                <div class="col-lg-6">
                                    <div class="menus d-flex ftco-animate">
                                        <div class="menu-img"
                                             style="background-image: url(${pageContext.request.contextPath}/images/dish-3.jpg);"></div>
                                        <div class="text d-flex">
                                            <div class="one-half">
                                                <h3><c:out value="${dish.name}"/></h3>
                                                <p>
                                                    <span class="menu-weight">Weight: </span>
                                                    <span><c:out value="${dish.weight}"/></span>
                                                </p>
                                            </div>
                                            <div class="one-forth pr-1 d-flex flex-column align-items-center">
                                                <span class="price"><c:out value="${dish.price}"/> UAN</span>
                                                <form action="${pageContext.request.contextPath}/tasty-restaurant/basket?action=deleteDish&id=<c:out value="${dish.id}"/>" method="post">
                                                    <input class="menu_btn btn" type="submit" value="Delete">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <div class="row">
                            <c:forEach items="${sessionScope.userDrinks}" var="drink">
                                <div class="col-lg-6">
                                    <div class="menus d-flex ftco-animate">
                                        <div class="menu-img"
                                             style="background-image: url(${pageContext.request.contextPath}/images/drink-1.jpg);"></div>
                                        <div class="text d-flex">
                                            <div class="one-half">
                                                <h3><c:out value="${drink.name}"/></h3>
                                                <p>
                                                    <span class="menu-weight">Volume: </span>
                                                    <span><c:out value="${drink.volume}"/></span>
                                                </p>
                                            </div>
                                            <div class="one-forth pr-1 d-flex flex-column align-items-center">
                                                <span class="price"><c:out value="${drink.price}"/> UAN</span>
                                                <form action="${pageContext.request.contextPath}/tasty-restaurant/basket?action=deleteDrink&id=<c:out value="${drink.id}"/>" method="post">
                                                    <input class="menu_btn btn" type="submit" value="Delete">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="container d-flex justify-content-center align-items-center">
    <div>
        <h5 class="mr-5">
            Total price: <c:out value="${sessionScope.totalPrice}"/> UAN
        </h5>
    </div>
    <form action="" method = "post">
        <input class="btn btn-primary pl-5 pr-5" type="submit" value="Buy">
    </form>
</section>
<jsp:include page="parts/footer.jsp"/>
</body>
</html>
