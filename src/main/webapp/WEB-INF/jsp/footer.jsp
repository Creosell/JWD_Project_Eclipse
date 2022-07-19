<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<%--<fmt:message bundle="${loc}" key="" var=""/>--%>
<fmt:message bundle="${loc}" key="my_profile" var="myProfile"/>
<fmt:message bundle="${loc}" key="vkontakte" var="vkontakte"/>
<fmt:message bundle="${loc}" key="localization_button.en" var="en_button"/>
<fmt:message bundle="${loc}" key="localization_button.ru" var="ru_button"/>
<!DOCTYPE html>
<html>
<body>
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="inner-content">
                        <div>
                            <p>Copyright &copy; 2022 Pavel Sheshko.
                                ${myProfile}: <a rel="nofollow noopener" href="https://vk.com/id184092437"
                                                 target="_blank">${vkontakte}</a>

                            </p>
                        </div>
                        <div class="switch-language">
                            <a href="controller?command=change_local&language=en">${en_button}</a>
                            <p> | </p>
                            <a href="controller?command=change_local&language=ru">${ru_button}</a>
                        </div>
                    </div>


                    <%--<div class="switch-language">
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
                    </div>--%>


                </div>
            </div>
        </div>
</footer>
</body>
</html>
