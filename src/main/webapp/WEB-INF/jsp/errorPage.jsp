<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="error" var="error"/>
<fmt:message bundle="${loc}" key="request_error" var="req_error"/>
<fmt:message bundle="${loc}" key="homepage" var="homepage"/>

<head>
    <title>${error}</title>
</head>
<body>
<h1>${req_error}</h1>
<a href="${pageContext.request.contextPath}/index.jsp">${homepage}</a>
</body>
</html>
