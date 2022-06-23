package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.controller.ControllerException;
import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.ServiceException;
import by.sheshko.shop.service.factory.ServiceFactory;

public class UserInfo implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientServiceImpl();

        try {
            response = clientService.getUserInfo(request).toString();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
