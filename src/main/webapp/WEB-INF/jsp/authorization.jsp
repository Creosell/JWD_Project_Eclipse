<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<c:if test="${sessionScope.language==null}">
    <c:set scope="session" var="language" value="en"/>
</c:if>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="homepage" var="homepage"/>
<fmt:message bundle="${loc}" key="authorization" var="authorization"/>
<fmt:message bundle="${loc}" key="logIn" var="log_in"/>
<fmt:message bundle="${loc}" key="login" var="login"/>
<fmt:message bundle="${loc}" key="password" var="password"/>
<fmt:message bundle="${loc}" key="registration" var="registration"/>
<fmt:message bundle="${loc}" key="enterYourPassword" var="enter_pass"/>
<fmt:message bundle="${loc}" key="titleLogIn" var="title"/>
<fmt:message bundle="${loc}" key="loginValidationMessage" var="loginMessage"/>
<fmt:message bundle="${loc}" key="passwordValidationMessage" var="passMessage"/>

<c:set var="loginPattern" value="^[a-zA-Z0-9]{4,16}$"/>
<c:set var="passwordPattern" value="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d-]{8,30}$"/>


<head>
    <title>${title}</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<div class="login-heading">
    <h2>${authorization}</h2>
    <div class="login-fields-input">
        <form action="controller" method="post">
            <input type="hidden" name="command" value="sign_in">
            <label for="login">${login}</label>
            <input autofocus required pattern="${loginPattern}" id="login" type="text" name="login" value=""
                   oninvalid="this.setCustomValidity('${loginMessage}')" oninput="this.setCustomValidity('')">
            <label for="pass">${password}</label>
            <input required id="pass" pattern="${passwordPattern}" type="password" name="password" value=""
                   oninvalid="this.setCustomValidity('${passMessage}')" oninput="this.setCustomValidity('')">
            <input class="login-input-button" type="submit" value="${log_in}">
        </form>
        <form action="controller" method="get">
            <input type="hidden" name="command" value="forward_command">
            <input type="hidden" name="target" value="registration">
            <input type="submit" value="${registration}">
        </form>
    </div>
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>

<script>
</script>
</body>
</html>
