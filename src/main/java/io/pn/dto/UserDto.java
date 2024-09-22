package io.pn.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import io.pn.custom.annotation.ValidPassword;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UserDto(
		
		@NotBlank(message = "Username can not blank")
		@Size(min = 4,max = 20,message = "Username length should be 4 to 20 letters")
		String username,
		
		@ValidPassword(message = "password should be 8 to 20 letter including digits,UPPER,lower,special Keys")
		@NotNull
		String password,
		
		@Size(min = 5,message = "Email should minimum 5 letters")
		@Email(message = "Email ID is not Valid")
		String email,
		
		@Size(min = 10,max = 10, message = " Provide 10 digits Mobile Number" )
		String mobileNo,
		
		@DecimalMin(value = "100000", message = "Provide Proper Annual CTC")
		BigDecimal annualCTC,
		
		@AssertTrue(message = "Application Status should not be false")
		Boolean appStatus,
		
		@Past(message = "Date of Birth is not Valid")
		LocalDate dob,
		
		@Future(message = "Date Of Join is not Valid")
		LocalDate doj,
		
		LocalTime timeOfJoin,
		
		@Positive(message = "EPF should provide 0 or negative numbers")
		Integer epf,
		
		@AssertFalse(message = "Attachment should be less in social status")
		Boolean socialStatus,
		
		@NotNull
		Character gender,
		
		@Positive(message = "EPF should provide 0 or negative numbers")
		Double insurenceAmt,
		
		@NegativeOrZero(message = "Provide Proper amount of daily cose")
		Double dailyCost
		) {

} 

// we can use bellow annotation to validate
// for valid data just follow the user.json file

/*
 * @AssertFalse (boolean)
 * 
 * @AssertTrue (boolean)
 * 
 * @DecimalMax
 * 
 * @DecimalMin
 * 
 * @Digits
 * 
 * @Email
 * 
 * @Future
 * 
 * @FutureOrPresent
 * 
 * @Max
 * 
 * @Min
 * 
 * @Negative
 * 
 * @NegativeOrZero
 * 
 * @NotBlank
 * 
 * @NotEmpty
 * 
 * @NotNull
 * 
 * @Null
 * 
 * @Past
 * 
 * @PastOrPresent
 * 
 * @Positive
 * 
 * @PositiveOrZero
 * 
 * @Size
 * 
 * @Pattern
 * 
 * validate
 * 
 * @Valid
 */

// for Password 

/* We are going to create our custom annotation
It contains at least 8 characters and at most 20 characters.
It contains at least one digit.
It contains at least one upper case alphabet.
It contains at least one lower case alphabet.
It contains at least one special character which includes !@#$%&*()-+=^.
It does not contain any white space.
**/