package com.javasundaram.jwtdemo.service.impl;

import com.javasundaram.jwtdemo.entity.Role;
import com.javasundaram.jwtdemo.entity.User;
import com.javasundaram.jwtdemo.repository.RoleRepository;
import com.javasundaram.jwtdemo.repository.UserRepository;
import com.javasundaram.jwtdemo.service.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserRoleImpl implements UserRole, UserDetailsService {

    @Autowired
    public UserRepository userRepo;

    @Autowired
    public RoleRepository roleRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepo.findByUserName(username);

        if(u == null){
            log.error("username not found in the database");
            throw new UsernameNotFoundException("username not found in the database");
        }
        else{
            log.info("username found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        u.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return new org.springframework.security.core.userdetails.User(u.getUserName(), u.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
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
            System.out.println("inside if-----------------");
        }
        else{
            System.out.println("inside else-----------------");
        }


    }


}
