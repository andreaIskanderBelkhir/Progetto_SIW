package it.progetto.services;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.progetto.model.Admin;
@Component
public class AdminValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Admin.class.equals(clazz);
}
	@Override
	public void validate(Object o, Errors error) {
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "username", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "required");
	}


}
