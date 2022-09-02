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

public final class EditUserInfoCommand implements Command {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        User user = (User) request.getSession().getAttribute("user");
        String name = null;
        String surname = null;
        String email = null;
        String address = null;
        String phonenumber = null;
        String newPassword = null;


        try {
            name = request.getParameter(NAME);
            surname = request.getParameter(SURNAME);
            email = request.getParameter(EMAIL);
            address = request.getParameter(ADDRESS);
            phonenumber = request.getParameter(PHONENUMBER);
            newPassword = request.getParameter(NEW_PASSWORD);
            //log.info("TestUser: {}", user);

            user.setName(name);
            user.setSurname(surname);
            user.setEmail(email);
            user.setAddress(address);
            user.setPhonenumber(phonenumber);

            //log.info("TestUser after edit: {}", user);
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ClientService clientService = serviceFactory.getClientServiceImpl();
            clientService.editUserInfo(user, newPassword);
            request.getSession().invalidate();

            //log.info("Message from editUser method was sent: New user info{}", user);
        } catch (ServiceException e) {
            request.getSession().setAttribute("errorMessage", e.getMessage());
            log.error("Error while edit user info. User: {}", user, e);
            throw new ControllerException(e.getMessage());
        }
        return "editUserInfoSuccess";
    }

}

