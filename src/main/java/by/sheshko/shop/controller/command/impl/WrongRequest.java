package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.controller.ControllerException;
import by.sheshko.shop.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class WrongRequest implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
return null;
    }

    /*@Override
    public String execute(final String request) {

        return request;
    }*/
}
