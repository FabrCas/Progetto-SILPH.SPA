package it.uniroma3.siw.Progetto_SIW_Silph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.Progetto_SIW_Silph.model.FunzionarioSilph;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.FunzionarioSilphRepository;



@Service
public class FunzionarioSilphService {
	@Autowired
	private FunzionarioSilphRepository funzionarioSilphRepository;
	
	@Transactional
	public FunzionarioSilph Inserisci (FunzionarioSilph fs) {
		//questa classe dipende dal repository
		return funzionarioSilphRepository.save(fs);
	}
	
	@Transactional
	public List<FunzionarioSilph> tuttiIFunzionariSilph () {
		return (List<FunzionarioSilph>) funzionarioSilphRepository.findAll();
	}
	
	public FunzionarioSilph FunzionarioSilpgPerId (Long id) {
		return this.funzionarioSilphRepository.findById(id).get();
	}
}
