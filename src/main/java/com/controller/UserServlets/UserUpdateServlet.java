package com.controller.UserServlets;

import com.model.User;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "UserUpdateServlet",
        urlPatterns = "/UserUpdateServlet"
)
public class UserUpdateServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("id");
        String userName = request.getParameter("name");
        userService.updateUser(new User(Long.parseLong(userID), userName));
        response.sendRedirect("/getAllUsers");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
