package com.view;

import com.controller.UserController;
import com.model.User;

public class UserView {

    private UserController userController = new UserController();

    public void getAllUsers() {
        for (User d: userController.getAllUsers()) {
            System.out.println("======================");
            System.out.println("ID    : " + d.getId());
            System.out.println("Name  : " + d.getFirstname());
            System.out.println("LName : " + d.getLastname());
        }
    }
}
