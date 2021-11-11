package com.flightapp.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.auth.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findByName(String rolename);
}
	