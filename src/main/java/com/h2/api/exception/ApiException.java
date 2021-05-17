package com.h2.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException {
	private final String msg;

	private final HttpStatus status;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime timeStamp;
	
	public ApiException(String msg, HttpStatus status, LocalDateTime timeStamp) {
		this.msg = msg;
		this.status = status;
		this.timeStamp = timeStamp;
	}

}
