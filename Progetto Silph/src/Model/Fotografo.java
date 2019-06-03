package Model;

import java.util.Map;

public class Fotografo {

	private Long id;
	private String nome;
	private String cognome;
	private Map <Long,Album> albums;
	private Map <Long,Fotografia> fotografie;

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
	public Map<Long, Album> getAlbums() {
		return albums;
	}
	public void setAlbums(Map<Long, Album> albums) {
		this.albums = albums;
	}
	public Map<Long, Fotografia> getFotografie() {
		return fotografie;
	}
	public void setFotografie(Map<Long, Fotografia> fotografie) {
		this.fotografie = fotografie;
	}
}
