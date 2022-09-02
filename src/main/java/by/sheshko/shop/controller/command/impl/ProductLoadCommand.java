package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.bean.Product;
import by.sheshko.shop.controller.ControllerException;
import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.service.ProductService;
import by.sheshko.shop.service.ServiceException;
import by.sheshko.shop.service.factory.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.sheshko.shop.controller.command.util.ResourceParameter.*;

public final class ProductLoadCommand implements Command {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        Product product;
        int productId;

        try {
            productId = Integer.parseInt(request.getParameter(PRODUCT_ID));

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ProductService productService = serviceFactory.getProductServiceImpl();
            product = productService.loadProduct(productId);

            request.getSession().setAttribute(MESSAGE, product);
            //log.info("Product is loaded: {}", product);
            request.getSession().setAttribute(PRODUCT, product);

        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage(), e);
        }

        return "homepage"; //todo
    }

}
