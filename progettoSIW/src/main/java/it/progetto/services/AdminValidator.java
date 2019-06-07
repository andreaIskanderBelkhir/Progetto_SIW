package it.progetto.services;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.progetto.model.Admin;

public class AdminValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Admin.class.equals(aClass);
	}

	//per controllare che non ci siano campi vuoti nella form
	@Override
	public void validate(Object o, Errors error) {
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "id", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "required");
	}
	
}
