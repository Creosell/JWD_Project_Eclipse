package by.sheshko.shop.controller.command.util;

import java.util.ResourceBundle;

public final class ResourceParameter {
    static final ResourceBundle pages = ResourceBundle.getBundle("pages");
    public static final String ERROR_PAGE = pages.getString("page.error");
    public static final String REGISTRATION_PAGE = pages.getString("page.registration");
    public static final String HOME_PAGE = pages.getString("page.homepage");
    public static final String LOG_IN_PAGE = pages.getString("page.logIn");
    public static final String PRODUCT_PAGE = pages.getString("page.products");
    public static final String CONTACT_PAGE = pages.getString("page.contact");
    public static final String REGISTRATION_SUCCESS = pages.getString("page.registrationSuccess");

    static final ResourceBundle localization = ResourceBundle.getBundle("localization");

    public static final String WELCOME_MESSAGE = localization.getString("welcome_message");



    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
}
