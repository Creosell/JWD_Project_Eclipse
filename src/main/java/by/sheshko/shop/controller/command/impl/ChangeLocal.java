package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.controller.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class ChangeLocal implements Command {
    private static final String LANGUAGE = "language";
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String sessionLanguage = request.getParameter(LANGUAGE);
        request.getSession().setAttribute(LANGUAGE, sessionLanguage);
        log.info("Language is changed. Value is: {}", sessionLanguage);//todo delete log
        return "/index.jsp";
    }
}
