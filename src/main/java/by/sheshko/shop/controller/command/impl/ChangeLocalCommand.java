package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.controller.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.sheshko.shop.controller.command.util.ResourceParameter.HOME_PAGE;
import static by.sheshko.shop.controller.command.util.ResourceParameter.LANGUAGE;

public final class ChangeLocalCommand implements Command {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String sessionLanguage = request.getParameter(LANGUAGE);
        request.getSession().setAttribute(LANGUAGE, sessionLanguage);
        log.info("Language is changed. Value is: {}", sessionLanguage);//todo delete log
        return HOME_PAGE;
    }

}
