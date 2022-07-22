package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.controller.ControllerException;
import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.controller.command.util.ResourceParameter;
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
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        String login = null;
        String password;
        User user;

        try {
            login = request.getParameter("login");
            password = request.getParameter("password");

            if (login == null || password == null) {
                throw new ControllerException("Login or password is empty");
            }
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ClientService clientService = serviceFactory.getClientServiceImpl();

            clientService.singIn(login, password);
            String welcomeMsg = ResourceParameter.WELCOME_MESSAGE + login;

            request.getSession().setAttribute("message", welcomeMsg);//TODO lang const
            log.info("Message is sent: {}", welcomeMsg);
            return ResourceParameter.HOME_PAGE;
        } catch (ServiceException e) {
            log.info("Error while log on site for login {}", login, e);
            throw new ControllerException("Incorrect login or password", e);
        }
    }
}
