<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${sessionScope.language==null}">
	<c:set scope="session" var="language" value="en" />
</c:if>

<c:set scope="page" var="defaultProductQuantity" value="0" />
<c:if test="${sessionScope.product.availableQuantity > 0}">
	<c:set scope="page" var="defaultProductQuantity" value="1" />
</c:if>

<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle basename="localization" var="loc" />
<fmt:message bundle="${loc}" key="addToCart" var="addToCart" />
<%--<fmt:message bundle="${loc}" key="" var=""/>
<fmt:message bundle="${loc}" key="" var=""/>
<fmt:message bundle="${loc}" key="" var=""/>
<fmt:message bundle="${loc}" key="" var=""/>
<fmt:message bundle="${loc}" key="" var=""/>
<fmt:message bundle="${loc}" key="" var=""/>
<fmt:message bundle="${loc}" key="" var=""/>
<fmt:message bundle="${loc}" key="" var=""/>
<fmt:message bundle="${loc}" key="" var=""/>
<fmt:message bundle="${loc}" key="" var=""/>
<fmt:message bundle="${loc}" key="" var=""/>--%>


<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="container page-heading">
		<div class="section-heading">
			<h3>${sessionScope.product.title}</h3>
		</div>
		<div class="container" style="display: flex; flex-direction: row;">
			<div class="container">
				<img
					src="assets/images/products/${sessionScope.product.productID}.png"
					alt="product-item">
			</div>
			<div class="container">
				<p>${sessionScope.product.description}</p>
			</div>
		</div>
		<div class="section-heading"
			style="display: flex; flex-direction: row; justify-content: space-between;">

			<div class = "product-price-section" style="display: flex; flex-direction: row;">
				<span class="price">8240.0 BYN</span> <span class="count"> <span
					class="change minus min"> <span class="noselect">-</span>

				</span> <input type="text" name="productСount"
					value="${defaultProductQuantity}"> <span
					class="change plus"> <span class="noselect">+</span>
				</span>
				</span>
			</div>
			<button>${addToCart}</button>
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />

	<script>
    document.querySelectorAll('.count .plus').forEach(item => {
    	
    	if (item.parentElement.querySelector('input').value > 1) {
            item.parentElement.querySelector('.minus').classList.remove('min');
        } 
    	
    	if (item.parentElement.querySelector('input').value >= ${sessionScope.product.availableQuantity}) {
            item.parentElement.querySelector('.plus').classList.add('max');
        }
    	
    	
        item.addEventListener('click', function () {
            if (item.parentElement.querySelector('input').value < ${sessionScope.product.availableQuantity}){
                ++item.parentElement.querySelector('input').value;
            }

            if (item.parentElement.querySelector('input').value > 1) {

                item.parentElement.querySelector('.minus').classList.remove('min');
            }
            
            if (item.parentElement.querySelector('input').value >= ${sessionScope.product.availableQuantity}) {

                item.parentElement.querySelector('.plus').classList.add('max');}
        });

    });

    document.querySelectorAll('.count .minus').forEach(item => {

        item.addEventListener('click', function () {
        	 if (item.parentElement.querySelector('input').value > 1) {
        		 
				--item.parentElement.querySelector('input').value;}
						
            if (item.parentElement.querySelector('input').value < 2 &&
            		item.parentElement.querySelector('input').value > 0) {
               
				item.parentElement.querySelector('input').value = 1
                item.classList.add('min');}
            
            if (item.parentElement.querySelector('input').value < ${sessionScope.product.availableQuantity}) {

                item.parentElement.querySelector('.plus').classList.remove('max');}
        });
    });
</script>
</body>
</html>