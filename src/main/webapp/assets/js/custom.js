//Hiding nav-items for not authorised users
/*document.addEventListener('DOMContentLoaded', checkAuthorization);

function checkAuthorization(userId) {
    alert(userId)
    if (userId !== 0) {
        hideSignUp();
    } else {
        hideDropdownMenu();
    }
}

function hideDropdownMenu() {
    document.getElementById("nav-item-sign-up").classList.remove("d-none");
    document.getElementById("nav-item-dropdown-menu").classList.add("d-none");
}

function hideSignUp() {
    document.getElementById("nav-item-sign-up").classList.add("d-none");
    document.getElementById("nav-item-dropdown-menu").classList.remove("d-none");
}*/
//Product page item counter
/*document.querySelectorAll('.count .plus').forEach(item => {

    item.addEventListener('click', function () {

        ++item.parentElement.querySelector('input').value;

        if (item.parentElement.querySelector('input').value > 1) {

            item.parentElement.querySelector('.minus').classList.remove('min');

        }

    });

});

document.querySelectorAll('.count .minus').forEach(item => {

    item.addEventListener('click', function () {

        --item.parentElement.querySelector('input').value;

        if (item.parentElement.querySelector('input').value < 2) {

            item.parentElement.querySelector('input').value = 1

            item.classList.add('min');

        }

    });

});*/


//Nav-items active script
for (let navElement of document.getElementsByClassName("nav-item")) {
    let currentActiveElement;
    if (navElement.classList.contains("active")) {
        currentActiveElement = navElement;
        navElement.classList.remove("active");

        if (document.URL.indexOf("homepage") > -1) {
            document.getElementById("nav-item-homepage").classList.add("active");
        } else if (document.URL.indexOf("products") > -1) {
            document.getElementById("nav-item-products").classList.add("active");
        } else if (document.URL.indexOf("about") > -1) {
            document.getElementById("nav-item-about").classList.add("active");
        } else if (document.URL.indexOf("contact") > -1) {
            document.getElementById("nav-item-contact").classList.add("active");
        } else if (document.URL.indexOf("logIn") > -1) {
            document.getElementById("nav-item-sign-up").classList.add("active");
        } else if (document.URL.indexOf("registration") > -1) {
            document.getElementById("nav-item-sign-up").classList.add("active");
        } else {
            currentActiveElement.classList.add("active");
        }
    }
}


jQuery(document).ready(function ($) {


    "use strict";


    $(function () {
        $("#tabs").tabs();
    });

    // Page loading animation

    $("#preloader").animate({
        'opacity': '0'
    }, 600, function () {
        setTimeout(function () {
            $("#preloader").css("visibility", "hidden").fadeOut();
        }, 300);
    });


    $(window).scroll(function () {
        var scroll = $(window).scrollTop();
        var box = $('.header-text').height();
        var header = $('header').height();

        if (scroll >= box - header) {
            $("header").addClass("background-header");
        } else {
            $("header").removeClass("background-header");
        }
    });
    if ($('.owl-clients').length) {
        $('.owl-clients').owlCarousel({
            loop: true,
            nav: false,
            dots: true,
            items: 1,
            margin: 30,
            autoplay: false,
            smartSpeed: 700,
            autoplayTimeout: 6000,
            responsive: {
                0: {
                    items: 1,
                    margin: 0
                },
                460: {
                    items: 1,
                    margin: 0
                },
                576: {
                    items: 3,
                    margin: 20
                },
                992: {
                    items: 5,
                    margin: 30
                }
            }
        });
    }
    if ($('.owl-testimonials').length) {
        $('.owl-testimonials').owlCarousel({
            loop: true,
            nav: false,
            dots: true,
            items: 1,
            margin: 30,
            autoplay: false,
            smartSpeed: 700,
            autoplayTimeout: 6000,
            responsive: {
                0: {
                    items: 1,
                    margin: 0
                },
                460: {
                    items: 1,
                    margin: 0
                },
                576: {
                    items: 2,
                    margin: 20
                },
                992: {
                    items: 2,
                    margin: 30
                }
            }
        });
    }
    if ($('.owl-banner').length) {
        $('.owl-banner').owlCarousel({
            loop: true,
            nav: false,
            dots: true,
            items: 1,
            margin: 0,
            autoplay: false,
            smartSpeed: 700,
            autoplayTimeout: 6000,
            responsive: {
                0: {
                    items: 1,
                    margin: 0
                },
                460: {
                    items: 1,
                    margin: 0
                },
                576: {
                    items: 1,
                    margin: 20
                },
                992: {
                    items: 1,
                    margin: 30
                }
            }
        });
    }

    $(".Modern-Slider").slick({
        autoplay: true,
        autoplaySpeed: 10000,
        speed: 600,
        slidesToShow: 1,
        slidesToScroll: 1,
        pauseOnHover: false,
        dots: true,
        pauseOnDotsHover: true,
        cssEase: 'linear',
        // fade:true,
        draggable: false,
        prevArrow: '<button class="PrevArrow"></button>',
        nextArrow: '<button class="NextArrow"></button>',
    });

    $('.filters ul li').click(function () {
        $('.filters ul li').removeClass('active');
        $(this).addClass('active');

        var data = $(this).attr('data-filter');
        $grid.isotope({
            filter: data
        })
    });

    var $grid = $(".grid").isotope({
        itemSelector: ".all",
        percentPosition: true,
        masonry: {
            columnWidth: ".all"
        }
    })
    $('.accordion > li:eq(0) a').addClass('active').next().slideDown();

    $('.accordion a').click(function (j) {
        var dropDown = $(this).closest('li').find('.content');

        $(this).closest('.accordion').find('.content').not(dropDown).slideUp();

        if ($(this).hasClass('active')) {
            $(this).removeClass('active');
        } else {
            $(this).closest('.accordion').find('a.active').removeClass('active');
            $(this).addClass('active');
        }

        dropDown.stop(false, true).slideToggle();

        j.preventDefault();
    });

    /* $('.nav-item').click(function (j) {
         const dropDown = $(this).closest('li').find('.content');

         $(this).closest('.nav-link').find('.content').not(dropDown).slideUp();

         if ($(this).hasClass('active')) {
             $(this).removeClass('active');
         } else {
             $(this).closest('.nav-link').find('.active').removeClass('active');
             $(this).addClass('active');
         }

         dropDown.stop(false, true).slideToggle();

         j.preventDefault();
     });*/

});


