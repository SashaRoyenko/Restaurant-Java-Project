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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><fmt:message key="label.menu.title"/></title>
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

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="index.html">Tasty</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="index.html" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="menu.html" class="nav-link">Menu</a></li>
                <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
                <li class="nav-item">
                    <a href = "${pageContext.request.contextPath}/tasty-restaurant/login" class="nav-link">
                    <svg class="nav-svg ">
                        <use x="0" y="0" xlink:href="images/user.svg#user"></use>
                    </svg>
                </a></li>
                <li class="nav-item"><a href="#" class="nav-link">
                    <svg class="nav-svg">
                        <use x="0" y="0" xlink:href="images/shopping-cart.svg#cart"></use>
                    </svg>
                </a></li>
                <li class="nav-item">
                    <div class="nav-link dropdown">
                        <div class="dropbtn">UA</div>
                        <div class="dropdown-content">
                            <a href="#">UA</a>
                            <a href="#">EN</a>
                        </div>
                    </div>
            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->

<section class="home-slider owl-carousel">
    <div class="slider-item" style="background-image: url('images/bg_1.jpg');" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text align-items-center justify-content-center">
                <div class="col-md-10 col-sm-12 ftco-animate text-center">
                    <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Menu</span></p>
                    <h1 class="mb-3">Discover Our Exclusive Menu</h1>
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

                <div class="nav nav-pills justify-content-center ftco-animate" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a class="nav-link py-3 px-4 active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true"><span class="flaticon-meat"></span> Main</a>
                    <a class="nav-link py-3 px-4" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false"><span class="flaticon-cheers"></span> Drinks</a>
                </div>

                <div class="tab-content py-5" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/dish-3.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Grilled Beef with potatoes</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                            <p><span class="menu-weight">Weight: </span>
                                                <span>100g</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/dish-4.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Fruit Vanilla Ice Cream</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/dish-5.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Asian Hoisin Pork</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/dish-6.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Spicy Fried Rice &amp; Bacon</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/dish-7.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Mango Chili Chutney</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-6">
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/dish-8.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Savory Watercress Chinese Pancakes</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/dish-9.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Soup With Vegetables And Meat</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/dish-10.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Udon Noodles With Vegetables</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/dish-11.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Baked Lobster With A Garnish</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/dish-12.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Octopus with Vegetables</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!-- END -->
                    <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/drink-1.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Lemon Juice</h3>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/drink-2.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Guava Juice</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/drink-3.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Sprite</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/drink-4.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Cola</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/drink-5.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Wine</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-6">
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/drink-6.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Beer</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/drink-7.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Mango Juice</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/drink-8.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Apple Juice</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/drink-9.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Strawberry Juice</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="menus d-flex ftco-animate">
                                    <div class="menu-img" style="background-image: url(images/drink-10.jpg);"></div>
                                    <div class="text d-flex">
                                        <div class="one-half">
                                            <h3>Orange Juice</h3>
                                            <p><span>Meat</span>, <span>Potatoes</span>, <span>Rice</span>, <span>Tomatoe</span></p>
                                        </div>
                                        <div class="one-forth">
                                            <span class="price">$29</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="parts/footer.jsp"/>
