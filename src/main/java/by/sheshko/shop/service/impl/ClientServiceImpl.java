package by.sheshko.shop.service.impl;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.exception.DAOException;
import by.sheshko.shop.dao.factory.DAOFactory;
import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.exception.ServiceException;

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
}
