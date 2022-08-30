package by.sheshko.shop.controller.command;

import by.sheshko.shop.controller.ControllerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException;

}
