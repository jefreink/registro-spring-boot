package com.h2.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2.api.dto.JwtDto;
import com.h2.api.dto.RequestUserDto;
import com.h2.api.entities.PhonesTokenModel;
import com.h2.api.entities.UsersTokenModel;
import com.h2.api.exception.RequestException;
import com.h2.api.jwt.JwtTokenProvider;
import com.h2.api.service.PhoneService;
import com.h2.api.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PhoneService phoneService;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/registro")
	public ResponseEntity<JwtDto> rigistrarUsuario(@Valid @RequestBody RequestUserDto reqUserDto, BindingResult bindingdResult) throws IOException {

        if (bindingdResult.hasErrors()) {
        	throw new RequestException("Campos incorrecto");
        }
			if(usuarioService.existsByEmail(reqUserDto.getEmail()))
				throw new RequestException("El correo ya existe");
		
		UsersTokenModel user = 
		new UsersTokenModel(reqUserDto.getName(), reqUserDto.getEmail(), passwordEncoder.encode(reqUserDto.getPassword()));
		

		UsersTokenModel resp = usuarioService.saveUser(user);
		
		List<PhonesTokenModel> phonesUser = new ArrayList<PhonesTokenModel>(reqUserDto.getPhones());
		
		for (PhonesTokenModel phonesTokenModel : phonesUser) {
			phonesTokenModel.setUsers(resp);
		}
		
		phoneService.saveAll(phonesUser);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(reqUserDto.getEmail(), reqUserDto.getPassword())
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        JwtDto jwtDto = new JwtDto(jwt, resp.getId().toString(), resp.getCreated(), resp.getModified(), resp.getLast_login(), resp.isEnable());
        
        return new ResponseEntity<JwtDto>(jwtDto, HttpStatus.OK);

	}

}
