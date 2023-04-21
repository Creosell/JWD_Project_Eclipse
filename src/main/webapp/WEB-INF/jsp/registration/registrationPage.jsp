<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:if test="${sessionScope.language==null}">
    <c:set scope="session" var="language" value="en"/>
</c:if>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="homepage" var="homepage"/>
<fmt:message bundle="${loc}" key="registration" var="registration"/>
<fmt:message bundle="${loc}" key="login" var="login"/>
<fmt:message bundle="${loc}" key="password" var="pass"/>
<fmt:message bundle="${loc}" key="signUp" var="signUp"/>
<fmt:message bundle="${loc}" key="confirmPassword" var="confirmPassword"/>
<fmt:message bundle="${loc}" key="loginValidationMessage" var="loginMessage"/>
<fmt:message bundle="${loc}" key="passwordValidationMessage" var="passMessage"/>
<fmt:message bundle="${loc}" key="confirmPasswordMessage" var="passConfirmMessage"/>
<fmt:message bundle="${loc}" key="passIsNotMatch" var="passError"/>
<fmt:message bundle="${loc}" key="name" var="name"/>
<fmt:message bundle="${loc}" key="surname" var="surname"/>
<fmt:message bundle="${loc}" key="email" var="email"/>
<fmt:message bundle="${loc}" key="address" var="address"/>
<fmt:message bundle="${loc}" key="phonenumber" var="phonenumber"/>
<fmt:message bundle="${loc}" key="requiredFields" var="requiredFields"/>
<fmt:message bundle="${loc}" key="phonenumberValidationMessage" var="phoneMessage"/>
<fmt:message bundle="${loc}" key="emailValidationMessage" var="emailMessage"/>


<c:set var="loginPattern" value="^[a-zA-Z0-9]{4,16}$"/>
<c:set var="passwordPattern" value="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d-]{8,30}$"/>
<c:set var="phonenumberPattern" value="^\\+375\d{9}$"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${registration}</title>
</head>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<body>
<div class="registration-heading">

    <form action="controller" method="post">
        <fieldset>
            <input type="hidden" name="command" value="registration">
            <legend>${registration}</legend>
            <p>
                <label for="login">${login}<span class="required">*</span> </label>
                <input autofocus required pattern="${loginPattern}" id="login" type="text" name="login" value=""
                       autocomplete="new-login"
                       oninvalid="this.setCustomValidity('${loginMessage}')"
                       onchange="this.setCustomValidity('')" oninput="this.setCustomValidity('')">
            </p>
            <p>
                <label for="password">${pass}<span class="required">*</span> </label>
                <input required id="password" pattern="${passwordPattern}" type="password" name="password" value=""
                       autocomplete="new-password"

                       oninvalid="this.setCustomValidity('${passMessage}')"
                       onchange="this.setCustomValidity('')" oninput="this.setCustomValidity('')">
            </p>
            <p>
                <label for="confirm-password">${confirmPassword}<span class="required">*</span> </label>
                <input required id="confirm-password" pattern="${passwordPattern}" type="password"
                       name="passwordConfirm" value="">
            </p>

            <p>
                <label for="email">${email}<span class="required">*</span> </label>
                <input required id="email" type="email" name="email" value="" placeholder="example@gmail.com"
                       oninvalid="this.setCustomValidity('${emailMessage}')"
                       onchange="this.setCustomValidity('')" oninput="this.setCustomValidity('')">
            </p>
            <p>
                <label for="name">${name} </label>
                <input id="name" type="text" name="name" value="">
            </p>
            <p>
                <label for="surname">${surname} </label>
                <input id="surname" type="text" name="surname" value="">
            </p>

            <p>
                <label for="address">${address} </label>
                <input id="address" type="text" name="address" value="">
            </p>
            <p>
                <label for="phonenumber">${phonenumber}<span class="required">*</span> </label>
                <input id="phonenumber" type="tel" name="phonenumber" value="" pattern="${phonenumberPattern}"
                       placeholder="+375123456789"
                       oninvalid="this.setCustomValidity('${phoneMessage}')"
                       onchange="this.setCustomValidity('')" oninput="this.setCustomValidity('')">
            </p>
            <p style="display: flex;justify-content: flex-start;">
                <span class="required">*</span>&nbsp${requiredFields}
            </p>
            <input id="login-submit" type="submit" value="${signUp}">
        </fieldset>
    </form>
</div>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>


<%--Passwords confirmation check--%>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        let pass1 = document.querySelector('#password'),
            pass2 = document.querySelector('#confirm-password')

        pass1.addEventListener('input', function () {
            this.value !== pass2.value ? pass2.setCustomValidity('${passError}') : pass2.setCustomValidity('')
        })

        pass2.addEventListener('input', function () {
            this.value !== pass1.value ? this.setCustomValidity('${passError}') : this.setCustomValidity('')
        })
    })
</script>
</body>
</html>

