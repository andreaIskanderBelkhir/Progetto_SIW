package it.progetto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Fotografo {

	private  String nome;
	private String cognome;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany
	@JoinColumn(name = "fotografo_id")
	private List<Album> album;//1 a molti mono

	public Fotografo(String string, String string2) {
		// TODO Auto-generated constructor stub
		this.nome=string;
		this.cognome=string2;
	}
	public Fotografo() {
		// TODO Auto-generated constructor stub
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
	public long getId() {
		return id;
	}
	public List<Album> getAlbum() {
		return album;
	}
	public void setAlbum(List<Album> album) {
		this.album = album;
	}
}
