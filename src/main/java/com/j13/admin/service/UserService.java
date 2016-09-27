package com.j13.admin.service;

import com.j13.admin.security.dao.UserDAO;
import com.j13.admin.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunbo on 14-11-7.
 */
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public User login(String username, String password) {
        User user = userDAO.login(username, password);
        return user;
    }
}
