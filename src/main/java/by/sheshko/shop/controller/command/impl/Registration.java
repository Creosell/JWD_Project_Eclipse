package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.controller.exception.ControllerException;
import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.exception.ServiceException;
import by.sheshko.shop.service.factory.ServiceFactory;

public class Registration implements Command {
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
            user = new User(login, password);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Login or password is empty");
            throw new ControllerException("Login or password is empty", e);
        }


        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientServiceImpl();

        try {
            clientService.registration(user);
            response = "New user with login " + user.getLogin() + " was successfully created!";
        } catch (ServiceException e) {
            System.out.println("Error while registering new user\n" + e.getMessage());
            response = "Error while registering new user";
            throw new ControllerException(e.getMessage());
        }

        return response;
    }
}
