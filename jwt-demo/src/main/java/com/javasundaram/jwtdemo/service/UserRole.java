package com.javasundaram.jwtdemo.service;

import com.javasundaram.jwtdemo.entity.Role;
import com.javasundaram.jwtdemo.entity.User;

import java.util.List;

public interface UserRole {

    User saveUser(User user);

    List<User> getAllUser();

    Role saveRole(Role role);

    void addRoleToUser(String userName, String roleName);
}
