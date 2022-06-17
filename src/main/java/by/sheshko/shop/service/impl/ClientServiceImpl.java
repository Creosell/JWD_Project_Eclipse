package by.sheshko.shop.service.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.exception.DAOException;
import by.sheshko.shop.dao.factory.DAOFactory;
import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {
    @Override
    public void singIn(User user) throws ServiceException {
        if (!user.getLogin().equals("") && !user.getPassword().equals("")) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                UserDAO userDAO = daoFactory.getUserDAOImpl();
                userDAO.signIn(user);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
        }

    }

    @Override
    public void signOut(String login) {

    }

    @Override
    public void registration(User user) throws ServiceException {

        if (!user.getLogin().equals("") && !user.getPassword().equals("")) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                UserDAO userDAO = daoFactory.getUserDAOImpl();
                userDAO.registration(user);
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
