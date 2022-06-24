package by.sheshko.shop.controller;

import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.controller.command.CommandName;
import by.sheshko.shop.controller.command.impl.Registration;
import by.sheshko.shop.controller.command.impl.SignIn;
import by.sheshko.shop.controller.command.impl.UserInfo;
import by.sheshko.shop.controller.command.impl.WrongRequest;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();
    private final Logger log = LogManager.getLogger(this.getClass());

    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.REGISTRATION, new Registration());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        repository.put(CommandName.USER_INFO, new UserInfo());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.log(Level.ERROR, "Error while getting command from repository", e);
            command = repository.get(CommandName.WRONG_REQUEST);

        }
        return command;
    }
}
