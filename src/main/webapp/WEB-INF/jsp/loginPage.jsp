<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="homepage" var="homepage"/>
<fmt:message bundle="${loc}" key="log_in" var="log_in"/>

<head>
    <title>${registration}</title>
</head>
<body>
<form action="controller" method="post">
    <fieldset>
        <input type="hidden" name="command" value="registration">
        <legend>${registration}</legend>
        <p><label for="login">${login} </label><input name="login" type="text" id="login"></p>
        <p><label for="password">${pass} </label><input name="password" type="password" id="password"></p>
        <p><input type="submit" value="${sign_up}"></p>
    </fieldset>
</form>
<form action="controller" method="post">
    <input type="hidden" name="command" value="forward_command">
    <input type="hidden" name="target" value="homepage">
    <input type="submit" value="${homepage}">
</form>
</body>
</html>
