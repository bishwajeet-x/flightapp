package com.fbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	
	/*
	 * @Bean CommandLineRunner run(UserService userService) { return args -> {
	 * 
	 * Role admin = new Role(); admin.setName("ROLE_ADMIN");
	 * 
	 * Role user = new Role(); user.setName("ROLE_USER");
	 * 
	 * 
	 * userService.saveRole(admin); userService.saveRole(user);
	 * 
	 * _User adminUser = new _User(); adminUser.setName("Admin");
	 * adminUser.setPassword("password"); adminUser.setUsername("admin");
	 * adminUser.setRoles(List.of(admin));
	 * 
	 * userService.saveUser(adminUser);
	 * 
	 * userService.addRoleToUser("admin", "ROLE_ADMIN"); }; }
	 */

}
