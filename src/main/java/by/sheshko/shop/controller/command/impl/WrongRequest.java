package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.controller.command.Command;

public final class WrongRequest implements Command {

    @Override
    public String execute(final String request) {

        return request;
    }
}
