package it.uniroma3.siw.Progetto_SIW_Silph.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String nome;
	@Column
	private Map<Long,Fotografia> fotografie;
	@Column
	private List<Fotografo> fotografi;

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
	public Map<Long, Fotografia> getFotografie() {
		return fotografie;
	}
	public void setFotografie(Map<Long, Fotografia> fotografie) {
		this.fotografie = fotografie;
	}
	public List<Fotografo> getFotografi() {
		return fotografi;
	}
	public void setFotografi(List<Fotografo> fotografi) {
		this.fotografi = fotografi;
	}
}
