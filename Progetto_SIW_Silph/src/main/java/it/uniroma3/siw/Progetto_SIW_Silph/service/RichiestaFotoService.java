package it.uniroma3.siw.Progetto_SIW_Silph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.Progetto_SIW_Silph.model.RichiestaFoto;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.RichiestaFotoRepository;


@Service
public class RichiestaFotoService {
	@Autowired
	private RichiestaFotoRepository richiestaFotoRepository;

	@Transactional
	public RichiestaFoto inserisci (RichiestaFoto r) {
		//questa classe dipende dal repository
		return richiestaFotoRepository.save(r);
	}

	@Transactional
	public List<RichiestaFoto> tutteLeRichiesteFoto () {
		return (List<RichiestaFoto>) richiestaFotoRepository.findAll();
	}
	@Transactional
	public RichiestaFoto RichiestaFotoPerId (Long id) {
		return this.richiestaFotoRepository.findById(id).get();
	}
}
