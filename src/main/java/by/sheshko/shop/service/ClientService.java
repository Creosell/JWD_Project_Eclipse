package by.sheshko.shop.service;

import by.sheshko.shop.bean.User;
import by.sheshko.shop.service.exception.ServiceException;

public interface ClientService {
    void singIn(User user) throws ServiceException;

    void signOut(String login) throws ServiceException;

    void registration(User user) throws ServiceException;

    User getUserInfo(String login) throws ServiceException;
}
