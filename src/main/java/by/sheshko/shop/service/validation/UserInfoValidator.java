package by.sheshko.shop.service.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInfoValidator {
    private static Pattern pattern;
    private static Matcher matcher;
    private static String result;
    private static final String USERNAME_PATTERN =
            "^[a-zA-Z0-9]{4,16}$";
    private static final String PASSWORD_PATTERN =
            "^\\w{8,32}$";
    private static final Logger log = LoggerFactory.getLogger(UserInfoValidator.class);


    public static String validateUsername(final String username) {
        log.info("User validation. Username: {}",username);
        if (username == null) {
            return result = "Empty username";
        }

        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(username);

        /*if (matcher.matches()) {
            result = "Correct";
        } else {
            result = "Incorrect";
        }*/
        return result = matcher.matches() ? "Correct" : "Incorrect";
    }

    public static String validatePassword(final String password) {
        log.info("User validation. Password: {}", password);
        if (password == null) {
            return result = "Empty password";
        }

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return result = matcher.matches() ? "Correct" : "Incorrect";
    }
}
