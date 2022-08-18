<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="edit_profile" var="title"/>
<fmt:message bundle="${loc}" key="name" var="name"/>
<fmt:message bundle="${loc}" key="surname" var="surname"/>
<fmt:message bundle="${loc}" key="email" var="email"/>
<fmt:message bundle="${loc}" key="address" var="address"/>
<fmt:message bundle="${loc}" key="phonenumber" var="phonenumber"/>
<fmt:message bundle="${loc}" key="registration_time" var="registrationTime"/>
<fmt:message bundle="${loc}" key="change_info" var="changeInfo"/>
<fmt:message bundle="${loc}" key="old_password" var="oldPass"/>
<fmt:message bundle="${loc}" key="phonenumber_validation_message" var="phoneMessage"/>
<fmt:message bundle="${loc}" key="email_validation_message" var="emailMessage"/>
<fmt:message bundle="${loc}" key="password_validation_message" var="passMessage"/>
<fmt:message bundle="${loc}" key="confirm_password" var="confirmPassword"/>
<fmt:message bundle="${loc}" key="new_password" var="newPass"/>
<fmt:message bundle="${loc}" key="pass_is_not_match" var="passError"/>
<fmt:message bundle="${loc}" key="required_fields" var="requiredFields"/>

<c:set var="loginPattern" value="^[a-zA-Z0-9]{4,16}$"/>
<c:set var="passwordPattern" value="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d-]{8,30}$"/>
<c:set var="phonenumberPattern" value="^\\+375\d{9}$"/>
<html>
<head>
    <title>${title}</title>

</head>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/header.jsp"/>
<body>
<div class="profile-heading">

    <form action="controller" method="post">
        <fieldset>
            <input type="hidden" name="command" value="EDIT_USER_INFO">
            <legend>${title}</legend>
            <p>
                <label for="name">${name} </label>
                <input autofocus id="name" type="text" name="name" value="${sessionScope.user.name}">
            </p>
            <p>
                <label for="surname">${surname} </label>
                <input id="surname" type="text" name="surname" value="${sessionScope.user.surname}">
            </p>
            <p>
                <label for="email">${email}<span class="required">*</span> </label>
                <input required id="email" type="email" name="email" value="${sessionScope.user.email}"
                       placeholder="example@gmail.com"
                       oninvalid="this.setCustomValidity('${emailMessage}')"
                       onchange="this.setCustomValidity('')" oninput="this.setCustomValidity('')">
            </p>
            <p>
                <label for="address">${address} </label>
                <input id="address" type="text" name="address" value="${sessionScope.user.address}">
            </p>
            <p>
                <label for="phonenumber">${phonenumber} </label>
                <input id="phonenumber" type="tel" name="phonenumber" value="${sessionScope.user.phonenumber}"
                       pattern="${phonenumberPattern}"
                       placeholder="+375123456789"
                       oninvalid="this.setCustomValidity('${phoneMessage}')"
                       onchange="this.setCustomValidity('')" oninput="this.setCustomValidity('')">
            </p>

            <p>
                <label for="password">${newPass}</label>
                <input  id="password" pattern="${passwordPattern}" type="password" name="newPassword" value=""
                       autocomplete="new-password"

                       oninvalid="this.setCustomValidity('${passMessage}')"
                       onchange="this.setCustomValidity('')" oninput="this.setCustomValidity('')">
            </p>
            <p>
                <label for="confirm-password">${confirmPassword}</label>
                <input id="confirm-password" pattern="${passwordPattern}" type="password"
                       name="passwordConfirm" value="">
            </p>
            <p style="display: flex;justify-content: flex-start;">
                <span class="required">*</span>&nbsp${requiredFields}
            </p>
            <input id="login-submit" type="submit" value="${changeInfo}">
        </fieldset>
    </form>
</div>

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

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/footer.jsp"/>
</html>
