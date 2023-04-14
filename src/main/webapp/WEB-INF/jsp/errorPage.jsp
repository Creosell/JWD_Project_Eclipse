<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${sessionScope.language==null}">
    <c:set scope="session" var="language" value="en"/>
</c:if>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="error" var="error"/>
<fmt:message bundle="${loc}" key="requestError" var="reqError"/>
<fmt:message bundle="${loc}" key="homepage" var="homepage"/>
<c:set var="lastUsedPage" scope="request" value="${sessionScope.lastUsedPage}"/>
<c:set var="errorMessage" scope="session" value="${sessionScope.errorMessage}"/>
<html>
<head>
    <title>${error}</title>
</head>
<body>
<c:choose>
    <c:when test="${errorMessage != null}">
        <h1>${errorMessage}</h1>
        <c:set var="errorMessage" value="${null}"/>
    </c:when>
    <c:otherwise><h1>${reqError}</h1></c:otherwise>

</c:choose>


<%-- <p>
    ${pageContext.errorData.throwable}
    <c:choose>
        <c:when test="${!empty
    pageContext.errorData.throwable.cause}">
            : ${pageContext.errorData.throwable.cause}
        </c:when>
        <c:when test="${!empty
    pageContext.errorData.throwable.rootCause}">
            : ${pageContext.errorData.throwable.rootCause}
        </c:when>
    </c:choose>
</p> --%>

<a href="controller?command=forward_command&target=homepage">${homepage}</a>
<br>
<a href="controller?command=forward_command&target=${lastUsedPage}">Last page</a>
</body>
</html>
