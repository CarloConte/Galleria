package it.uniroma3.service;



import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import it.uniroma3.modello.Autore;
import it.uniroma3.repositories.AutoreRepository;

@Service
@Transactional
public class AutoreService {
	
	@Autowired
	private AutoreRepository repository;
	
	public AutoreService() {
	
	}
	
	public List<Autore> cercaAutori() {
		return this.repository.findAll();
	}
	
	
	public void inserisciAutore(Autore autore) {
		this.repository.save(autore);
	}
	
	@Transactional
	public void cancellaAutore(Autore autore) {
		this.repository.delete(autore);
	}
	
	public Autore cercaAutore(Long id) {
		return this.repository.findOne(id);
	}
	
	public List<Autore> cercaPerNome(String nome) {
		return this.repository.findByNome(nome);
	}
	
	public List<Autore> cercaPerCognome(String cognome) {
		return this.repository.findByCognome(cognome);
	}
	
	public List<Autore> cercaPerNazionalita(String nazionalita) {
		return this.repository.findByNazionalita(nazionalita);
	}
	
	public List<Autore> cercaPerDataNascita(Date data) {
		return this.repository.findByDataNascita(data);
	}

}
