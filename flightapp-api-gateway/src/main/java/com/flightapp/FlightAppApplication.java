package com.flightapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.flightapp.auth.entity.Role;
import com.flightapp.auth.entity._User;
import com.flightapp.auth.service.UserService;
import com.flightapp.filters.ErrorFilter;
import com.flightapp.filters.PostFilter;
import com.flightapp.filters.PreFilter;
import com.flightapp.filters.RouteFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class FlightAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightAppApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
	
	  @Autowired UserService userService;
	
	  @Bean CommandLineRunner run() { return args -> {
	  
	  Role admin = new Role(); admin.setName("ROLE_ADMIN");
	  
	  Role user = new Role(); user.setName("ROLE_USER");
	  
	  
	  userService.saveRole(admin); userService.saveRole(user);
	  
	  _User adminUser = new _User(); adminUser.setName("Admin");
	  adminUser.setPassword("password"); adminUser.setUsername("admin");
	  adminUser.setRoles(List.of(admin));
	  
	  userService.saveUser(adminUser);
	  
	  userService.addRoleToUser("admin", "ROLE_ADMIN"); }; }
	 
	 
}
