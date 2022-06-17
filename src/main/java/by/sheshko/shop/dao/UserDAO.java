package by.sheshko.shop.dao;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.dao.exception.DAOException;

public interface UserDAO {
    void signIn(User user) throws DAOException;

    void registration(User user) throws DAOException;

    User getUserInfo(final String login) throws DAOException;
}
