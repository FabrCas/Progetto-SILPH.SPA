package it.uniroma3.siw.Progetto_SIW_Silph.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.Progetto_SIW_Silph.model.RichiestaFoto;

@Repository
public interface RichiestaFotoRepository extends CrudRepository <RichiestaFoto,Long> {
	//Aggiungere poi le query necessarie
	public List<RichiestaFoto> findByNomeUtente (String nomeUtente);
}
