package com.javasundaram.jwtdemo;

import com.javasundaram.jwtdemo.entity.Role;
import com.javasundaram.jwtdemo.entity.User;
import com.javasundaram.jwtdemo.service.UserRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserRole ur){
		return ars ->{

			//ur.saveRole(new Role(null, "ROLE_USER"));
			//ur.saveRole(new Role(null, "ROLE_ADMIN"));
			//ur.saveUser(new User(null, "sundaram", "sundaram", "1234","sundaram", new ArrayList<>()));
			//ur.addRoleToUser("sundaram", "ROLE_USER");
			//ur.addRoleToUser("javasundaram", "ROLE_USER");
		};
	}
}
