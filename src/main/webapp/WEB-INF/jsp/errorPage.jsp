<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<c:if test="${sessionScope.language==null}">
    <c:set scope="session" var="language" value="en"/>
</c:if>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="error" var="error"/>
<fmt:message bundle="${loc}" key="request_error" var="req_error"/>
<fmt:message bundle="${loc}" key="homepage" var="homepage"/>

<html>
<head>
    <title>${error}</title>
</head>
<body>
<h1>${req_error}</h1>

<c:set var="exception" value="${requestScope['by.sheshko.shop.controller.ControllerException']}"/>
<c:out value="${exception}"/>
<%--<!-- Stack trace -->
<jsp:scriptlet>
  exception.printStackTrace(new java.io.PrintWriter(out));
</jsp:scriptlet>--%>

<%--<c:set var="exception" value="${requestScope.get('javax.servlet.error.exception')}"/>

<c:if test="${exception != null}">
    <h4>${exception}</h4>
    <c:forEach var="stackTraceElem" items="${exception.stackTrace}">
        <c:out value="${stackTraceElem}"/><br/>
    </c:forEach>
</c:if>--%>
<%--<ul>
    <li>Exception: <c:out value="${requestScope.get('javax.servlet.error.exception')}" /></li>
    <li>Exception type: <c:out value="${requestScope['javax.servlet.error.exception_type']}" /></li>
    <li>Exception message: <c:out value="${requestScope['javax.servlet.error.message']}" /></li>
    <li>Request URI: <c:out value="${requestScope['javax.servlet.error.request_uri']}" /></li>
    <li>Servlet name: <c:out value="${requestScope['javax.servlet.error.servlet_name']}" /></li>
    <li>Status code: <c:out value="${requestScope['javax.servlet.error.status_code']}" /></li>
    <li>Stack trace: <pre>${exception.printStackTrace(pageContext.response.writer)}</pre></li>
</ul>--%>
<a href="controller?command=forward_command&target=homepage">${homepage}</a>
</body>
</html>
