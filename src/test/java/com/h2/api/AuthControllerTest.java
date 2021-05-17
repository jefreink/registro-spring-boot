package com.h2.api;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.h2.api.controller.AuthController;
import com.h2.api.service.PhoneService;
import com.h2.api.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AuthControllerTest {
	
	@InjectMocks
	private AuthController authControllerMock;
	
	@Mock
	private UsuarioService usuarioServiceMock;
	
	@Mock
	private PhoneService phoneServiceMock;
	
	@Test
	public void testRigistrarUsuario() throws IOException {
//		
//		ResponseEntity<JwtDto> resp;
//		
//		UsersTokenModel reqUserDto = new UsersTokenModel();
//		reqUserDto.setName("test");
//		reqUserDto.setPassword("Pa5sw0rd");
//		reqUserDto.setEmail("email@email.com");
//		
//		RequestUserDto reqUserDtos = new RequestUserDto();
//		reqUserDto.setName("test");
//		reqUserDto.setPassword("Pa5sw0rd");
//		reqUserDto.setEmail("email@email.com");
//		
//		PhonesTokenModel phonesModel = new PhonesTokenModel();
//		
//		phonesModel.setCitycode("1");
//		phonesModel.setCountrycode("1");
//		phonesModel.setNumber("1");
//		
//		List<PhonesTokenModel> phonesUser = new ArrayList<PhonesTokenModel>();
//		phonesUser.add(phonesModel);
//		
//		reqUserDtos.setPhones(phonesUser);
//		
//		
//		
//		UsersTokenModel user = new UsersTokenModel();
//		
//		Authentication authentication = authenticationManagerMock.authenticate(
//                new UsernamePasswordAuthenticationToken(reqUserDto.getEmail(), reqUserDto.getPassword())
//        );
		
		
//		Mockito.when(authenticationManagerMock.authenticate(new UsernamePasswordAuthenticationToken(reqUserDto.getEmail(), reqUserDto.getPassword())).thenReturn();
//		Mockito.when(bindingResultMock.hasErrors()).thenReturn(false);
//		Mockito.when(usuarioServiceMock.saveUser(reqUserDto)).thenReturn(user);
//		when(jwtTokenProviderMock.generateToken(authentication)).thenReturn("token");
		
//		resp = authControllerMock.rigistrarUsuario(reqUserDtos, bindingResultMock);
		
//		assertThat(resp.getStatusCode()).isEqualTo("Ok");
				
	}

}
