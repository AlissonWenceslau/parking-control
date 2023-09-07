package com.api.parkingcontrol.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.parkingcontrol.models.UserModel;

public interface UserRespository extends JpaRepository<UserModel, Long> {

	Optional<UserModel> findByUsername(String username);
}
