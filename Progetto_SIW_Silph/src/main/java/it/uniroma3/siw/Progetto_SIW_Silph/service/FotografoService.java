package it.uniroma3.siw.Progetto_SIW_Silph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografo;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.FotografoRepository;

@Service
public class FotografoService {
	//TODO
	@Autowired
	private FotografoRepository fotografoRepository;
	
	@Transactional
	public Fotografo Inserisci (Fotografo f) {
		//questa classe dipende dal repository
		return fotografoRepository.save(f);
	}
	
	@Transactional
	public List<Fotografo> tuttiIFotografi () {
		return (List<Fotografo>) fotografoRepository.findAll();
	}
	
	public Fotografo FotografoPerId (Long id) {
		return this.fotografoRepository.findById(id).get();
	}
}
