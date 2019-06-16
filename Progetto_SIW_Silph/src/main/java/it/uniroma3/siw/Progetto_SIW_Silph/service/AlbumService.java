package it.uniroma3.siw.Progetto_SIW_Silph.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Album;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.AlbumRepository;

@Service
public class AlbumService {
	//TODO
	@Autowired
	private AlbumRepository albumRepostiory;
	
	@Transactional
	public Album inserisci (Album a) {
		//questa classe dipende dal repository
		return albumRepostiory.save(a);
	}
	
	@Transactional
	public List<Album> tuttiGliAlbum () {
		return (List<Album>) albumRepostiory.findAll();
	}
	@Transactional
	public Album AlbumPerId (Long id) {
		return this.albumRepostiory.findById(id).get();
	}
}

