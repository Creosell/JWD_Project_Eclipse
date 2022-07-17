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
<fmt:message bundle="${loc}" key="log_in" var="log_in"/>
<fmt:message bundle="${loc}" key="login" var="login"/>
<fmt:message bundle="${loc}" key="password" var="password"/>
<fmt:message bundle="${loc}" key="enter_your_login" var="enter_login"/>
<fmt:message bundle="${loc}" key="enter_your_password" var="enter_pass"/>

<head>
    <title>${log_in}</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="controller" method="post">
    <fieldset>
        <input type="hidden" name="command" value="sign_in">
        <legend>${log_in}</legend>
        <input type="text" name="login" value="" placeholder="${enter_login}">
        <input type="password" name="password" value="" placeholder="${enter_pass}">
        <%-- <p><label for="login">${login} </label><input name="login" type="text" id="login"></p>
         <p><label for="password">${password} </label><input name="password" type="password" id="password"></p>--%>
        <p><input type="submit" value="${log_in}"></p>
    </fieldset>
</form>
<a href="controller?command=forward_command&target=homepage">${homepage}</a>
</body>
</html>
