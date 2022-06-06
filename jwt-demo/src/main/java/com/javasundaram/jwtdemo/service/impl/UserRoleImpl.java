package com.javasundaram.jwtdemo.service.impl;

import com.javasundaram.jwtdemo.entity.Role;
import com.javasundaram.jwtdemo.entity.User;
import com.javasundaram.jwtdemo.repository.RoleRepository;
import com.javasundaram.jwtdemo.repository.UserRepository;
import com.javasundaram.jwtdemo.service.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleImpl implements UserRole {

    @Autowired
    public UserRepository userRepo;

    @Autowired
    public RoleRepository roleRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {

        User u = userRepo.findByUserName(userName);

        Role r = roleRepo.findByRoleName(roleName);

        if( r!=null && u!=null){
            u.getRoles().add(r);
        }


    }
}
