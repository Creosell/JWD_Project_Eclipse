package by.sheshko.shop.service.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.bean.UserSessionInfo;
import by.sheshko.shop.dao.DAOException;
import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.factory.DAOFactory;
import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ClientServiceImpl implements ClientService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void singIn(final String login, final String password) throws ServiceException {
        if (!login.equals("") && !password.equals("")) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                UserDAO userDAO = daoFactory.getUserDAOImpl();
                userDAO.signIn(login, password);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());//TODO Logger
            }
        }

    }

    @Override
    public void signOut(final UserSessionInfo userSessionInfo) {
        userSessionInfo.signOut();
    }

    @Override
    public void registration(final String login, final String password) throws ServiceException {

        if (!login.equals("") && !password.equals("")) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                UserDAO userDAO = daoFactory.getUserDAOImpl();
                userDAO.registration(login, password);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
        }
    }

    @Override
    public User getUserInfo(final String login) throws ServiceException {
        if (!login.equals("")) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                UserDAO userDAO = daoFactory.getUserDAOImpl();
                return userDAO.getUserInfo(login);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
        }
        return null;//TODO null?
    }
}
