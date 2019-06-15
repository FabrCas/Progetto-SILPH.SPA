package it.uniroma3.siw.Progetto_SIW_Silph.model;

import java.util.List;
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
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String nome;
	//associazioni
	
	@ManyToMany(mappedBy="albums", fetch= FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Fotografo> fotografi;
	
	@OneToMany(mappedBy="album", fetch=FetchType.EAGER,
			cascade= {CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Fotografia> fotografie;


	public Album() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List <Fotografia> getFotografie() {
		return fotografie;
	}
	public void setFotografie(List<Fotografia> fotografie) {
		this.fotografie = fotografie;
	}
	public List<Fotografo> getFotografi() {
		return fotografi;
	}
	public void setFotografi(List<Fotografo> fotografi) {
		this.fotografi = fotografi;
	}
	
	//commento di prova, per vedere se il progetto maven è stato finalmente importato correttamente!!!
}
