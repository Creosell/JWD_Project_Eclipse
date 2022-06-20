package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.controller.exception.ControllerException;
import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.exception.ServiceException;
import by.sheshko.shop.service.factory.ServiceFactory;

public class SignIn implements Command {
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


            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ClientService clientService = serviceFactory.getClientServiceImpl();

            clientService.singIn(login, password);
            response = "Добро пожаловать, " + login;
        } catch (ServiceException e) {
            System.out.println("Error while log on site for login:" + login + "\n" + e.getMessage());
            response = "Пожалуйста, проверьте ваш логин или пароль";
            throw new ControllerException("Incorrect login or password", e);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ControllerException("Login or password is empty", e);
        }

        return response;
    }
}
