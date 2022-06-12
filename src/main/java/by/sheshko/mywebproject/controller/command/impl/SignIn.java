package by.sheshko.mywebproject.controller.command.impl;

import by.sheshko.mywebproject.controller.command.Command;
import by.sheshko.mywebproject.controller.exception.ControllerException;
import by.sheshko.mywebproject.service.ClientService;
import by.sheshko.mywebproject.service.exception.ServiceException;
import by.sheshko.mywebproject.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        String login = null;
        String password = null;
        String response = null;

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
