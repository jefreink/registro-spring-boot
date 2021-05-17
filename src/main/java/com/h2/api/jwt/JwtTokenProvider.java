package com.h2.api.jwt;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.h2.api.dto.UserTokenDTO;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtTokenProvider {

	@Value("${jwt.secret}")
	private String secret ="";
	
	@Value("${jwt.expiration}")
	private Integer expiration;

	public String generateToken(Authentication authentication) throws IOException {
		log.info("[generateToken]: inicio del metodo");
		UserTokenDTO userPrincipal = (UserTokenDTO) authentication.getPrincipal();
		return Jwts.builder()
				.setId(userPrincipal.getId())
				.setSubject(userPrincipal.getEmail())
			    .setExpiration(new Date(new Date().getTime() + expiration * 1000))
			    .signWith(SignatureAlgorithm.HS512, secret)
			    .compact();
	}

	public String getIdFromToken(String token) throws IOException {
		
		return Jwts.parser().setSigningKey(secret)
				.parseClaimsJws(token)
			    .getBody()
			    .getSubject();
	}

	public boolean validateToken(String token) {
		
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException e) {
			log.error("JWT token mal formado");
		} catch (UnsupportedJwtException e) {
			log.error("JWT token no soportado");
		} catch (ExpiredJwtException e) {
			log.error("JWT token expirado");
		} catch (IllegalArgumentException e) {
			log.error("JWT token se encuentra vacio");
		} catch (SignatureException e) {
			log.error("JWT fallo en la firma");
		}
		return false;
	}
	
	
}
