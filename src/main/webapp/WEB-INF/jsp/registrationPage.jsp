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
<fmt:message bundle="${loc}" key="login" var="login"/>
<fmt:message bundle="${loc}" key="password" var="pass"/>
<fmt:message bundle="${loc}" key="sign_up" var="sign_up"/>

<!DOCTYPE html>
<html>
<head>
    <title>${registration}</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="controller" method="post">
    <fieldset>
        <input type="hidden" name="command" value="registration">
        <legend>${registration}</legend>
        <p><label for="login">${login} </label><input name="login" type="text" id="login"></p>
        <p><label for="password">${pass} </label><input name="password" type="password" id="password"></p>
        <p><input type="submit" value="${sign_up}"></p>
    </fieldset>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
