package com.example.SpringbootRestfulwebservices.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.SpringbootRestfulwebservices.dto.UserDto;
import com.example.SpringbootRestfulwebservices.entity.User;
import com.example.SpringbootRestfulwebservices.exception.ErrorDetails;
import com.example.SpringbootRestfulwebservices.exception.ResourceNotFoundException;
import com.example.SpringbootRestfulwebservices.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(
		name = "CRUD REST APIs for User Resource",
		description = "Create User, Update User,Get User,Get All Users,Delete User"
		
		)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
	
	private UserService userService;
	
	@Operation(
			summary = "Create User Rest API",
			description = "Create User Rest API is used to save user in a database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 CREATED"
			)
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user) {
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
		
	}
	
	@Operation(
			summary = "Get User By Id Rest API",
			description = "Get User By Id Rest API is used to get single user from a database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCEESS"
			)
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
		UserDto user = userService.getUserById(userId);
		return ResponseEntity.ok(user);
	}

	@Operation(
			summary = "Get All Users Rest API",
			description = "Get All Users Rest API is used to get all users from the database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCEESS"
			)
	@GetMapping("allUsers")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(users,HttpStatus.OK);
		
	}
	
	@Operation(
			summary = "Update User By Id Rest API",
			description = "Update User By Id Rest API is used to update single user to a database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCEESS"
			)
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody @Valid UserDto user) {
		user.setId(userId);
		UserDto updatedUser = userService.updateUser(user);
		return new ResponseEntity<UserDto>(updatedUser,HttpStatus.OK);
	}
	
	@Operation(
			summary = "Delete User By Id Rest API",
			description = "Delete User By Id Rest API is used to delete single user from a database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 SUCCEESS"
			)
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User deleted successfully",HttpStatus.OK);
	}
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
//			ResourceNotFoundException exception, WebRequest webRequest) {
//		
//		ErrorDetails errorDetails = new ErrorDetails(
//				LocalDateTime.now(),
//				exception.getMessage(),
//				webRequest.getDescription(false),
//				"USER_NOT_FOUND"
//				);
//		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
//	
//		
//	}
}
