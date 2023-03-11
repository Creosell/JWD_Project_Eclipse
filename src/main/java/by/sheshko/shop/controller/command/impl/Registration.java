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

import static by.sheshko.shop.controller.command.util.ResourceParameter.*;


public final class Registration implements Command {
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        String login = null;
        String password = null;
        String email = null;
        String name = null;
        String surname = null;
        String address = null;
        String phonenumber = null;
        User user;

        try {
            login = request.getParameter(LOGIN);
            password = request.getParameter(PASSWORD);
            email = request.getParameter(EMAIL);
            name = request.getParameter(NAME);
            surname = request.getParameter(SURNAME);
            address = request.getParameter(ADDRESS);
            phonenumber = request.getParameter(PHONENUMBER);

            user = new User(name, surname, email, address, phonenumber);


            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ClientService clientService = serviceFactory.getClientServiceImpl();
            clientService.registration(login, password, user);

            request.getSession().setAttribute("message", login);
            log.info("Message from registration is sent: {}", login);
        } catch (ServiceException e) {
            request.getSession().setAttribute("errorMessage", e.getMessage());
            log.error("Error while registering new user. Login: {}. Password: {}", login, password, e);
            throw new ControllerException(e.getMessage());
        }
        return REGISTRATION_SUCCESS_POST;
    }

}
