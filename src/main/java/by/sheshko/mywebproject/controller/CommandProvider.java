package by.sheshko.mywebproject.controller;

import by.sheshko.mywebproject.controller.command.Command;
import by.sheshko.mywebproject.controller.command.CommandName;
import by.sheshko.mywebproject.controller.command.impl.Registration;
import by.sheshko.mywebproject.controller.command.impl.SignIn;
import by.sheshko.mywebproject.controller.command.impl.WrongRequest;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.REGISTRATION, new Registration());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Error while getting command from repository\n" + e);
            command = repository.get(CommandName.WRONG_REQUEST);

        }
        return command;
    }
}
