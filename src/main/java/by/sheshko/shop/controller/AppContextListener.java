package by.sheshko.shop.controller;

import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.dao.pool.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import java.sql.SQLException;

import static by.sheshko.shop.controller.command.CommandName.LOAD_PRODUCT_LIST;

public class AppContextListener implements ServletContextListener{
    private final CommandProvider provider = new CommandProvider();
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (ClassNotFoundException e) {
            log.error("Error while trying to find driver class for connection pool", e);

        } catch (SQLException e) {
            log.error("Error while connection pool working with database", e);

        }
        Command command = provider.getCommand(String.valueOf(LOAD_PRODUCT_LIST));
        ServletContextListener.super.contextInitialized(sce);
    }
}
