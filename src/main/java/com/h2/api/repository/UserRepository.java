package com.h2.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.h2.api.entities.UsersTokenModel;

@Transactional
public interface UserRepository extends JpaRepository<UsersTokenModel, Integer>{
	
	
	UsersTokenModel findByEmail(String email);
	
	boolean existsByEmail(String email);

}