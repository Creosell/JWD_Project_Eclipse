package by.sheshko.shop.dao;

import by.sheshko.shop.bean.Product;

public interface ProductDAO {
    Product loadProduct(Integer productID) throws DAOException;
}
