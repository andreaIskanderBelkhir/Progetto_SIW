package it.progetto.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Admin {

	public Admin(String username, String password,String role) {
		this.username = username;
		this.password = password;
		this.role=role;
	}
	private String nome;
	private String cognome;
	private String username;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String password;
	private String role;
	@OneToMany
	@JoinColumn(name = "admin_id")
	private List<Richiesta> richieste;

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Richiesta> getRichieste() {
		return richieste;
	}
	public void setRichieste(List<Richiesta> richieste) {
		this.richieste = richieste;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
