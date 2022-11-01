package com.controller.UserServlets;

import com.google.gson.Gson;
import com.model.User;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(
        name = "UserGetAllServlet",
        urlPatterns = "/getAllUsers"
)
public class UserGetAllServlet extends HttpServlet {

    private final UserService userService = new UserService();
    private Gson GSON = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            User user = userService.getById(Long.parseLong(request.getParameter("id")));
            jsonConverter(response, user);
        }
        if (request.getParameter("id") == null) {
            List<User> userList = userService.getAllUsers();
            jsonConverter(response, userList);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder content;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
        }
        String con = String.valueOf(content);
        User user = GSON.fromJson(con, User.class);
        userService.createUser(user);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void jsonConverter(HttpServletResponse response, Object object) throws IOException {
        String jsonString = GSON.toJson(object);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=UTF-8");
        out.print(jsonString);
        out.flush();
    }

}