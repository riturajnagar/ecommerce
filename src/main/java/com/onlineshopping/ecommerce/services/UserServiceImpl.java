package com.onlineshopping.ecommerce.services;

import com.onlineshopping.ecommerce.exceptions.EntityNotFoundException;
import com.onlineshopping.ecommerce.exceptions.InvalidCredentialsException;
import com.onlineshopping.ecommerce.model.Role;
import com.onlineshopping.ecommerce.model.RoleName;
import com.onlineshopping.ecommerce.model.User;
import com.onlineshopping.ecommerce.repository.RoleRepository;
import com.onlineshopping.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        user.setRoles(Collections.singleton(userRole));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found with username: " + username));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void assignRoleToUser(String username, RoleName roleName) {
        User user = findByUsername(username);
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = findByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException("Invalid username or password");
        }
        return user;
    }
}
