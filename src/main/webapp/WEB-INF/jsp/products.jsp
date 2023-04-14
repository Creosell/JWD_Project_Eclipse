<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="titleOurProducts" var="title"/>
<fmt:message bundle="${loc}" key="currency" var="currency"/>
<fmt:message bundle="${loc}" key="stock" var="stock"/>
<fmt:message bundle="${loc}" key="quantity" var="quantity"/>
<%--<fmt:message bundle="${loc}" key="" var=""/>--%>
<fmt:message bundle="${loc}" key="allProducts" var="allProducts"/>

<html>
<head>
    <title>${title}</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<!-- Page Content -->
<div class="page-heading products-heading header-text">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="text-content">
                    <h4>new arrivals</h4>
                    <h2>sixteen products</h2>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="products">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="filters">
                    <ul>
                        <li class="active" data-filter="*">${allProducts}</li>
                        <li data-filter=".des">Featured</li>
                        <li data-filter=".dev">Flash Deals</li>
                        <li data-filter=".gra">Last Minute</li>
                    </ul>
                </div>
            </div>
            <div class="col-md-12">
                <div class="filters-content">
                    <div class="row grid">
                        <c:forEach var="productListItem" items="${applicationScope.productList}">
                            <div class="col-lg-4 col-md-4 all des">
                                <div class="product-item">
                                    <a href="#"><img alt="хз"
                                                     src="assets/images/products/${productListItem.productID}.png"></a>
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

        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
