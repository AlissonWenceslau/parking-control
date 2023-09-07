package com.api.parkingcontrol.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.parkingcontrol.models.UserModel;
import com.api.parkingcontrol.repositories.UserRespository;

@Service
@Transactional
public class UserService implements UserDetailsService{
	
	final UserRespository repository;
	
	public UserService(UserRespository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = repository.findByUsername(username).
				orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return new User(userModel.getUsername(), userModel.getPassword(), true, true, true, true, userModel.getAuthorities());
	}

}
