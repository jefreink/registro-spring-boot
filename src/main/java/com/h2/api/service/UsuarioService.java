package com.h2.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h2.api.entities.UsersTokenModel;
import com.h2.api.exception.RequestException;
import com.h2.api.repository.UserRepository;
import com.h2.api.validator.EmailValidator;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmailValidator emailValidator;


	public UsersTokenModel getByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Transactional
	public UsersTokenModel saveUser(UsersTokenModel user) {

		boolean isValidEmail = emailValidator.test(user.getEmail());

		if (!isValidEmail)
			throw new RequestException("El correo no es valido");

		userRepository.save(user);
		
		UsersTokenModel resp = getByEmail(user.getEmail());

		
		return resp;
	}

}
