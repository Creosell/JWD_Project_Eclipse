package by.sheshko.shop.service.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.bean.UserSessionInfo;
import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.DAOException;
import by.sheshko.shop.dao.factory.DAOFactory;
import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.ServiceException;

public class ClientServiceImpl implements ClientService {
    @Override
    public void singIn(String login, String password) throws ServiceException {
        if (!login.equals("") && !password.equals("")) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                UserDAO userDAO = daoFactory.getUserDAOImpl();
                userDAO.signIn(login, password);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
        }

    }

    @Override
    public void signOut(UserSessionInfo userSessionInfo) {
        userSessionInfo.signOut();
    }

    @Override
    public void registration(String login, String password) throws ServiceException {

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
    public User getUserInfo(String login) throws ServiceException {
        if (!login.equals("")) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                UserDAO userDAO = daoFactory.getUserDAOImpl();
                return userDAO.getUserInfo(login);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
        }
        return null;
    }
}
