package com.javasundaram.jwtdemo.controller;

import com.javasundaram.jwtdemo.entity.Role;
import com.javasundaram.jwtdemo.entity.User;
import com.javasundaram.jwtdemo.service.UserRole;
import com.javasundaram.jwtdemo.service.impl.UserRoleImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRoleController {

    @Autowired
    private UserRole userRole;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUser(){
        List<User> u = userRole.getAllUser();
        return ResponseEntity.ok().body(userRole.getAllUser());
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User u = userRole.saveUser(user);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @PostMapping("/user/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        Role r = userRole.saveRole(role);
        return new ResponseEntity<Role>(HttpStatus.OK);
    }

    @PostMapping("/user/adduserrole")
    public ResponseEntity<?> addUserRole(@RequestBody UserRoleMap userRoleMap){
        userRole.addRoleToUser(userRoleMap.getUserName(), userRoleMap.getRoleName());
        return ResponseEntity.ok().build();
    }
}

@Data
class UserRoleMap{
    private String userName;
    private String roleName;
}
