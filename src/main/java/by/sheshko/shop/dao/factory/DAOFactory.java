package by.sheshko.shop.dao.factory;

import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.impl.SQLUserDAO;

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
