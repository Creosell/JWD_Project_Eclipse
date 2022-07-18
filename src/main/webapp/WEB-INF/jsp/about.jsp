<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization" var="loc"/>
<fmt:message bundle="${loc}" key="title_about_page" var="title"/>
<%--<fmt:message bundle="${loc}" key="" var=""/>--%>
<fmt:message bundle="${loc}" key="about_us" var="aboutUs"/>

<html>
<head>
    <title>${title}</title>

</head>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/header.jsp"/>
<body>
<div class="page-heading about-heading header-text">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="text-content">
                    <h4>${aboutUs}</h4>
                    <h2>Smart Things</h2>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="best-features about-features">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <h2>Our Background</h2>
                </div>
            </div>
            <div class="col-md-6">
                <div class="right-image">
                    <img alt="" src="${pageContext.request.contextPath}/assets/images/feature-image.jpg">
                </div>
            </div>
            <div class="col-md-6">
                <div class="left-content">
                    <h4>Who we are &amp; What we do?</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sed voluptate nihil eum consectetur
                        similique? Consectetur, quod, incidunt, harum nisi dolores delectus reprehenderit voluptatem
                        perferendis dicta dolorem non blanditiis ex fugiat. Lorem ipsum dolor sit amet, consectetur
                        adipisicing elit.<br><br>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et,
                        consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium
                        quibusdam? Aut, in eum facere corrupti necessitatibus perspiciatis quis.</p>
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


<div class="team-members">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <h2>Our Team Members</h2>
                </div>
            </div>
            <div class="col-md-4">
                <div class="team-member">
                    <div class="thumb-container">
                        <img alt="" src="${pageContext.request.contextPath}/assets/images/team_01.jpg">
                        <div class="hover-effect">
                            <div class="hover-content">
                                <ul class="social-icons">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-behance"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="down-content">
                        <h4>Johnny William</h4>
                        <span>CO-Founder</span>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing itaque corporis nulla.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="team-member">
                    <div class="thumb-container">
                        <img alt="" src="${pageContext.request.contextPath}/assets/images/team_02.jpg">
                        <div class="hover-effect">
                            <div class="hover-content">
                                <ul class="social-icons">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-behance"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="down-content">
                        <h4>Karry Pitcher</h4>
                        <span>Product Expert</span>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing itaque corporis nulla.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="team-member">
                    <div class="thumb-container">
                        <img alt="" src="${pageContext.request.contextPath}/assets/images/team_03.jpg">
                        <div class="hover-effect">
                            <div class="hover-content">
                                <ul class="social-icons">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-behance"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="down-content">
                        <h4>Michael Soft</h4>
                        <span>Chief Marketing</span>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing itaque corporis nulla.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="team-member">
                    <div class="thumb-container">
                        <img alt="" src="${pageContext.request.contextPath}/assets/images/team_04.jpg">
                        <div class="hover-effect">
                            <div class="hover-content">
                                <ul class="social-icons">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-behance"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="down-content">
                        <h4>Mary Cool</h4>
                        <span>Product Specialist</span>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing itaque corporis nulla.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="team-member">
                    <div class="thumb-container">
                        <img alt="" src="${pageContext.request.contextPath}/assets/images/team_05.jpg">
                        <div class="hover-effect">
                            <div class="hover-content">
                                <ul class="social-icons">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-behance"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="down-content">
                        <h4>George Walker</h4>
                        <span>Product Photographer</span>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing itaque corporis nulla.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="team-member">
                    <div class="thumb-container">
                        <img alt="" src="${pageContext.request.contextPath}/assets/images/team_06.jpg">
                        <div class="hover-effect">
                            <div class="hover-content">
                                <ul class="social-icons">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-behance"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="down-content">
                        <h4>Kate Town</h4>
                        <span>General Manager</span>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing itaque corporis nulla.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="services">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="service-item">
                    <div class="icon">
                        <i class="fa fa-gear"></i>
                    </div>
                    <div class="down-content">
                        <h4>Product Management</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur an adipisicing elit. Itaque, corporis nulla at quia
                            quaerat.</p>
                        <a class="filled-button" href="#">Read More</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="service-item">
                    <div class="icon">
                        <i class="fa fa-gear"></i>
                    </div>
                    <div class="down-content">
                        <h4>Customer Relations</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur an adipisicing elit. Itaque, corporis nulla at quia
                            quaerat.</p>
                        <a class="filled-button" href="#">Details</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="service-item">
                    <div class="icon">
                        <i class="fa fa-gear"></i>
                    </div>
                    <div class="down-content">
                        <h4>Global Collection</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur an adipisicing elit. Itaque, corporis nulla at quia
                            quaerat.</p>
                        <a class="filled-button" href="#">Read More</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="happy-clients">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="section-heading">
                    <h2>Happy Partners</h2>
                </div>
            </div>
            <div class="col-md-12">
                <div class="owl-clients owl-carousel">
                    <div class="client-item">
                        <img alt="1" src="${pageContext.request.contextPath}/assets/images/client-01.png">
                    </div>

                    <div class="client-item">
                        <img alt="2" src="${pageContext.request.contextPath}/assets/images/client-01.png">
                    </div>

                    <div class="client-item">
                        <img alt="3" src="${pageContext.request.contextPath}/assets/images/client-01.png">
                    </div>

                    <div class="client-item">
                        <img alt="4" src="${pageContext.request.contextPath}/assets/images/client-01.png">
                    </div>

                    <div class="client-item">
                        <img alt="5" src="${pageContext.request.contextPath}/assets/images/client-01.png">
                    </div>

                    <div class="client-item">
                        <img alt="6" src="${pageContext.request.contextPath}/assets/images/client-01.png">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/jsp/footer.jsp"/>


<!-- Bootstrap core JavaScript -->
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


<!-- Additional Scripts -->
<script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/owl.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/slick.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/isotope.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/accordions.js"></script>
</body>
</html>
