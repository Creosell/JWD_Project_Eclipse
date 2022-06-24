package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.controller.ControllerException;
import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.ServiceException;
import by.sheshko.shop.service.factory.ServiceFactory;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Registration implements Command {
    private final Logger log = LogManager.getLogger(this.getClass());

    @Override
    public String execute(String request) throws ControllerException {
        String login = null;
        String password = null;
        String response = null;
        User user;

        try {
            String[] requestParameters = request.split(" ");
            login = requestParameters[0];
            password = requestParameters[1];

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ControllerException("Login or password is empty", e);
        }


        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientServiceImpl();

        try {
            clientService.registration(login, password);
            response = "New user with login " + login + " was successfully created!";
        } catch (ServiceException e) {
            log.log(Level.ERROR, "Error while registering new user", e);
            throw new ControllerException(e.getMessage());
        }
        return response;
    }
}
