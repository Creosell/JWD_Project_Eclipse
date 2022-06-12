package by.sheshko.mywebproject.service.impl;

import by.sheshko.mywebproject.bean.User;
import by.sheshko.mywebproject.dao.UserDAO;
import by.sheshko.mywebproject.dao.exception.DAOException;
import by.sheshko.mywebproject.dao.factory.DAOFactory;
import by.sheshko.mywebproject.service.ClientService;
import by.sheshko.mywebproject.service.exception.ServiceException;

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
