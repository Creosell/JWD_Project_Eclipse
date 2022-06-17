package by.sheshko.shop.controller;

import by.sheshko.shop.bean.UserSessionInfo;
import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.controller.command.CommandName;
import by.sheshko.shop.controller.exception.ControllerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 4296569594467128804L;
    private final CommandProvider provider = new CommandProvider();

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
                    command = provider.getCommand("USER_INFO");
                    out.println("<br>" + command.execute(userSessionInfo.getName()));
                } catch (ControllerException e) {
                    out.println(e.getMessage());
                    System.out.println(e + "\n");
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
