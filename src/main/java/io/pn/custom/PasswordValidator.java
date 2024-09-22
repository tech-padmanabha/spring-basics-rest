package io.pn.custom;

import io.pn.custom.annotation.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value == null)
			return false;
		if (value.length() < 8 || value.length() > 20)
			return false;
		if (!value.matches(".*[A-Z].*") && !value.matches(".*[a-z].*"))
			return false;
		if (!value.matches(".*\\d.*"))
			return false;
		if (!value.matches(".*[~!@#$%^&*()].*"))
			return false;
		return true;
	}

}
