package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.controller.ControllerException;
import by.sheshko.shop.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.sheshko.shop.controller.command.util.ResourceParameter.ERROR_PAGE;

public final class WrongRequest implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        return ERROR_PAGE;
    }

}
