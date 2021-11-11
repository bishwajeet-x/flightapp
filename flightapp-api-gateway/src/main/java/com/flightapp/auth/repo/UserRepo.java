package com.flightapp.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.auth.entity._User;

public interface UserRepo extends JpaRepository<_User, Long> {
	_User findByUsername(String username);

}
