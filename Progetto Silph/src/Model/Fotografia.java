package Model;

import java.util.Date;

public class Fotografia {

	private Long id;
	private String nome;
	private Date data;
	private String fotografo;
	
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getFotografo() {
		return fotografo;
	}
	public void setFotografo(String fotografo) {
		this.fotografo = fotografo;
	}
}
