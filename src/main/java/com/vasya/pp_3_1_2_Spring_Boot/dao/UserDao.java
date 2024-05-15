package com.vasya.pp_3_1_2_Spring_Boot.dao;

import com.vasya.pp_3_1_2_Spring_Boot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);

        return query.getResultList();
    }

    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    public User readUser(int id) {
        return entityManager.find(User.class, id);
    }

    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    public User deleteUser(int id) throws NullPointerException {
        User user = readUser(id);
        if (null == user) {
            throw new NullPointerException("User doesn't found");
        }
        entityManager.remove(user);
        entityManager.flush();
        return user;
    }
}
