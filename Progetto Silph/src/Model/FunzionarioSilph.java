package Model;

import java.util.Map;

public class FunzionarioSilph {
	private Long id;
	private String nome;
	private String cognome;
	private Galleria gallery;
	private Map<Long,RichiestaFoto> richieste;
	
	
	
	
	
	
	
	
	
	//getters && setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Galleria getGallery() {
		return gallery;
	}
	public void setGallery(Galleria gallery) {
		this.gallery = gallery;
	}
	public Map<Long, RichiestaFoto> getRichieste() {
		return richieste;
	}
	public void setRichieste(Map<Long, RichiestaFoto> richieste) {
		this.richieste = richieste;
	}
	
	
	

}
