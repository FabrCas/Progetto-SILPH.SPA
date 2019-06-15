package it.uniroma3.siw.Progetto_SIW_Silph.model;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Fotografo {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column
	private String nome;
	@Column
	private String cognome;
	//associazioni
	
	@ManyToMany(fetch= FetchType.LAZY, cascade= {CascadeType.PERSIST,
			CascadeType.REFRESH})
	private List <Album> albums;
	
	@OneToMany(mappedBy="fotografo", fetch=FetchType.EAGER,
			cascade= {CascadeType.PERSIST, CascadeType.REFRESH,
		CascadeType.REMOVE})
	private Map <Long,Fotografia> fotografie;
	
	public Fotografo() {
	}
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
	public List <Album> getAlbums() {
		return albums;
	}
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	public Map<Long, Fotografia> getFotografie() {
		return fotografie;
	}
	public void setFotografie(Map<Long, Fotografia> fotografie) {
		this.fotografie = fotografie;
	}
}
