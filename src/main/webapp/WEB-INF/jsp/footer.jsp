<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<%--<fmt:message bundle="${loc}" key="" var=""/>--%>
<fmt:message bundle="${loc}" key="myProfile" var="myProfile"/>
<fmt:message bundle="${loc}" key="vkontakte" var="vkontakte"/>
<fmt:message bundle="${loc}" key="localizationButtonEn" var="en_button"/>
<fmt:message bundle="${loc}" key="localizationButtonRu" var="ru_button"/>
<!DOCTYPE html>
<html>
<body>
<footer class="sticky-bottom">
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
            </div>
        </div>
    </div>
</footer>
</body>
</html>
