package by.sheshko.shop.service;

import by.sheshko.shop.bean.Product;
import by.sheshko.shop.dao.DAOException;

import java.util.List;

public interface ProductService {
    Product loadProduct(Integer productID) throws ServiceException;

    List<Product> loadProductList() throws ServiceException;
}
