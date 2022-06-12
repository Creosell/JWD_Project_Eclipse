package by.sheshko.shop.service;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.service.exception.ServiceException;

public interface ClientService {
    void singIn(String login, String password) throws ServiceException;

    void signOut(String login) throws ServiceException;

    void registration(User user) throws ServiceException;
}
