package by.sheshko.mywebproject.service;

import by.sheshko.mywebproject.bean.User;
import by.sheshko.mywebproject.service.exception.ServiceException;

public interface ClientService {
    void singIn(String login, String password) throws ServiceException;

    void signOut(String login) throws ServiceException;

    void registration(User user) throws ServiceException;
}
