package com.service;

import com.model.User;
import com.repository.Hibernate.HibernateUserRepoImpl;
import com.repository.UserRepo;

import java.util.List;

public class UserService {

    private UserRepo userRepo = new HibernateUserRepoImpl();

    public List<User> getAllUsers() {
        return userRepo.getAll();
    }

}
