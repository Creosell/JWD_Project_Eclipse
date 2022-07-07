package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.controller.ControllerException;
import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.ServiceException;
import by.sheshko.shop.service.factory.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public final class Registration implements Command {
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        String login;
        String password;
        User user;

        login = request.getParameter("login");
        password = request.getParameter("password");

        if (login.equals("") || password.equals("")) {
            throw new ControllerException("Login or password is empty");
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientServiceImpl();

        try {
            clientService.registration(login, password);
            request.setAttribute("message", "New user with login " + login + " was successfully created!");
        } catch (ServiceException e) {
            log.error("Error while registering new user", e);
            throw new ControllerException(e.getMessage());
        }
    }

    /*@Override
    public String execute(final String request) throws ControllerException {
        String login;
        String password;
        String response;
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
            log.error("Error while registering new user", e);
            throw new ControllerException(e.getMessage());
        }
        return response;
    }*/
}
