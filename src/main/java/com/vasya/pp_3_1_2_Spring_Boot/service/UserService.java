package com.vasya.pp_3_1_2_Spring_Boot.service;

import com.vasya.pp_3_1_2_Spring_Boot.dao.UserDao;
import com.vasya.pp_3_1_2_Spring_Boot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> listUsers() {
        return userDao.listUsers();
    }

    public void createUser(User user) {
        userDao.createUser(user);
    }

    public User readUser(int id) {
        return userDao.readUser(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User deleteUser(int id) {
        User user = null;
        try {
            user = userDao.deleteUser(id);
        } catch (NullPointerException e) {
            System.out.println("User doesn't found");
        }
        return user;
    }

}
