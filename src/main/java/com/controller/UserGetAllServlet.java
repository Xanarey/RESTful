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
import java.util.List;

@WebServlet(
        name = "UserGetAllServlet",
        urlPatterns = "/getAllUsers"
)
public class UserGetAllServlet extends HttpServlet {

    private UserService userService = new UserService();

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> userList = userService.getAllUsers();
        request.setAttribute("userGetAllRecord", userList);

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/userView/userGetAll-record.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

}