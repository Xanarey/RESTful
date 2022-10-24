package com.repository.Hibernate;

import com.model.User;
import com.repository.UserRepo;
import com.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class HibernateUserRepoImpl implements UserRepo {

    @Override
    public User getById(Long id) {
        User user = new User();
        try (Session session = HibernateUtil.getSession()){
            user =  (User) session.createQuery("SELECT d FROM User d WHERE d.id = (:id)").setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> userList;
        Transaction transaction;
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
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            session.remove(session.get(User.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User insert(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User user) {
        insert(user);
        return user;
    }
}
