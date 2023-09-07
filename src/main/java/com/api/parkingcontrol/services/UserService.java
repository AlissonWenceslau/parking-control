package com.api.parkingcontrol.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.UserModel;
import com.api.parkingcontrol.repositories.UserRespository;

@Service
public class UserService implements UserDetailsService{
	
	final UserRespository repository;
	
	public UserService(UserRespository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = repository.findByUsername(username).
				orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return userModel;
	}

}
