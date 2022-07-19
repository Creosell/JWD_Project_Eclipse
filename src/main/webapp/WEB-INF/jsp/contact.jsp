<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="title_contact_us" var="title"/>
<%--<fmt:message bundle="${loc}" key="" var=""/>--%>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/header.jsp"/>
<div class="page-heading contact-heading header-text">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="text-content">
                    <h4>contact us</h4>
                    <h2>let’s get in touch</h2>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="find-us">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <h2>Our Location on Maps</h2>
                </div>
            </div>
            <div class="col-md-8">
                <!-- How to change your own map point
                    1. Go to Google Maps
                    2. Click on your location point
                    3. Click "Share" and choose "Embed map" tab
                    4. Copy only URL and paste it within the src="" field below
                -->
                <div id="map">
                    <iframe allowfullscreen
                            height="330px"
                            src="https://maps.google.com/maps?q=Av.+L%C3%BAcio+Costa,+Rio+de+Janeiro+-+RJ,+Brazil&t=&z=13&ie=UTF8&iwloc=&output=embed"
                            style="border:0" width="100%"></iframe>
                </div>
            </div>
            <div class="col-md-4">
                <div class="left-content">
                    <h4>About our office</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisic elit. Sed voluptate nihil eumester consectetur
                        similiqu consectetur.<br><br>Lorem ipsum dolor sit amet, consectetur adipisic elit. Et,
                        consequuntur, modi mollitia corporis ipsa voluptate corrupti.</p>
                    <ul class="social-icons">
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#"><i class="fa fa-behance"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="send-message">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <h2>Send us a Message</h2>
                </div>
            </div>
            <div class="col-md-8">
                <div class="contact-form">
                    <form action="" id="contact" method="post">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12">
                                <fieldset>
                                    <input class="form-control" id="name" name="name" placeholder="Full Name"
                                           required="" type="text">
                                </fieldset>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12">
                                <fieldset>
                                    <input class="form-control" id="email" name="email" placeholder="E-Mail Address"
                                           required="" type="text">
                                </fieldset>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12">
                                <fieldset>
                                    <input class="form-control" id="subject" name="subject" placeholder="Subject"
                                           required="" type="text">
                                </fieldset>
                            </div>
                            <div class="col-lg-12">
                                <fieldset>
                                    <textarea class="form-control" id="message" name="message"
                                              placeholder="Your Message"
                                              required="" rows="6"></textarea>
                                </fieldset>
                            </div>
                            <div class="col-lg-12">
                                <fieldset>
                                    <button class="filled-button" id="form-submit" type="submit">Send Message</button>
                                </fieldset>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-4">
                <ul class="accordion">
                    <li>
                        <a>Accordion Title One</a>
                        <div class="content">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisic elit. Sed voluptate nihil eumester
                                consectetur similiqu consectetur.<br><br>Lorem ipsum dolor sit amet, consectetur
                                adipisic elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti elite.
                            </p>
                        </div>
                    </li>
                    <li>
                        <a>Second Title Here</a>
                        <div class="content">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisic elit. Sed voluptate nihil eumester
                                consectetur similiqu consectetur.<br><br>Lorem ipsum dolor sit amet, consectetur
                                adipisic elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti elite.
                            </p>
                        </div>
                    </li>
                    <li>
                        <a>Accordion Title Three</a>
                        <div class="content">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisic elit. Sed voluptate nihil eumester
                                consectetur similiqu consectetur.<br><br>Lorem ipsum dolor sit amet, consectetur
                                adipisic elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti elite.
                            </p>
                        </div>
                    </li>
                    <li>
                        <a>Fourth Accordion Title</a>
                        <div class="content">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisic elit. Sed voluptate nihil eumester
                                consectetur similiqu consectetur.<br><br>Lorem ipsum dolor sit amet, consectetur
                                adipisic elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti elite.
                            </p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="happy-clients">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <h2>Our Happy Customers</h2>
                </div>
            </div>
            <div class="col-md-12">
                <div class="owl-clients owl-carousel">
                    <div class="client-item">
                        <img alt="1" src="../../assets/images/client-01.png">
                    </div>

                    <div class="client-item">
                        <img alt="2" src="../../assets/images/client-01.png">
                    </div>

                    <div class="client-item">
                        <img alt="3" src="../../assets/images/client-01.png">
                    </div>

                    <div class="client-item">
                        <img alt="4" src="../../assets/images/client-01.png">
                    </div>

                    <div class="client-item">
                        <img alt="5" src="../../assets/images/client-01.png">
                    </div>

                    <div class="client-item">
                        <img alt="6" src="../../assets/images/client-01.png">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
