<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:if test="${sessionScope.language==null}">
    <c:set scope="session" var="language" value="en"/>
</c:if>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="titleHomepage" var="title"/>
<fmt:message bundle="${loc}" key="localizationButtonRu" var="ru_button"/>
<fmt:message bundle="${loc}" key="logIn" var="log_in"/>
<fmt:message bundle="${loc}" key="registration" var="registration"/>
<fmt:message bundle="${loc}" key="signOut" var="sign_out"/>
<fmt:message bundle="${loc}" key="bestOffer" var="bestOffer"/>
<fmt:message bundle="${loc}" key="overclocking" var="overclocking"/>
<fmt:message bundle="${loc}" key="ultimate_gaming" var="ultimateGaming"/>
<fmt:message bundle="${loc}" key="currency" var="currency"/>
<fmt:message bundle="${loc}" key="stock" var="stock"/>
<fmt:message bundle="${loc}" key="quantity" var="quantity"/>
<fmt:message bundle="${loc}" key="ourProducts" var="ourProducts"/>
<fmt:message bundle="${loc}" key="viewAllProducts" var="viewAllProducts"/>
<fmt:message bundle="${loc}" key="aboutSmartThings" var="aboutSmartThings"/>
<fmt:message bundle="${loc}" key="aboutDescription" var="aboutDescription"/>
<fmt:message bundle="${loc}" key="loginAndSingOut" var="loginAndSingOut"/>
<fmt:message bundle="${loc}" key="productInformation" var="productInformation"/>
<fmt:message bundle="${loc}" key="informationDelete" var="informationDelete"/>
<fmt:message bundle="${loc}" key="informationCheck" var="informationCheck"/>
<fmt:message bundle="${loc}" key="readMore" var="readMore"/>
<fmt:message bundle="${loc}" key="productAvailability" var="productAvailability"/>
<fmt:message bundle="${loc}" key="productRequest" var="productRequest"/>
<fmt:message bundle="${loc}" key="checkNow" var="checkNow"/>

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
                    <h2>${ourProducts}</h2>
                    <a href="controller?command=forward_command&target=products">${viewAllProducts}
                        <i class="fa fa-angle-right"></i></a>
                </div>
            </div>
            <c:forEach var="productListItem" items="${applicationScope.productList}" end="2">
                <div class="col-lg-4 col-md-4 all des">
                    <div class="product-item">
                        <a href="controller?command=forward_command&target=productPage"><img alt="" src="../../assets/images/products/${productListItem.productID}.png"></a>
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
                    <h2>${aboutSmartThings}</h2>
                </div>
            </div>
            <div class="col-md-6">
                <div class="left-content">

                    <p>${aboutDescription}</p>

                    <ul class="featured-list">
                        <li><a> ${loginAndSingOut} </a></li>
                        <li><a href="#">${registration}</a></li>
                        <li><a href="#">${informationCheck}</a></li>
                        <li><a href="#">${informationDelete}</a></li>
                        <li><a href="#">${productInformation}</a></li>
                    </ul>
                    <a href="controller?command=forward_command&target=about" class="filled-button">${readMore}</a>
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
                            <h4>${productAvailability}</h4>
                            <p>${productRequest}</p>
                        </div>
                        <div class="col-md-4">
                            <a href="controller?command=forward_command&target=contact" class="filled-button">${checkNow}</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/footer.jsp"/>
</body>
</html>