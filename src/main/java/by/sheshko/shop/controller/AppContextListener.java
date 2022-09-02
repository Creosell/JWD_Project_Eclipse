package by.sheshko.shop.controller;

import by.sheshko.shop.bean.Product;
import by.sheshko.shop.controller.command.util.ProductComparator;
import by.sheshko.shop.dao.pool.ConnectionPool;
import by.sheshko.shop.service.ProductService;
import by.sheshko.shop.service.ServiceException;
import by.sheshko.shop.service.factory.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;
import java.util.List;

import static by.sheshko.shop.controller.command.util.ResourceParameter.PRODUCT_LIST;
import static by.sheshko.shop.controller.command.util.ResourceParameter.PRODUCT_LIST_SIZE;

public final class AppContextListener implements ServletContextListener {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    List<Product> productList;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().initPoolData();
            initProductList(sce);
        } catch (ServiceException e) {
            log.error("Error initializing product list");
        } catch (ClassNotFoundException e) {
            log.error("Error while trying to find driver class for connection pool", e);

        } catch (SQLException e) {
            log.error("Error while connection pool working with database", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionPool.getInstance().dispose();
    }

    private void initProductList(ServletContextEvent sce) throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ProductService productService = serviceFactory.getProductServiceImpl();
        productList = productService.loadProductList();

        productList.sort(new ProductComparator());
        //log.info("Product list is initialized");

        sce.getServletContext().setAttribute(PRODUCT_LIST_SIZE, productList.size());
        sce.getServletContext().setAttribute(PRODUCT_LIST, productList);
    }
}
