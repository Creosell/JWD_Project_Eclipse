<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${language==null}">
    <c:set scope="session" var="language" value="en"/>
</c:if>

<c:choose>
    <c:when test="${language != null}">
        <fmt:setLocale value="${language}"/>
    </c:when>
    <c:otherwise>
        <fmt:setLocale value="en"/>
    </c:otherwise>
</c:choose>

<html lang="${sessionScope.lang}">
<%--<fmt:setLocale value="${sessionScope.local}"/>--%>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="localization_button.en" var="en_button"/>
<fmt:message bundle="${loc}" key="localization_button.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="welcome_message" var="welcome_message"/>
<head>
    <title>Header title</title></head>
<body>
<c:out value="${language}"/>
<div>
    <form action="controller" method="post">
        <c:set scope="session" var="language" value="ru"/>
        <input type="hidden" name="command" value="change_local"/>
        <input type="submit" value="${ru_button}">
    </form>
    <form action="controller" method="post">
        <c:set scope="session" var="language" value="en"/>
        <input type="hidden" name="command" value="change_local"/>
        <input type="submit" value="${en_button}">
    </form>
</div>
<h1>${welcome_message}</h1>
</body>
</html>
