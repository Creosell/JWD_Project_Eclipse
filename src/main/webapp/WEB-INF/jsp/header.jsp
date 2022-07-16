<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${sessionScope.language==null}">
    <c:set scope="session" var="language" value="en"/>
</c:if>

<c:if test="${language != null}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>
<%--<c:choose>
    <c:when test="${language != null}">
        <fmt:setLocale value="${sessionScope.language}"/>
    </c:when>
    <c:otherwise>
        <fmt:setLocale value="en"/>
    </c:otherwise>
</c:choose>--%>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="localization_button.en" var="en_button"/>
<fmt:message bundle="${loc}" key="localization_button.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="welcome_message" var="welcome_message"/>

<c:set scope="session" var="message" value="${sessionScope.message}"/>
<c:out value="${message}"/>

<c:if test="${message!=null}">
    <script type="text/javascript">
        let msg = "${message}";
        alert(msg);
    </script>
</c:if>
<c:set scope="session" var="message" value="${null}"/>
<html>
<head>
    <title>Header title</title></head>
<body>

<div>
    <form action="controller" method="post">
        <input type="hidden" name="language" value="ru">
        <input type="hidden" name="command" value="change_local"/>
        <input type="submit" value="${ru_button}">
    </form>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="change_local"/>
        <input type="hidden" name="language" value="en">
        <input type="submit" value="${en_button}">
    </form>
</div>
<%--<div>
   <a href="controller?command=change_local&language=en">${en_button}</a>
    <br>
    <a href="controller?command=change_local&language=ru">${ru_button}</a>
</div>--%>
<h1>${welcome_message}</h1>
</body>


</html>
