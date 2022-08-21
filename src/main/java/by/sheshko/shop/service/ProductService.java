package by.sheshko.shop.service;

import by.sheshko.shop.bean.Product;
import by.sheshko.shop.dao.DAOException;

public interface ProductService {
    Product loadProduct(Integer productID) throws ServiceException;
}
