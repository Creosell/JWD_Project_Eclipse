package by.sheshko.mywebproject.controller.command.impl;

import by.sheshko.mywebproject.controller.command.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) {
        return "Wrong request";
    }
}
