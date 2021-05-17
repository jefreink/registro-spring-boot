package com.h2.api.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtTokenUtil {

	@Autowired
	public AuthenticationManager authenticationManager;

	@Autowired
	public JwtTokenProvider tokenProvider;

	public Authentication createToken(String usernameOrEmail, String password) {
		log.info("[refreshToken]:: Inicio del metodo ");
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(usernameOrEmail, password));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		log.info("[refreshToken]:: Fin del metodo ");
		return authentication;
	}

	/**
	 * Refresca el token ante una modificacion
	 * 
	 * @param usuario
	 * @return
	 */
//	public String refreshToken(User user) throws UserNotAuthException {
//		log.info("[refreshToken] :: Inicio del metodo ");
//		String jwt ="";
//		try {
//			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//			// Obtenemos los datos
//			CodifyUserDto codifyUser = (CodifyUserDto) authentication.getPrincipal();
//
//			// Actualizamos los datos
//			codifyUser.setUsername(user.getEmail());
//			codifyUser.setFullName(user.getFirstName() + " " + user.getMiddleName());
//			codifyUser.setLanguaje(user.getLanguaje().getCode());
//			//codifyUser.setObjects(user.get);
//
//			// Volvemos a generar el objeto
//			authentication = new UsernamePasswordAuthenticationToken(codifyUser, user.getPassword(),
//					codifyUser.getAuthorities());
//
//			jwt = generateToken(authentication);
//
//		} catch (UserNotAuthException e) {
//			log.error("No es posible refrescar el token del usuario " + e.getMessage());
//			throw new UserNotAuthException("No es posible refrescar el token del usuario " + e.getMessage());
//		}
//		log.info("[refreshToken] :: Fin del metodo ");
//		return jwt;
//	}

	/**
	 * Setea la authentication en el context y genera el nuevo token
	 * 
	 * @param authentication
	 * @return
	 */
//	public String generateToken(Authentication authentication) throws UserNotAuthException {
//		String jwt ="";
//		try {
//			jwt = tokenProvider.generateToken(authentication);
//		} catch (IOException e) {
//			throw new UserNotAuthException("no se puede generar token");
//		}
//		return jwt;
//	}
	
	
	
}
