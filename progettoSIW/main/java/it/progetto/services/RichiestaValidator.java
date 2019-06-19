package it.progetto.services;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import it.progetto.model.Richiesta;

@Component
public class RichiestaValidator implements org.springframework.validation.Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Richiesta.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nomeRichiedente","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cognomeRichiedente","required");
	}
}

