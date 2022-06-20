package by.sheshko.shop.dao;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.dao.exception.DAOException;

public interface UserDAO {
    void signIn(String login, String password) throws DAOException;

    void registration(String login, String password) throws DAOException;

    User getUserInfo(final String login) throws DAOException;
}
