package com.example.SpringbootRestfulwebservices.mapper;

import com.example.SpringbootRestfulwebservices.dto.UserDto;
import com.example.SpringbootRestfulwebservices.entity.User;

public class UserMapper {
	
	
	//convert JPA entity to DTO
	public static UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail()
				);
		return userDto;
	}
	
	
	//convert DTO to JPA entity
	public static User mapToUser(UserDto userDto) {
		
		User user = new User(
				userDto.getId(),
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getEmail()
				);
		return user;
	}

}
