package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.controller.ControllerException;
import by.sheshko.shop.controller.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;

public final class ForwardCommand implements Command {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        String page = null;
        final ResourceBundle pages = ResourceBundle.getBundle("pages");

        try {
            page = pages.getString("page." + request.getParameter("target"));
        } catch (NullPointerException e) { //todo норм эксепшн
            log.error("Error finding a page", e);
            page = pages.getString("page.error");
        }
        return page;
    }
}

