package com.javasundaram.jwtdemo.service;

import com.javasundaram.jwtdemo.entity.Role;
import com.javasundaram.jwtdemo.entity.User;

public interface UserRole {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String userName, String roleName);
}
