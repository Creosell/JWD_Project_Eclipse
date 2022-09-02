<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:if test="${sessionScope.language==null}">
    <c:set scope="session" var="language" value="en"/>
</c:if>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="homepage" var="homepage"/>
<fmt:message bundle="${loc}" key="registration" var="registration"/>
<fmt:message bundle="${loc}" key="newUser" var="newUser"/>
<fmt:message bundle="${loc}" key="wasSuccessfullyRegistered" var="success"/>

<!DOCTYPE html>
<html>
<head>
    <title>${registration}</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/header.jsp"/>
<div class="registration-heading">
    <h2>${newUser} ${success}</h2>  <!--//todo логин пользователя-->
</div>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
