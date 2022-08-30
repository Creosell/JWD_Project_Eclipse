<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:if test="${sessionScope.language==null}">
    <c:set scope="session" var="language" value="en"/>
</c:if>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="title_homepage" var="title"/>
<fmt:message bundle="${loc}" key="localization_button.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="log_in" var="log_in"/>
<fmt:message bundle="${loc}" key="registration" var="registration"/>
<fmt:message bundle="${loc}" key="sign_out" var="sign_out"/>
<fmt:message bundle="${loc}" key="best_offer" var="bestOffer"/>
<fmt:message bundle="${loc}" key="overclocking" var="overclocking"/>
<fmt:message bundle="${loc}" key="ultimate_gaming" var="ultimateGaming"/>
<fmt:message bundle="${loc}" key="currency" var="currency"/>
<fmt:message bundle="${loc}" key="stock" var="stock"/>
<fmt:message bundle="${loc}" key="quantity" var="quantity"/>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/header.jsp"/>

<div class="banner header-text">
    <div class="owl-banner owl-carousel">
        <div class="banner-item-01">
            <div class="text-content">
                <h4>${bestOffer}</h4>
                <h2>AMD Ryzen™ Threadripper™ 3990X</h2>
            </div>
        </div>
        <div class="banner-item-02">
            <div class="text-content">
                <h4>${overclocking}</h4>
                <h2>ROG CROSSHAIR VIII Extreme</h2>
            </div>
        </div>
        <div class="banner-item-03">
            <div class="text-content">
                <h4>${ultimateGaming}</h4>
                <h2>ASUS EKWB GeForce RTX 3090</h2>
            </div>
        </div>
    </div>
</div>
<!-- Banner Ends Here -->

<div class="latest-products">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <h2>Latest Products</h2>
                    <a href="controller?command=forward_command&target=products">view all products <i
                            class="fa fa-angle-right"></i></a>
                </div>
            </div>
            <c:forEach var="productListItem" items="${applicationScope.productList}" end="2">
                <div class="col-lg-4 col-md-4 all des">
                    <div class="product-item">
                        <a href="#"><img alt="" src="../../assets/images/products/${productListItem.productID}.png"></a>
                        <div class="down-content">
                            <a href="#"><h4>${productListItem.title}</h4></a>
                            <p>${productListItem.description}</p>
                        </div>
                        <div class="product-item-footer">
                            <p>${stock}: ${productListItem.availableQuantity} ${quantity}</p>
                            <span>${productListItem.price} ${currency}</span>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<div class="best-features">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <h2>About Sixteen Clothing</h2>
                </div>
            </div>
            <div class="col-md-6">
                <div class="left-content">
                    <h4>Looking for the best products?</h4>
                    <p><a rel="nofollow" href="https://templatemo.com/tm-546-sixteen-clothing" target="_parent">This
                        template</a> is free to use for your business websites. However, you have no permission to
                        redistribute the downloadable ZIP file on any template collection website. <a rel="nofollow"
                                                                                                      href="https://templatemo.com/contact">Contact
                            us</a> for more info.</p>
                    <ul class="featured-list">
                        <li><a href="#">Lorem ipsum dolor sit amet</a></li>
                        <li><a href="#">Consectetur an adipisicing elit</a></li>
                        <li><a href="#">It aquecorporis nulla aspernatur</a></li>
                        <li><a href="#">Corporis, omnis doloremque</a></li>
                        <li><a href="#">Non cum id reprehenderit</a></li>
                    </ul>
                    <a href="controller?command=forward_command&target=about" class="filled-button">Read More</a>
                </div>
            </div>
            <div class="col-md-6">
                <div class="right-image">
                    <img src="assets/images/feature-image.jpg" alt="">
                </div>
            </div>
        </div>
    </div>
</div>


<div class="call-to-action">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="inner-content">
                    <div class="row">
                        <div class="col-md-8">
                            <h4>Creative &amp; Unique <em>Sixteen</em> Products</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque corporis amet elite
                                author nulla.</p>
                        </div>
                        <div class="col-md-4">
                            <a href="#" class="filled-button">Purchase Now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/footer.jsp"/>


<%--
<div id="loginButton">
    <form name="loginForm" action="controller" method="post">
        <input type="hidden" name="command" value="forward_command">
        <input type="hidden" name="target" value="log_in">
        <input type="submit" value="${log_in}">
    </form>
</div>
<div id="registrationButton">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="forward_command">
        <input type="hidden" name="target" value="registration">
        <input type="submit" value="${registration}">
    </form>
</div>
<br>
<form action="controller" method="post">
    <input type="hidden" name="command" value="sign_out">
    <input type="submit" value="${sign_out}">
</form>
--%>
</body>
</html>