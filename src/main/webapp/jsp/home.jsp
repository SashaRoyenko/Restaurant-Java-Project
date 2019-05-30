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

<jsp:include page="parts/header.jsp"/>


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

<jsp:include page="parts/footer.jsp"/>
