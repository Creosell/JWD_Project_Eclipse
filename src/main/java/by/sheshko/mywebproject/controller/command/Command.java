package by.sheshko.mywebproject.controller.command;

import by.sheshko.mywebproject.controller.exception.ControllerException;

public interface Command {
    String execute(String request) throws ControllerException;
}
