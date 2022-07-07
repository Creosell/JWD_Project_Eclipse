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

public final class SignIn implements Command {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {

    }

    /*@Override
    public String execute(final String request) throws ControllerException {
        String login = null;
        String password;
        String response;
        User user;

        try {
            String[] requestParameters = request.split(" ");
            login = requestParameters[0];
            password = requestParameters[1];

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ClientService clientService = serviceFactory.getClientServiceImpl();

            clientService.singIn(login, password);
            response = "Welcome, " + login;
        } catch (ServiceException e) {
            log.info("Error while log on site for login {}", login, e);
            throw new ControllerException("Incorrect login or password", e);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ControllerException("Login or password is empty", e);
        }
        return response;
    }*/
}
