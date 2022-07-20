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
<fmt:message bundle="${loc}" key="log_in" var="log_in"/>
<fmt:message bundle="${loc}" key="login" var="login"/>
<fmt:message bundle="${loc}" key="password" var="password"/>
<fmt:message bundle="${loc}" key="registration" var="registration"/>
<fmt:message bundle="${loc}" key="enter_your_password" var="enter_pass"/>
<fmt:message bundle="${loc}" key="title_log_in" var="title"/>

<head>
    <title>${title}</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/header.jsp"/>
<div class="login-heading">
    <h2>${authorization}</h2>
    <div class="login-fields">
        <div class="login-labels">
            <p>${login}:</p>
            <p>${password}:</p>
        </div>
        <div class="login-fields-input">
            <input type="text" name="login" value="">
            <input type="password" name="password" value="">
        </div>
    </div>

    <div class="login-page-buttons">
        <form>
            <input type="hidden" name="command" value="sign_in">
            <input type="submit" value="${log_in}">
        </form>
        <form>
            <input type="hidden" name="command" value="registration">
            <input type="submit" value="${registration}">
        </form>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
