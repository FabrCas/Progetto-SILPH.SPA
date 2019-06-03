package Model;

import java.util.Map;

public class Galleria {
	private Long id;
	private String nome;
	private Map<Long,Album> album;
	private RichiestaFoto richiesta;
	
	
	
	
	
	
	
	
	
	
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
	public Map<Long, Album> getAlbum() {
		return album;
	}
	public void setAlbum(Map<Long, Album> album) {
		this.album = album;
	}
	public RichiestaFoto getRichiesta() {
		return richiesta;
	}
	public void setRichiesta(RichiestaFoto richiesta) {
		this.richiesta = richiesta;
	}
	
	
	
	
	
	
	
}
