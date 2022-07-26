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
<fmt:message bundle="${loc}" key="sign_up" var="signUp"/>
<fmt:message bundle="${loc}" key="confirm_password" var="confirmPassword"/>
<fmt:message bundle="${loc}" key="login_validation_message" var="loginMessage"/>
<fmt:message bundle="${loc}" key="password_validation_message" var="passMessage"/>
<fmt:message bundle="${loc}" key="confirm_password_message" var="passConfirmMessage"/>

<c:set var="loginPattern" value="^[a-zA-Z0-9]{4,16}$"/>
<c:set var="passwordPattern" value="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,30}$"/>

<!DOCTYPE html>
<html>
<head>
    <title>${registration}</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/header.jsp"/>
<div class="registration-heading">
    <form action="controller" method="post">
        <fieldset>
            <input type="hidden" name="command" value="registration">
            <legend>${registration}</legend>
            <p>
                <label for="login">${login} </label>
                <input autofocus required pattern="${loginPattern}" id="login" type="text" name="login" value=""
                       oninvalid="this.setCustomValidity('${loginMessage}')" oninput="this.setCustomValidity('')">
            </p>
            <p>
                <label for="password">${pass} </label>
                <input required id="password" pattern="${passwordPattern}" type="password" name="password" value=""
                       oninvalid="this.setCustomValidity('${passMessage}')" oninput="this.setCustomValidity('')">
            </p>
            <p>
                <label for="confirm-password">${confirmPassword} </label>
                <input required id="confirm-password" pattern="${passwordPattern}" type="password" name="password"
                       value="" oninvalid="this.setCustomValidity('${passConfirmMessage}')"
                       oninput="this.setCustomValidity('')">
            </p>
            <p>
                <input type="submit" value="${signUp}">
            </p>
        </fieldset>
    </form>
</div>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
