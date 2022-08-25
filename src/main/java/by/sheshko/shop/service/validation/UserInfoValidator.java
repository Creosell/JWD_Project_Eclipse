package by.sheshko.shop.service.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInfoValidator {
    private static final String USERNAME_PATTERN =
            "^[a-zA-Z0-9]{4,16}$";
    private static final String PASSWORD_PATTERN =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d-]{8,30}$";
    private static final String PHONENUMBER_PATTERN =
            "^\\+375\\d{9}$";
    private static final Logger log = LoggerFactory.getLogger(UserInfoValidator.class);
    private static Pattern pattern;
    private static Matcher matcher;
    private static String result;

    public static boolean validateUsername(final String username) {
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(username);

        return matcher.matches();
    }

    public static boolean validatePassword(final String password) {
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static boolean validatePhonenumber(final String phonenumber) {
        pattern = Pattern.compile(PHONENUMBER_PATTERN);
        matcher = pattern.matcher(phonenumber);

        return matcher.matches();
    }

}
