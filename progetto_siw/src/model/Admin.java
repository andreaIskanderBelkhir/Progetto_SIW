package model;

import java.util.List;

public class Admin {
	private String nome;
	private String id;
	private String password;
	private List<Richiesta> richieste;

	public List<Richiesta> getRichieste() {
		return richieste;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}