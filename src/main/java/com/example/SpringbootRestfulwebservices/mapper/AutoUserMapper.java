package com.example.SpringbootRestfulwebservices.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.SpringbootRestfulwebservices.dto.UserDto;
import com.example.SpringbootRestfulwebservices.entity.User;

@Mapper
public interface AutoUserMapper {
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	
	
	UserDto mapToUserDto(User user);
	
	User mapToUser(UserDto userDto);

}
