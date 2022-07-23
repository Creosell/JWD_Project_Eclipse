package by.sheshko.shop.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInfoValidator {
    private static final String USERNAME_PATTERN =
            "^[a-zA-Z0-9]{5,16}$";
    private static final String PASSWORD_PATTERN =
            "^\\w{8,20}$";//todo проверить длину символов


    public static boolean validateUsername(final String username) {
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static boolean validatePassword(final String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
