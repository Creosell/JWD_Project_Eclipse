package by.sheshko.shop.controller.command.impl;

import by.sheshko.shop.controller.ControllerException;
import by.sheshko.shop.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

public final class ForwardCommand implements Command {
    final ResourceBundle pages = ResourceBundle.getBundle("pages");

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        String page = request.getParameter("page");
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        try {
            dispatcher.forward(request, response);}
        catch (Exception e) {
                log.error("Exception while processing request", e);
               //dispatcher.forward(request, response, pages.getString("page.error"));
            }
   }
}
