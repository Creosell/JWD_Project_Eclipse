package by.sheshko.mywebproject.dao;

import by.sheshko.mywebproject.bean.User;
import by.sheshko.mywebproject.dao.exception.DAOException;

public interface UserDAO {
    void signIn(final String login, final String password) throws DAOException;

    void registration(User user) throws DAOException;
}
