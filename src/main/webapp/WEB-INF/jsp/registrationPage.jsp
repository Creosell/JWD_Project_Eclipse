<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 10.06.2022
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Регистрация на сайте</title>
</head>
<body>
<form action="controller" method="post">
    <fieldset>
        <input type="hidden" name="command" value="registration">
        <legend>Регистрация</legend>
        <p><label for="login">Логин </label><input name="login" type="text" id="login"></p>
        <p><label for="password">Пароль </label><input name="password" type="password" id="password"></p>
        <p><input type="submit" value="Зарегистрироваться"></p>
    </fieldset>
</form>
<a href="<c:url value="/index.jsp"/>">Главная страница</a>
</body>
</html>
