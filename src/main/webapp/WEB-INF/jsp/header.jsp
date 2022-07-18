<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${sessionScope.language==null}">
    <c:set scope="session" var="language" value="en"/>
</c:if>

<c:if test="${language != null}">
    <fmt:setLocale value="${sessionScope.language}"/>
</c:if>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="localization_button.en" var="en_button"/>
<fmt:message bundle="${loc}" key="localization_button.ru" var="ru_button"/>
<%--<fmt:message bundle="${loc}" key="" var=""/>--%>
<fmt:message bundle="${loc}" key="about_us" var="aboutUs"/>
<fmt:message bundle="${loc}" key="homepage" var="homepage"/>
<fmt:message bundle="${loc}" key="contact_us" var="contactUs"/>
<fmt:message bundle="${loc}" key="our_products" var="ourProducts"/>

<%--<c:set scope="session" var="message" value="${sessionScope.message}"/>
<c:out value="${message}"/>

<c:if test="${message!=null}">
    <script type="text/javascript">
        let msg = "${message}";
        alert(msg);
    </script>
</c:if>
<c:set scope="session" var="message" value="${null}"/>--%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap"
          rel="stylesheet">

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Additional CSS Files -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/fontawesome.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/assets/css/templatemo-sixteen.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/owl.css">
    <title></title>
</head>

<body>
<header class="">
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <a class="navbar-brand" href="controller?command=forward_command&target=homepage"><h2>Smart <em>Things</em>
            </h2></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="controller?command=forward_command&target=homepage">${homepage}
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=forward_command&target=products">${ourProducts}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=forward_command&target=about">${aboutUs}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="controller?command=forward_command&target=contact">${contactUs}</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<!-- Bootstrap core JavaScript -->
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


<!-- Additional Scripts -->
<script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/owl.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/slick.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/isotope.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/accordions.js"></script>
<%--<div>
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
&lt;%&ndash;<div>
   <a href="controller?command=change_local&language=en">${en_button}</a>
    <br>
    <a href="controller?command=change_local&language=ru">${ru_button}</a>
</div>&ndash;%&gt;
<h1>${welcome_message}</h1>--%>
</body>


</html>
