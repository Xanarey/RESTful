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


@WebServlet(
        name = "UserServlet",
        urlPatterns = "/getById"
)
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userID = request.getParameter("id");
        if (userID != null) {
            Long id = Long.parseLong(userID);
            User user = userService.getById(id);
            request.setAttribute("userRecord", user);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/userView/userById-record.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
