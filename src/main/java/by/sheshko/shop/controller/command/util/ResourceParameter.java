package by.sheshko.shop.controller.command.util;

import java.util.ResourceBundle;

public class ResourceParameter {
    static final ResourceBundle pages = ResourceBundle.getBundle("pages");
    static final ResourceBundle localization = ResourceBundle.getBundle("localization");

    public static final String ERROR_PAGE = pages.getString("page.error");
    public static final String REGISTRATION_PAGE = pages.getString("page.registration");
    public static final String HOME_PAGE = pages.getString("page.homepage");
    public static final String LOG_IN_PAGE = pages.getString("page.logIn");

    public static final String WELCOME_MESSAGE = localization.getString("welcome_message");
}
