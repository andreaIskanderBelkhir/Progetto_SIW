package it.progetto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Album {

	private String nome;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany
	@JoinColumn(name = "album_id")
	private List<Foto> fotoLista;
	@ManyToOne(cascade = CascadeType.ALL)
	private Fotografo fotografo;

	public Album(String string, Fotografo fotografo) {
		// TODO Auto-generated constructor stub
		this.nome=string;
		this.fotografo=fotografo;
	}
	public Album() {
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getId() {
		return id;
	}
	public List<Foto> getFotoLista() {
		return fotoLista;
	}
	public void setFotoLista(List<Foto> fotoLista) {
		this.fotoLista = fotoLista;
	}
}
