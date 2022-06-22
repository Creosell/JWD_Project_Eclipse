package by.sheshko.shop.controller;

import by.sheshko.shop.bean.UserSessionInfo;
import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.controller.command.CommandName;
import by.sheshko.shop.dao.pool.ConnectionPool;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 4296569594467128804L;
    private final CommandProvider provider = new CommandProvider();
    private static final Logger logger = LogManager.getLogger(Controller.class);

    @Override
    public void destroy() {
        ConnectionPool.getInstance().dispose();
        super.destroy();
    }

    @Override
    public void init() throws ServletException {

        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (ClassNotFoundException e) {
            logger.log(Level.FATAL,"Error while trying to find driver class for connection pool",e);
            throw new ServletException ("Error initializing connection pool", e);
        } catch (SQLException e) {
            logger.log(Level.FATAL,"Error while connection pool working with database",e);
            throw new ServletException("Error initializing connection pool", e);
        }
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
      /*  HttpSession session =
        String login =
        String ;*/
        CommandName commandName = CommandName.valueOf(request.getParameter("command").toUpperCase());
        Command command = provider.getCommand(String.valueOf(commandName));

        UserSessionInfo userSessionInfo = new UserSessionInfo();
        userSessionInfo.setSession(request.getSession());
        userSessionInfo.setLogin(request.getParameter("login"));
        userSessionInfo.setPassword(request.getParameter("password"));


        if (userSessionInfo.getName() == null) {
            userSessionInfo.setLogin("Anonymous");
        }

        out.println("Name: " + userSessionInfo.getName() + "<br>");

        switch (commandName) {
            case SIGN_IN:
            case REGISTRATION:
                try {
                    out.println(command.execute(userSessionInfo.getLogin() + " " + userSessionInfo.getPassword()));
                } catch (ControllerException e) {
                    out.println(e.getMessage());
                }
                break;
            case SIGN_OUT:
                userSessionInfo.signOut();
            default:
                try {
                    out.println(command.execute("Wrong request"));
                } catch (ControllerException e) {
                    out.println(response);
                    System.out.println(e + "\n");
                }
        }
    }
}
