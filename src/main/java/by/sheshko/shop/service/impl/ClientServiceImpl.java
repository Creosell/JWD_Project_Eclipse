package by.sheshko.shop.service.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.bean.UserSessionInfo;
import by.sheshko.shop.dao.DAOException;
import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.factory.DAOFactory;
import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.ServiceException;
import by.sheshko.shop.service.validation.UserInfoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static by.sheshko.shop.service.validation.UserInfoValidator.validatePassword;
import static by.sheshko.shop.service.validation.UserInfoValidator.validateUsername;

public final class ClientServiceImpl implements ClientService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void singIn(final String login, final String password) throws ServiceException {
        if (validateUsername(login) && validatePassword(password)) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                UserDAO userDAO = daoFactory.getUserDAOImpl();
                userDAO.signIn(login, password);
            } catch (DAOException e) {
                log.error("Error while logging. Login: {}, Password: {}", login, password, e);
                throw new ServiceException(e.getMessage());
            }
        }
        else {
            throw new ServiceException("Incorrect username or password");
        }

    }

    @Override
    public void signOut(final UserSessionInfo userSessionInfo) {
        userSessionInfo.signOut();
    }

    @Override
    public void registration(final String login, final String password, final User user) throws ServiceException {

        if (validateUsername(login) && validatePassword(password)) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                UserDAO userDAO = daoFactory.getUserDAOImpl();
                userDAO.registration(login, password, user);
            } catch (DAOException e) {
                log.error("Error while registering new user. Login: {}, Password: {}", login, password, e);
                throw new ServiceException(e.getMessage());
            }
        }
        else {
            throw new ServiceException("Check your username or password");
        }
    }

    @Override
    public User getUserInfo(final String login) throws ServiceException {
        User user = null;
        if (validateUsername(login)) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                UserDAO userDAO = daoFactory.getUserDAOImpl();
                return userDAO.getUserInfo(login);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
        }
        return user;
    }
}
