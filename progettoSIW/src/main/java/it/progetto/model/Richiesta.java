package it.progetto.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Richiesta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomeRichiedente;
	private String cognomeRichiedente;
	private String dataDiNascita;
	@OneToMany
	@JoinColumn(name = "richiesta_id")
	List<Foto> fotografie;
	
	
	public List<Foto> getFotografie() {
		return fotografie;
	}
	public void setFotografie(List<Foto> fotografie) {
		this.fotografie = fotografie;
	}
	public Long getId() {
		return id;
	}
	public String getNomeRichiedente() {
		return nomeRichiedente;
	}
	public void setNomeRichiedente(String nomeRichiedente) {
		this.nomeRichiedente = nomeRichiedente;
	}
	public String getCognomeRichiedente() {
		return cognomeRichiedente;
	}
	public void setCognomeRichiedente(String cognomeRichiedente) {
		this.cognomeRichiedente = cognomeRichiedente;
	}
	public String getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

}
