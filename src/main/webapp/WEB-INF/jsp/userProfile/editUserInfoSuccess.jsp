<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:if test="${sessionScope.language==null}">
    <c:set scope="session" var="language" value="en"/>
</c:if>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="editProfile" var="title"/>
<fmt:message bundle="${loc}" key="yourDataSuccess" var="success"/>

<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<div class="registration-heading">
    <h2>${success}</h2>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
