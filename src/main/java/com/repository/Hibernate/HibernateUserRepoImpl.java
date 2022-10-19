package com.repository.Hibernate;

import com.model.User;
import com.repository.UserRepo;
import com.utils.HibernateUtil;
import org.apache.maven.model.Developer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HibernateUserRepoImpl implements UserRepo {

    @Override
    public User insert(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            userList = session.createQuery("FROM User", User.class).list();
            transaction.commit();
        } catch (Throwable t) {
            return Collections.emptyList();
        }
        return userList;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public User update(User user) {
        return null;
    }
}
