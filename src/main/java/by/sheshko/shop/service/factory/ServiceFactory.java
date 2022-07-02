package by.sheshko.shop.service.factory;

import by.sheshko.shop.service.ClientService;
import by.sheshko.shop.service.impl.ClientServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ClientService clientServiceImpl = new ClientServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        synchronized (ServiceFactory.class){
            return instance;
        }
    }

    public ClientService getClientServiceImpl() {
        return clientServiceImpl;
    }
}
