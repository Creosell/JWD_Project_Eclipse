package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.bean.Product;
import by.sheshko.shop.controller.ControllerException;
import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.service.ProductService;
import by.sheshko.shop.service.ServiceException;
import by.sheshko.shop.service.factory.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static by.sheshko.shop.controller.command.util.ResourceParameter.PRODUCT_LIST;

public class ProductListLoadCommand implements Command {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        List<Product> productList;

        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ProductService productService = serviceFactory.getProductServiceImpl();
            productList = productService.loadProductList();

            log.info("Product list is loaded");
            request.getSession().setAttribute(PRODUCT_LIST, productList);
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage(), e); //todo exception
        }
        return "products";
    }
}
