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
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="../html/index.html">Tasty</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="${pageContext.request.contextPath}/tasty-restaurant/home" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/tasty-restaurant/menu" class="nav-link">Menu</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/tasty-restaurant/about" class="nav-link">About</a></li>
                <li class="nav-item" id ="user">
                    <a href="${pageContext.request.contextPath}/tasty-restaurant/login" class="nav-link">
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
<!-- END nav -->

<section class="home-slider owl-carousel">
    <div class="slider-item" style="background-image: url('${pageContext.request.contextPath}/images/bg_1.jpg');">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text align-items-center justify-content-center text-center">
                <div class="col-md-10 col-sm-12 ftco-animate">
                    <h1 class="mb-3">Register an make an order</h1>
                    <p><a href="${pageContext.request.contextPath}/tasty-restaurant/registration" class="btn btn-primary btn-outline-white px-5 py-3">Register</a>
                    </p>
                </div>
            </div>
        </div>
    </div>

    <div class="slider-item" style="background-image: url('${pageContext.request.contextPath}/images/bg_2.jpg');">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text align-items-center justify-content-center text-center">
                <div class="col-md-10 col-sm-12 ftco-animate">
                    <h1 class="mb-3">Tasty &amp; Delicious Food</h1>
                    </p>
                </div>
            </div>
        </div>
    </div>

    <div class="slider-item" style="background-image: url('${pageContext.request.contextPath}/images/bg_3.jpg');">
        <div class="overlay"></div>
        <div class="container">
            <div class="row slider-text align-items-center justify-content-center text-center">
                <div class="col-md-10 col-sm-12 ftco-animate">
                    <h1 class="mb-3">We are glad to you</h1></p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- END slider -->

<section class="ftco-section-2">
    <div class="container d-flex">
        <div class="section-2-blocks-wrapper row">
            <div class="img col-sm-12 col-lg-6" style="background-image: url('${pageContext.request.contextPath}/images/about-2.jpg');">
            </div>
            <div class="text col-lg-6 ftco-animate">
                <div class="text-inner align-self-start">
                    <span class="subheading">About Tasty</span>
                    <h3 class="heading">Our chef cooks the most delicious food for you</h3>
                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there
                        live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics,
                        a large language ocean.</p>

                    <p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It
                        is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section parallax-img" style="background-image: url('${pageContext.request.contextPath}/images/bg_3.jpg');"
         data-stellar-background-ratio="0.5">
    <div class="overlay"></div>
    <div class="container">
        <div class="row justify-content-center mb-5 pb-5">
            <div class="col-md-7 text-center heading-section heading-section-white ftco-animate">
                <h2>Our Specialties</h2>
            </div>
        </div>
    </div>
