package com.h2.api.dto;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtDto {
	
	private String token;
	
	private String id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime created;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modified;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime last_login;
	
	private boolean enable;
	
	private Collection<? extends GrantedAuthority> authorities;
	
    public JwtDto(String token, String id, LocalDateTime created, LocalDateTime modified, LocalDateTime last_login, boolean enable) {
        this.token = token;
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.last_login = last_login;
        this.enable = enable;
    }

}
