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
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<jsp:include page="WEB-INF/jsp/header.jsp"/>
<br>
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


</body>
</html>