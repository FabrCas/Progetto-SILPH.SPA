package Model;
import java.util.*;
public class Album {

	private String nome;
	private Long id;
	private HashMap<Long,Fotografia> fotografie;

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
	public HashMap<Long, Fotografia> getFotografie() {
		return fotografie;
	}
	public void setFotografie(HashMap<Long, Fotografia> fotografie) {
		this.fotografie = fotografie;
	}
}
