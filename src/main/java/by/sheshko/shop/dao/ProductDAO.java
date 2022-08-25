package by.sheshko.shop.dao;

import by.sheshko.shop.bean.Product;

import java.util.List;

public interface ProductDAO {
    Product loadProduct(Integer productID) throws DAOException;

    List<Product> loadProductList() throws DAOException;
}
