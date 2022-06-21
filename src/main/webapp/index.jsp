<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Smart Things - интернет-магазин в Беларуси</title>
</head>
<body>
<jsp:useBean id="userInfo" class="by.sheshko.shop.bean.UserSessionInfo"/>
<h1>Приветствуем в нашем интернет-магазине Smart Things!</h1>

<br>
<div id="loginForm"><form name="loginForm" action="controller" method="post">
    <input type="hidden" name="command" value="sign_in">
    <input type="text" name="login" value="" placeholder="Введите ваш логин...">
    <input type="password" name="password" value="" placeholder="Введите ваш пароль...">
    <input type="submit" value="Войти">
</form></div>
<div id="registrationButton"><form action="registration" method="post">
    <input type="submit" value="Регистрация">
</form></div>
<br>
<form action="controller" method="post">
    <input type="hidden" name="command" value="sign_out">
    <input type="submit" value="Выйти из системы">
</form>


</body>
</html>