</section>
<section class="ftco-section bg-light">
    <div class="container special-dish">
        <div class="row d-flex no-gutters">
            <div class="col-lg-6">
                <div class="block-3 d-md-flex ftco-animate">
                    <div class="image order-last" style="background-image: url(${pageContext.request.contextPath}/images/dish-3.jpg);"></div>
                    <div class="text text-center order-first">
                        <h2 class="heading">Beef Steak</h2>
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia,
                            there live the blind texts</p>
                        <span class="price">from $10.00</span>
                    </div>
                </div>
                <div class="block-3 d-md-flex ftco-animate">
                    <div class="image order-first" style="background-image: url(${pageContext.request.contextPath}/images/dish-4.jpg);"></div>
                    <div class="text text-center order-first">
                        <h2 class="heading">Beef Ribs Steak</h2>
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia,
                            there live the blind texts</p>
                        <span class="price">from $10.00</span>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="block-3 d-md-flex ftco-animate">
                    <div class="image order-last" style="background-image: url(${pageContext.request.contextPath}/images/dish-5.jpg);"></div>
                    <div class="text text-center order-first">
                        <h2 class="heading">Chopsuey</h2>
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia,
                            there live the blind texts</p>
                        <span class="price">from $10.00</span>
                    </div>
                </div>
                <div class="block-3 d-md-flex ftco-animate">
                    <div class="image order-first" style="background-image: url(${pageContext.request.contextPath}/images/dish-6.jpg);"></div>
                    <div class="text text-center order-first">
                        <h2 class="heading">Roasted Chieken</h2>
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia,
                            there live the blind texts</p>
                        <span class="price">from $10.00</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="instagram">
    <div class="container-fluid">
        <div class="row no-gutters justify-content-center pb-5">
            <div class="col-md-7 text-center heading-section ftco-animate">
                <h2><span>Instagram</span></h2>
            </div>
        </div>
        <div class="row no-gutters">
            <div class="col-sm-12 col-md ftco-animate">
                <a href="${pageContext.request.contextPath}/images/insta-1.jpg" class="insta-img image-popup"
                   style="background-image: url(${pageContext.request.contextPath}/images/insta-1.jpg);">
                    <div class="icon d-flex justify-content-center">
                        <span class="icon-instagram align-self-center"></span>
                    </div>
                </a>
            </div>
            <div class="col-sm-12 col-md ftco-animate">
                <a href="${pageContext.request.contextPath}/images/insta-2.jpg" class="insta-img image-popup"
                   style="background-image: url(${pageContext.request.contextPath}/images/insta-2.jpg);">
                    <div class="icon d-flex justify-content-center">
                        <span class="icon-instagram align-self-center"></span>
                    </div>
                </a>
            </div>
            <div class="col-sm-12 col-md ftco-animate">
                <a href="${pageContext.request.contextPath}/images/insta-3.jpg" class="insta-img image-popup"
                   style="background-image: url(${pageContext.request.contextPath}/images/insta-3.jpg);">
                    <div class="icon d-flex justify-content-center">
                        <span class="icon-instagram align-self-center"></span>
                    </div>
                </a>
            </div>
            <div class="col-sm-12 col-md ftco-animate">
                <a href="${pageContext.request.contextPath}/images/insta-4.jpg" class="insta-img image-popup"
                   style="background-image: url(${pageContext.request.contextPath}/images/insta-4.jpg);">
                    <div class="icon d-flex justify-content-center">
                        <span class="icon-instagram align-self-center"></span>
                    </div>
                </a>
            </div>
            <div class="col-sm-12 col-md ftco-animate">
                <a href="${pageContext.request.contextPath}/images/insta-5.jpg" class="insta-img image-popup"
                   style="background-image: url(${pageContext.request.contextPath}/images/insta-5.jpg);">
                    <div class="icon d-flex justify-content-center">
                        <span class="icon-instagram align-self-center"></span>
                    </div>
                </a>
            </div>
        </div>
    </div>
</section>

<footer class="ftco-footer ftco-bg-dark ftco-section">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Tasty</h2>
                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there
                        live the blind texts.</p>
                    <ul class="ftco-footer-social list-unstyled float-md-left float-lft">
                        <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Opening Hours</h2>
                    <ul class="list-unstyled">
                        <li><a href="#" class="py-2 d-block">Monday: <span>08: - 22:00</span></a></li>
                        <li><a href="#" class="py-2 d-block">Tuesday: <span>08: - 22:00</span></a></li>
                        <li><a href="#" class="py-2 d-block">Wednesday: <span>08: - 22:00</span></a></li>
                        <li><a href="#" class="py-2 d-block">Thursday: <span>08: - 22:00</span></a></li>
                        <li><a href="#" class="py-2 d-block">Friday: <span>08: - 22:00</span></a></li>
                        <li><a href="#" class="py-2 d-block">Saturday: <span>08: - 22:00</span></a></li>
                        <li><a href="#" class="py-2 d-block">Sunday: <span>08: - 22:00</span></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Contact Information</h2>
                    <ul class="list-unstyled">
                        <li><a href="#" class="py-2 d-block">198 West 21th Street, Suite 721 New York NY 10016</a></li>
                        <li><a href="#" class="py-2 d-block">+ 1235 2355 98</a></li>
                        <li><a href="#" class="py-2 d-block">info@yoursite.com</a></li>
                        <li><a href="#" class="py-2 d-block">email@email.com</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">

                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                    All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a
                            href="https://colorlib.com" target="_blank">Colorlib</a>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
            </div>
        </div>
    </div>
</footer>


<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#F96D00"/>
    </svg>
</div>

<%--<div id="login_wrapper">--%>
<%--    <div class="login">--%>
<%--        <form action="" method="post">--%>
<%--            <p><span class="fontawesome-user"></span>--%>
<%--                <input type="email" placeholder="Email" name = "login" required></p>--%>
<%--            <p><span class="fontawesome-lock"></span>--%>
<%--                <input type="password" placeholder="Password" name = "login_password" required></p>--%>
<%--            <p><input type="submit" value="ВОЙТИ"></p>--%>
<%--        </form>--%>
<%--        <p>Нет аккаунта? &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/tasty-restaurant/registration">Регистрация</a><span class="fontawesome-arrow-right"></span></p>--%>
<%--    </div>--%>
<%--</div>--%>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-migrate-3.0.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.stellar.min.js"></script>
<script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/js/aos.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.animateNumber.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.timepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="${pageContext.request.contextPath}/js/google-map.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>
