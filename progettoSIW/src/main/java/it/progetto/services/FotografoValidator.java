package it.progetto.services;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import it.progetto.model.Fotografo;

@Component
public class FotografoValidator implements org.springframework.validation.Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Fotografo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nome","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cognome","required");
	}
}

