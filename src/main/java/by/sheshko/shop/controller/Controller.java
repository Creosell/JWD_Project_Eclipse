package by.sheshko.shop.controller;

import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.controller.command.CommandName;
import by.sheshko.shop.controller.command.util.ResourceParameter;
import by.sheshko.shop.dao.pool.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public final class Controller extends HttpServlet {
    private static final long serialVersionUID = 4296569594467128804L;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CommandProvider provider = new CommandProvider();

    @Override
    public void init() throws ServletException {
        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (ClassNotFoundException e) {
            log.error("Error while trying to find driver class for connection pool", e);
            throw new ServletException("Error finding connection pool class");
        } catch (SQLException e) {
            log.error("Error while connection pool working with database", e);
            throw new ServletException("Error initializing connection pool");

        }
        super.init();
    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().dispose();
        super.destroy();
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        HttpSession session = request.getSession(true);
        CommandName commandName;
        Command command;
        String page;


/*
        if (request.getRequestURI().contains("/")) {
            Map<String, String[]> map = request.getParameterMap();

            for (Map.Entry<String, String[]> stringEntry : map.entrySet()) {
                log.info(stringEntry.getKey());
                for (String s : stringEntry.getValue()) {
                    log.info(s);
                }
            }

            String tempPage = uriArray[1];
            request.setAttribute("command", "forward_command");
            request.setAttribute("target", tempPage);
        }*/


        try {
            commandName = CommandName.valueOf(request.getParameter("command").toUpperCase());
            command = provider.getCommand(String.valueOf(commandName));
            page = command.execute(request, response);
            dispatch(request, response, page);
        } catch (ControllerException e) {
            log.error("Exception while processing request", e);
            dispatch(request, response, ResourceParameter.ERROR_PAGE);
        } catch (NullPointerException e) {
            log.error("Null command name", e);
            dispatch(request, response, ResourceParameter.ERROR_PAGE);
        }
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws javax.servlet.ServletException, java.io.IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);

        try {
            dispatcher.forward(request, response);
        } catch (NullPointerException e) {
            log.error("Null page", e);
            dispatch(request, response, ResourceParameter.ERROR_PAGE);
        }
    }
}