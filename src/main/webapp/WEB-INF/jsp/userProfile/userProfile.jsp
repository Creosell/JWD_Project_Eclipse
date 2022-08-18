<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="title_user_profile" var="title"/>
<%--<fmt:message bundle="${loc}" key="" var=""/>--%>
<fmt:message bundle="${loc}" key="name" var="name"/>
<fmt:message bundle="${loc}" key="surname" var="surname"/>
<fmt:message bundle="${loc}" key="email" var="email"/>
<fmt:message bundle="${loc}" key="address" var="address"/>
<fmt:message bundle="${loc}" key="phonenumber" var="phonenumber"/>
<fmt:message bundle="${loc}" key="registration_time" var="registrationTime"/>
<fmt:message bundle="${loc}" key="edit_profile" var="editProfile"/>

<html>
<head>
    <title>${title}</title>

</head>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/header.jsp"/>
<body>
<div class="profile-heading">
    <div>
        <h2 class="text-center">${title}</h2>
        <p>${name} : ${sessionScope.user.name}</p>
        <p>${surname} : ${sessionScope.user.surname}</p>
        <p>${email} : ${sessionScope.user.email}</p>
        <p>${address} : ${sessionScope.user.address}</p>
        <p>${phonenumber} : ${sessionScope.user.phonenumber}</p>
        <p>${registrationTime} : ${sessionScope.user.registrationTime}</p>

        <form action="controller" method="get">
            <input type="hidden" name="command" value="forward_command">
            <input type="hidden" name="target" value="editProfile">
            <input type="submit" value="${editProfile}">
        </form>



    </div>
</div>
</body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/footer.jsp"/>
</html>
