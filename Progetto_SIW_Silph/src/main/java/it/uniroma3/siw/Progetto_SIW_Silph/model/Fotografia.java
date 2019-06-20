package it.uniroma3.siw.Progetto_SIW_Silph.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fotografia {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column
	private String nome;
	@Column
	private String descrizione;
	@Column 
	private String URLfoto;
	//associazioni

	@ManyToOne(fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST,
			CascadeType.REFRESH})
	private Fotografo fotografo;

	@ManyToOne(fetch=FetchType.EAGER,cascade= {CascadeType.PERSIST,
			CascadeType.REFRESH})
	private Album album;

	public Fotografia() {
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
	public Fotografo getFotografo() {
		return fotografo;
	}
	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getURLfoto() {
		return URLfoto;
	}

	public void setURLfoto(String uRLfoto) {
		URLfoto = uRLfoto;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
}
