package io.pn.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
		@NotBlank(message = "Username can not blank")
		@Max(value = 20, message = "Username max be 20 only")
		@Min(value = 4, message = "Username should be more then 4 characters")
		String username,
		@NotBlank(message = "Password can not blank")
		@Max(value = 20, message = "Password max be 20 only")
		@Min(value = 4, message = "Password should be more then 4 characters")
		String password
		) {

}
