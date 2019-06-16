package it.uniroma3.siw.Progetto_SIW_Silph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografia;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.FotografiaRepository;


@Service
public class FotografiaService {
	@Autowired
	private FotografiaRepository fotografiaRepository;
	
	@Transactional
	public Fotografia inserisci (Fotografia f) {
		//questa classe dipende dal repository
		return fotografiaRepository.save(f);
	}
	
	@Transactional
	public List<Fotografia> tutteLeFotografie () {
		return (List<Fotografia>) fotografiaRepository.findAll();
	}
	@Transactional
	public Fotografia FotografiaPerId (Long id) {
		return this.fotografiaRepository.findById(id).get();
	}
}