package model;

import java.time.LocalDate;

public class Foto {
	private String nome;
	private int id;
	private Fotografo fotografo;//1 a molti mono
	private String localita;
	private LocalDate data;
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
