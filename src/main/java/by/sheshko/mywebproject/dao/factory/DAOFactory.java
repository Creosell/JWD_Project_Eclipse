package by.sheshko.mywebproject.dao.factory;

import by.sheshko.mywebproject.dao.UserDAO;
import by.sheshko.mywebproject.dao.impl.SQLUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final UserDAO userDAOImpl = new SQLUserDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAOImpl() {
        return userDAOImpl;
    }
}
