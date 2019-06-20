package it.uniroma3.siw.Progetto_SIW_Silph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Utente;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.UtenteRepository;



@Service
public class UtenteService {
	@Autowired
	private UtenteRepository utenteRepository;

	@Transactional
	public Utente inserisci (Utente fs) {
		//questa classe dipende dal repository
		return utenteRepository.save(fs);
	}

	@Transactional
	public List<Utente> tuttiGliUtenti () {
		return (List<Utente>) utenteRepository.findAll();
	}
	@Transactional
	public Utente UtentiPerId (Long id) {
		return this.utenteRepository.findById(id).get();
	}
}
