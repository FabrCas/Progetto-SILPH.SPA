package it.uniroma3.siw.Progetto_SIW_Silph.repository;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.Progetto_SIW_Silph.model.Album;

public interface AlbumRepository extends CrudRepository <Album,Long> {
	//Aggiungere poi le query necessarie
}
