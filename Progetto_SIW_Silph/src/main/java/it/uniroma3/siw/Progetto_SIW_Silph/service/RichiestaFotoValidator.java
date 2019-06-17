package it.uniroma3.siw.Progetto_SIW_Silph.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.Progetto_SIW_Silph.model.RichiestaFoto;

@Component
public class RichiestaFotoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return RichiestaFoto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeUtente", "required");
		ValidationUtils.rejectIfEmpty(errors, "fotografie", "required");
	}

}
