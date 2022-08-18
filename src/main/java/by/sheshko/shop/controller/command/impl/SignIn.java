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

import static by.sheshko.shop.controller.command.util.ResourceParameter.*;

public final class SignIn implements Command {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        String login = null;
        String password;
        User user;

        try {
            login = request.getParameter(LOGIN);
            password = request.getParameter(PASSWORD);

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ClientService clientService = serviceFactory.getClientServiceImpl();
            user = clientService.singIn(login, password);

            String welcomeMsg = WELCOME_MESSAGE +", " +login;
            request.getSession().setAttribute("user", user);
            //log.info("User is: {}", user.toString());
            request.getSession().setAttribute("message", welcomeMsg);
            //log.info("Message from login is sent: {}", welcomeMsg);
            return "homepage";
            //return ResourceParameter.HOME_PAGE;
        } catch (ServiceException e) {
            log.info("Error while log on site for login {}", login, e);
            request.getSession().setAttribute("errorMessage", e.getMessage());
            throw new ControllerException(e.getMessage(), e);//todo ненужное описание ошибки
        }
    }
}
