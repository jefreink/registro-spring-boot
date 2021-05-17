package com.h2.api.dto;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import com.h2.api.entities.PhonesTokenModel;
import com.h2.api.interfaces.ValidPassword;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUserDto {
	private UUID id;
	@NotEmpty(message = "El campo es obligatorio")
	private String name;
	@NotEmpty(message = "El campo es obligatorio")
	private String email;
	@NotEmpty(message = "El campo es obligatorio")
	@ValidPassword
	private String password;
	private List<PhonesTokenModel> phones;
}
