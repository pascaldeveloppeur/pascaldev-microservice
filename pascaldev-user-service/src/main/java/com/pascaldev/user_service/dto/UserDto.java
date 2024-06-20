package com.pascaldev.user_service.dto;

import org.modelmapper.ModelMapper;

import com.pascaldev.user_service.model.Role;
import com.pascaldev.user_service.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private Long id;
	private String name;
	private String email;
	private Role role;
	
	public static UserDto fromUser(User user) {
		
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}
	
	public static User fromUserDto(UserDto userDto) {
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(userDto, User.class);
		return user;
	}

}
