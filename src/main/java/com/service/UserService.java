package com.service;

import com.model.User;
import com.repository.Hibernate.HibernateUserRepoImpl;
import com.repository.UserRepo;

public class UserService {

    private UserRepo userRepo = new HibernateUserRepoImpl();

    public User getById(Long id) {
        return userRepo.getById(id);
    }

}
