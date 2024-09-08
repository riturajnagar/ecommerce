package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.model.RoleName;
import com.onlineshopping.ecommerce.model.User;

import java.util.List;

public interface UserService {

    User registerUser(User user);

    User findByUsername(String username);

    List<User> getAllUsers();

    public void assignRoleToUser(String username, RoleName roleName);

    User login(String username, String password);
}

