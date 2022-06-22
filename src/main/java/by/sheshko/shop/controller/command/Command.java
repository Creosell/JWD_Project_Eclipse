package by.sheshko.shop.controller.command;

import by.sheshko.shop.controller.ControllerException;

public interface Command {
    String execute(String request) throws ControllerException;
}
