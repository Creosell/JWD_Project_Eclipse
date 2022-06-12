package by.sheshko.shop.controller.command;

import by.sheshko.shop.controller.exception.ControllerException;

public interface Command {
    String execute(String request) throws ControllerException;
}
