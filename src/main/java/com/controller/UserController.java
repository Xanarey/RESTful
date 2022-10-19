package com.controller;

import com.model.User;
import com.service.UserService;

import java.util.List;

public class UserController {

    private UserService userService = new UserService();

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
