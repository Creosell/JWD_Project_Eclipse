package by.sheshko.shop.service.factory;

import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.ProductService;
import by.sheshko.shop.service.impl.ClientServiceImpl;
import by.sheshko.shop.service.impl.ProductServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();
    private final ClientService clientServiceImpl = new ClientServiceImpl();
    private final ProductService productServiceImpl = new ProductServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        synchronized (ServiceFactory.class) {
            return INSTANCE;
        }
    }

    public ClientService getClientServiceImpl() {
        synchronized (ServiceFactory.class) {
            return clientServiceImpl;
        }
    }

    public ProductService getProductServiceImpl() {
        synchronized (ServiceFactory.class) {
            return productServiceImpl;
        }
    }
}
