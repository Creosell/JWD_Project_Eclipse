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


public final class Registration implements Command {
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        String login = null;
        String password = null;
        User user;//todo ненужный параметр?

        try {
            login = request.getParameter(ResourceParameter.LOGIN);
            password = request.getParameter(ResourceParameter.LOGIN);

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ClientService clientService = serviceFactory.getClientServiceImpl();
            clientService.registration(login, password);

            request.setAttribute("message", login);
            log.info("Message from registration is sent: {}", login);
        } catch (ServiceException e) {
            log.error("Error while registering new user. Login: {}. Password: {}",login, password, e);
            throw new ControllerException(e.getMessage());
        }
        return ResourceParameter.REGISTRATION_SUCCESS;
    }
}
