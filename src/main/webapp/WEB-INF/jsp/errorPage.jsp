<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${sessionScope.language==null}">
    <c:set scope="session" var="language" value="en"/>
</c:if>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="error" var="error"/>
<fmt:message bundle="${loc}" key="request_error" var="req_error"/>
<fmt:message bundle="${loc}" key="homepage" var="homepage"/>
<html>
<head>
    <title>${error}</title>
</head>
<body>
<h1>${req_error}</h1>
<%--<form action="controller" method="post">
    <input type="hidden" name="command" value="forward_command">
    <input type="hidden" name="target" value="homepage">
    <input type="submit" value="${homepage}">
</form>--%>
<a href="controller?command=forward_command&target=homepage">${homepage}</a>
</body>
</html>
