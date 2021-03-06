package it.uniroma3.siw.Progetto_SIW_Silph.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.bind.annotation.ModelAttribute;


@Entity
public class RichiestaFoto{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String nomeUtente;
	@Column
	private String email;
	@Column
	private String numero_telefonico;
	@Column
	private String descrizione;
	@Column
	@Temporal(TemporalType.DATE)
	private Date data;
	//associazione

	//nessun evento in cascata utile per questa associazione
	@ManyToMany(fetch= FetchType.EAGER, cascade= {CascadeType.PERSIST})
	private List<Fotografia> fotografie;

	public RichiestaFoto () {
		this.fotografie= new ArrayList<Fotografia>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@ModelAttribute("getFotografie")
	public List<Fotografia> getFotografie() {
		return fotografie;
	}

	public void setFotografie(List<Fotografia> fotografie) {
		this.fotografie = fotografie;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void addFotografia (Fotografia f) {
		this.getFotografie().add(f);
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumero_telefonico() {
		return numero_telefonico;
	}

	public void setNumero_telefonico(String numero_telefonico) {
		this.numero_telefonico = numero_telefonico;
	}

}
