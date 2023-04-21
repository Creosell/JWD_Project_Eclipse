package by.sheshko.shop.controller;

import by.sheshko.shop.controller.command.Command;
import by.sheshko.shop.controller.command.CommandName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.sheshko.shop.controller.command.CommandName.valueOf;
import static by.sheshko.shop.controller.command.util.ResourceParameter.ERROR_PAGE;


public final class Controller extends HttpServlet {
    private static final long serialVersionUID = 4296569594467128804L;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final CommandProvider provider = new CommandProvider();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
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

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        CommandName commandName;
        Command command;
        String page;
        String lastUsedPage;

        try {
            commandName = valueOf(request.getParameter("command").toUpperCase());
            command = provider.getCommand(String.valueOf(commandName));
            //log.info("Command name: {}, Target: {}", commandName, request.getParameter("target"));
            page = command.execute(request, response);

            lastUsedPage = request.getParameter("target");
            //log.info("Last used page: {}", lastUsedPage);
            getServletContext().setAttribute("lastUsedPage", lastUsedPage);

            switch (request.getMethod()) {
                case "GET" -> dispatch(request, response, page);
                case "POST" -> response.sendRedirect("controller?command=forward_command&target=" + page);
            }
        } catch (ControllerException e) {
            log.error("Exception while processing request", e);
            dispatch(request, response, ERROR_PAGE);
        } catch (NullPointerException e) {
            log.error("Null command name", e);
            dispatch(request, response, ERROR_PAGE);
        }
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);

        try {
            dispatcher.forward(request, response);
        } catch (NullPointerException e) {
            log.error("Null page", e);
            dispatch(request, response, ERROR_PAGE);
        }
    }
}