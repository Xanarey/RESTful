package com.controller;

import com.model.User;
import com.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;


@WebServlet(
        name = "UserServlet",
        urlPatterns = "/user-record"
)
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServerException, IOException, ServletException {
        String userID = request.getParameter("id");
        if (userID != null) {
            Long id = Long.parseLong(userID);
            User user = userService.getById(id);
            request.setAttribute("user-record", user);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/user-record.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
