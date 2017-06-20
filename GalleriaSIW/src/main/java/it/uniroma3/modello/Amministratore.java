package it.uniroma3.modello;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Amministratore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=1)
	private String password;
	
	@NotNull
	@Size(min=1)
	private String username;
	
	@NotNull
	@Size(min=1)
	private String email;
	
	@NotNull
	@Size(min=1)
	private String nome;
	
	@NotNull
	@Size(min=1)
	private String cognome;

	private String ruolo = "ADMIN";

	public Amministratore() {
		
	}
	
	public Amministratore(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRuolo() {
		return ruolo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	
	
}
