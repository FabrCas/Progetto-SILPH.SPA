package it.uniroma3.siw.Progetto_SIW_Silph.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografia;

@Component
public class FotografiaValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Fotografia.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "URLfoto", "required");
		
	}

}
