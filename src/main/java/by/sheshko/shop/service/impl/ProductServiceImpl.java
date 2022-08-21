package by.sheshko.shop.service.impl;

import by.sheshko.shop.bean.Product;
import by.sheshko.shop.dao.DAOException;
import by.sheshko.shop.dao.ProductDAO;
import by.sheshko.shop.dao.UserDAO;
import by.sheshko.shop.dao.factory.DAOFactory;
import by.sheshko.shop.service.ProductService;
import by.sheshko.shop.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductServiceImpl implements ProductService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Product loadProduct(Integer productID) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        ProductDAO productDAO = daoFactory.getProductDAOImpl();
        Product product = null;
        try {
            product = productDAO.loadProduct(1);
        } catch (DAOException e) {
            log.error("Error loading product. ProductID: {}",productID);
            throw new ServiceException(e.getMessage());
        }
        return product;
    }
}
