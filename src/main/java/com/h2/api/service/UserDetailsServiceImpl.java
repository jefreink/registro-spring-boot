package com.h2.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.h2.api.dto.UserTokenDTO;
import com.h2.api.entities.UsersTokenModel;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("[loadUserByUsername]::inicio de metodo");
		UsersTokenModel user = usuarioService.getByEmail(email);
		log.info("[loadUserByUsername]::fin de metodo");
		return UserToken(user);
	}
	
	
	
	private UserTokenDTO UserToken(UsersTokenModel user) {
		log.info("[UserToken]::inicio de metodo");
		UserTokenDTO userToken = new UserTokenDTO();

		userToken.setEmail(user.getEmail());
		userToken.setName(user.getName());
		userToken.setUsername(user.getId().toString());
		userToken.setPassword(user.getPassword());

		log.info("[UserToken]::fin de metodo");
		return userToken;
	}


}