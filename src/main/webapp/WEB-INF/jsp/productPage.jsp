<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:if test="${sessionScope.language==null}">
  <c:set scope="session" var="language" value="en"/>
</c:if>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
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
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/header.jsp"/>
<div class="container page-heading" >
  <div class="section-heading">
    <h3>ASUS EKWB GeForce RTX 3090</h3>
  </div>
  <div class="container" style="display: flex; flex-direction: row;">
    <div class="container"> <img src="${pageContext.request.contextPath}/assets/images/products/1.png" alt="product-item">
    </div>
    <div class="container">
      <p>NVIDIA GeForce RTX 3090 24 ГБ GDDR6X, базовая частота 1400 МГц, макс. частота 1725 МГц, 10496sp, 82 RT-ядер, частота памяти 19500 МГц, 384 бит, доп. питание: 8+8 pin, 1 слот, HDMI, DisplayPort, трассировка лучей</p>
    </div>
  </div>
  <div class="section-heading" style="display: flex; flex-direction: row;">
    <button>Добавить в корзину</button>

    <span class="count"><span class="change minus min">
                    <span>-</span>
                </span>
                <input type="text" name="productСount" value="1" disabled="">
                <span class="change plus">
                    <span>+</span>
                </span>
			</span>

  </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/footer.jsp"/>

<script>
</script>
</body>
</html>