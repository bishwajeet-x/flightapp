package com.flightapp.auth.service;

import java.util.List;

import com.flightapp.auth.entity.Role;
import com.flightapp.auth.entity._User;

public interface UserService {
	_User saveUser(_User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	_User getUser(String username);
	List<_User> getUsers();
}
