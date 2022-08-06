package by.sheshko.shop.controller;

import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.controller.command.CommandName;
import by.sheshko.shop.controller.command.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static by.sheshko.shop.controller.command.CommandName.*;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    CommandProvider() {
        repository.put(SIGN_IN, new SignIn());
        repository.put(REGISTRATION, new Registration());
        repository.put(WRONG_REQUEST, new WrongRequest());
        repository.put(USER_INFO, new UserInfo());
        repository.put(FORWARD_COMMAND, new ForwardCommand());
        repository.put(CHANGE_LOCAL, new ChangeLocal());
        repository.put(SIGN_OUT, new SignOut());
    }

    Command getCommand(final String name) {
        CommandName commandName;
        Command command;

        try {
            commandName = valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Error while getting command from repository", e);
            command = repository.get(WRONG_REQUEST);
        }
        return command;
    }
}
