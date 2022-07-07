<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="localization_button.en" var="en_button"/>
<fmt:message bundle="${loc}" key="localization_button.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="welcome_message" var="welcome_message"/>
<head>
    <title>Header title</title></head>
<body>
<div>
    <form action="controller" method="post">
        <input type="hidden" name="local" value="ru"/> <input type="submit" value="${ru_button}">
    </form>
    <form action="controller" method="post">
        <input type="hidden" name="local" value="en"/> <input type="submit" value="${en_button}">
    </form>
</div>
<h1>${welcome_message}</h1>
</body>
</html>
