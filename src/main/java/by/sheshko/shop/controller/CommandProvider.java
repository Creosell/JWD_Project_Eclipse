package by.sheshko.shop.controller;

import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.controller.command.CommandName;
import by.sheshko.shop.controller.command.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.REGISTRATION, new Registration());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        repository.put(CommandName.USER_INFO, new UserInfo());
        repository.put(CommandName.FORWARD_COMMAND, new ForwardCommand());
    }

    Command getCommand(final String name) {
        CommandName commandName;
        Command command;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Error while getting command from repository", e);
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
