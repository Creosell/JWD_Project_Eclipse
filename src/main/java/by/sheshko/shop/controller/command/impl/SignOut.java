package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.controller.ControllerException;
import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.controller.command.util.ResourceParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.sheshko.shop.controller.command.util.ResourceParameter.*;

public class SignOut implements Command {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        request.getSession().invalidate();
        return HOME_PAGE;
    }
}
