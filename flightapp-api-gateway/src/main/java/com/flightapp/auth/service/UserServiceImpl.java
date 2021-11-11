package com.flightapp.auth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.flightapp.auth.entity.Role;
import com.flightapp.auth.entity._User;
import com.flightapp.auth.repo.RoleRepo;
import com.flightapp.auth.repo.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired private UserRepo userRepo;
	@Autowired private RoleRepo roleRepo;
	@Autowired private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		_User user = userRepo.findByUsername(username);
		if(user == null) {
			System.err.println("User not found in the db");
			throw new UsernameNotFoundException("User not found in the db");
		} else {
			System.out.println("User found in the db");
		}
		
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> { 
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}

	@Override
	public _User saveUser(_User user) {
		System.out.println("Saving new user to the db "+user.getUsername());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		System.out.println("Saving new role to the db "+role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		System.out.println("Adding role "+roleName+" to user "+ username);
		_User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public _User getUser(String username) {
		System.out.println("Fetching user "+ username);
		return userRepo.findByUsername(username);
	}

	@Override
	public List<_User> getUsers() {
		System.out.println("Fetching users");
		return userRepo.findAll();
	}

}
