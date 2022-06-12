package by.sheshko.mywebproject.service.factory;

import by.sheshko.mywebproject.service.ClientService;
import by.sheshko.mywebproject.service.impl.ClientServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ClientService clientServiceImpl = new ClientServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ClientService getClientServiceImpl() {
        return clientServiceImpl;
    }
}
