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
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	private String password;
	private String role;
	@OneToMany
	@JoinColumn(name = "admin_id")
	private List<Richiesta> richieste;
	
	public Admin(Long id, String username, String password,String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role=role;
	}

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
