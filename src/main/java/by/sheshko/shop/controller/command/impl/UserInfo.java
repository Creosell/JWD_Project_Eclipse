package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.controller.ControllerException;
import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.ServiceException;
import by.sheshko.shop.service.factory.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UserInfo implements Command {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String execute(final String request) throws ControllerException {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientServiceImpl();

        try {
            response = clientService.getUserInfo(request).toString();
        } catch (ServiceException e) {
            throw new ControllerException("Error getting user info", e);
        }
        return response;
    }
}
