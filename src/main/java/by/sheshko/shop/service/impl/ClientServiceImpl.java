package by.sheshko.shop.service.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.dao.DAOException;
import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.factory.DAOFactory;
import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static by.sheshko.shop.service.validation.UserInfoValidator.*;

public final class ClientServiceImpl implements ClientService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public User singIn(final String login, final String password) throws ServiceException {
        User user;
        if (validateUsername(login) && validatePassword(password)) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                UserDAO userDAO = daoFactory.getUserDAOImpl();
                user = userDAO.signIn(login, password);
            } catch (DAOException e) {
                log.error("Error while logging. Login: {}, Password: {}", login, password, e);
                throw new ServiceException(e.getMessage());
            }
        } else {
            throw new ServiceException("Incorrect username or password");
        }
        return user;
    }

    @Override
    public void registration(final String login, final String password, final User user) throws ServiceException {

        if (validateUsername(login) && validatePassword(password) && validatePhonenumber(user.getPhonenumber())) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                UserDAO userDAO = daoFactory.getUserDAOImpl();
                userDAO.registration(login, password, user);
            } catch (DAOException e) {
                log.error("Error while registering new user. Login: {}, Password: {}", login, password, e);
                throw new ServiceException(e.getMessage());
            }
        } else {
            throw new ServiceException("Please, check your username, password and phonenumber");
        }
    }

    @Override
    public void editUserInfo(User user, String newPassword) throws ServiceException {
        try {
            if (!String.valueOf(newPassword).equals("")) {
                if (!validatePassword(newPassword)) {
                    log.error("Error validating user's new password. User: {}", user);
                    throw new ServiceException("Error validating user's new password. UserID is:" + user.getUserID());
                }
            }
            if (!String.valueOf(user.getPhonenumber()).equals("")) {
                if (!validatePhonenumber(user.getPhonenumber())) {
                    log.error("Error validating user's phonenumber. User: {}", user);
                    throw new ServiceException("Error validating user's phonenumber. UserID is:" + user.getUserID());
                }
            }
            log.info("Pass validation {}, phone validation {}", validatePassword(newPassword), validatePhonenumber(user.getPhonenumber()));

            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoFactory.getUserDAOImpl();
            userDAO.editUserInfo(user, newPassword);
        } catch (DAOException e) {
            log.error("Error while edit user info. User: {}", user, e);
            throw new ServiceException(e.getMessage());
        }
    }
}


