package com.example.SpringbootRestfulwebservices.dto;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
		description = "UserDTO Model Information"
		)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Long id;
	
	@Schema(
			description = "User first name"
			)
	//user first name should not be empty or null
	@NotEmpty(message = "user first name should not be empty or null")
	private String firstName;
	
	@Schema(
			description = "User last name"
			)
	//user last name should not be empty or null
	@NotEmpty(message = "user last name should not be empty or null")
	private String lastName;
	
	@Schema(
			description = "User email address"
			)
	//user email should not be empty or null
	@NotEmpty(message = "user email should not be empty or null")
	@Email(message = "user email should be valid")
	private String email;

}
