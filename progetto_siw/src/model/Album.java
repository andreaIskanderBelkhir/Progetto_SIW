package model;

import java.util.List;

public class Album {
	private String nome;
	private int id;
	private List<Foto> fotoLista;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Foto> getFotoLista() {
		return fotoLista;
	}
	public void setFotoLista(List<Foto> fotoLista) {
		this.fotoLista = fotoLista;
	}
}
