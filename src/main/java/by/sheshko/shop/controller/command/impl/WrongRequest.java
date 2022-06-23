package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.controller.command.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) {

        return request;
    }
}
