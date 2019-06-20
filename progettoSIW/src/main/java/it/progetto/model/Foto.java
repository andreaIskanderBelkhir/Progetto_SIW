package it.progetto.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Foto {

	private String nome;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private Fotografo fotografo;//1 a 1 mono
	private String localita;
	private LocalDate data;
	private String url;
	@OneToMany
	private Album album;
	
	public Foto(String string, Album album1, Fotografo fotografoAndrea, String string2) {
		// TODO Auto-generated constructor stub
		this.nome=string;
		this.fotografo=fotografoAndrea;
		this.album=album1;
		this.url=string2;
	}
	public Foto() {
		// TODO Auto-generated constructor stub
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public Fotografo getFotografo() {
		return fotografo;
	}
	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}
	public String getLocalita() {
		return localita;
	}
	public void setLocalita(String localita) {
		this.localita = localita;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
}
