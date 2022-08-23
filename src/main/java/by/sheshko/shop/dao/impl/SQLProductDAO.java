package by.sheshko.shop.dao.impl;

import by.sheshko.shop.bean.Product;
import by.sheshko.shop.bean.builder.ProductBuilder;
import by.sheshko.shop.dao.DAOException;
import by.sheshko.shop.dao.ProductDAO;
import by.sheshko.shop.dao.pool.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SQLProductDAO implements ProductDAO {

    private static final String PRODUCT_ID = "id_product";
    private static final String PRODUCTS_CATEGORIES_ID = "products_categories_id";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String PRICE = "price";
    private static final String AVAILABLE_QUANTITY = "available_quantity";
    private static final String QUANTITY_IN_ORDERS = "quantity_in_orders";
    private static final String CATEGORIES = "SELECT * FROM products_categories";
    private static final String PRODUCT_CATEGORY = "SELECT * FROM products_has_products_categories WHERE products_id_product = ?";
    private static final String LOAD_PRODUCT = "SELECT * FROM products WHERE id_product = ?";
    private static final String LOAD_PRODUCTS_ID = "SELECT id_product FROM products";
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final Map<Integer, String> categoriesMap = new HashMap<>();
    private Connection connection;


    {
        try {
            loadCategories();
        } catch (DAOException e) {
            log.error("Fail to load categories Map: {}", categoriesMap);
        }
    }
 /*   {
        try {
            loadProductList();
        } catch (DAOException e) {
            log.error("Fail to load product list");
        }
    }*/

    @Override
    public Product loadProduct(Integer productID) throws DAOException {
        Product product = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        //ResultSet categoryResultSet;
        log.info("Product id is {}", productID);

        try {
            connection = connectToDataBase();
            preparedStatement = connection.prepareStatement(LOAD_PRODUCT);
            preparedStatement.setInt(1, productID);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                product = new ProductBuilder()
                        .productID(resultSet.getInt(PRODUCT_ID))
                        .title(resultSet.getString(TITLE))
                        .description(resultSet.getString(DESCRIPTION))
                        .price(resultSet.getDouble(PRICE))
                        .availableQuantity(resultSet.getInt(AVAILABLE_QUANTITY))
                        .quantityInOrders(resultSet.getInt(QUANTITY_IN_ORDERS))
                        .build();
            }

            preparedStatement = connection.prepareStatement(PRODUCT_CATEGORY);
            preparedStatement.setInt(1, productID);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            for (Map.Entry<Integer, String> categoryItem : categoriesMap.entrySet()) {
                if (categoryItem.getKey().equals(resultSet.getInt(PRODUCTS_CATEGORIES_ID))) {
                    Objects.requireNonNull(product).setCategory(categoryItem.getValue());
                }
            }
            log.info("Product is: {}", product);

            resultSet.close();
            //categoryResultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return product;
    }

    @Override
    public List<Product> loadProductList() throws DAOException {
        List<Product> productList = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            connection = connectToDataBase();
            preparedStatement = connection.prepareStatement(LOAD_PRODUCTS_ID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                productList = new ArrayList<>();
                productList.add(loadProduct(1));
            }

            if (productList != null) {
                for (Product product : productList) {
                    log.info("List item: {}", product);
                }
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAOException(e); //todo log
        }

        return productList;
    }

    private Connection connectToDataBase() throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connection = connectionPool.takeConnection();
        } catch (InterruptedException e) {
            log.error("Error getting connection from connection pool queue", e);
            throw new DAOException("Error taking connection to database while getting product information", e);
        }
        return connection;
    }

    private void loadCategories() throws DAOException {
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            connection = connectToDataBase();
            preparedStatement = connection.prepareStatement(CATEGORIES);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                categoriesMap.put(resultSet.getInt(1), resultSet.getString(2));
            }
            /*for (Map.Entry<Integer, String> entry : categoriesMap.entrySet()) {
                log.info("Value is {}, {}", entry.getKey(), entry.getValue()); //todo delete log
            }*/

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DAOException("Internal error when loading categories of products", e);//todo адекватный эксепшн
        }
    }

}
