package it.progetto.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {

	private String nome;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private List<Foto> fotoLista;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Foto> getFotoLista() {
		return fotoLista;
	}
	public void setFotoLista(List<Foto> fotoLista) {
		this.fotoLista = fotoLista;
	}
}
