package it.uniroma3.modello;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Autore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;
	
	@NotNull
	private String cognome;
	
	@NotNull
	private String nazionalita;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dataNascita;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dataMorte;
	
	@OneToMany(mappedBy="autore",cascade=CascadeType.REMOVE)
	private List<Opera> opere;
	
	private String imgUrl;
	
	public Autore() {
	}
	

	public Autore(String nome, String cognome, String nazionalita, Date dataNascita, Date dataMorte) {
		this.nome = nome;
		this.cognome = cognome;
		this.nazionalita = nazionalita;
		this.dataNascita = dataNascita;
		this.dataMorte = dataMorte;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}
	
	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}
	
	public List<Opera> getOpere() {
		return this.opere;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
	
//	@Override
//	public boolean equals(Object o) {
//		Autore that = (Autore)o;
//		return (this.getId().equals(that.getId()));
//	}
//	
//	@Override
//	public int hashCode() {
//		return this.getId().hashCode();
//	}
}
