package model;

import java.util.LinkedList;
import java.util.List;

public class Richiesta {
	
	private Long id;
	private String nomeRichiedente;
	private String cognomeRichiedente;
	private List<Integer> idFotografie;
	
	public Richiesta(String nome,String cognome) {
		this.nomeRichiedente = nome;
		this.cognomeRichiedente = cognome;
		this.idFotografie = new LinkedList<Integer>();
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
	
	public List<Integer> getIdFotografie() {
		return idFotografie;
	}
	
	public void setIdFotografie(List<Integer> idFotografie) {
		this.idFotografie = idFotografie;
	}

}
