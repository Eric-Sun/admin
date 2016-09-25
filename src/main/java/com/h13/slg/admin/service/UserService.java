package com.h13.slg.admin.service;

import com.h13.slg.admin.security.dao.UserDAO;
import com.h13.slg.admin.security.model.User;
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
