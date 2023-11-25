package com.example.SpringbootRestfulwebservices.service;

import java.util.List;

import com.example.SpringbootRestfulwebservices.dto.UserDto;
import com.example.SpringbootRestfulwebservices.entity.User;

public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto getUserById(Long userId);
	
	List<UserDto> getAllUsers();
	
	UserDto updateUser(UserDto user);
	
	void deleteUser(Long userId);

}
