package by.sheshko.shop.dao.factory;

import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.impl.SQLUserDAO;

public final class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();
    private final UserDAO userDAOImpl = new SQLUserDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        synchronized (DAOFactory.class) {
            return INSTANCE;
        }

    }

    public UserDAO getUserDAOImpl() {
        synchronized (DAOFactory.class) {
            return userDAOImpl;
        }
    }
}
