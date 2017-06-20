package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.modello.Amministratore;
import it.uniroma3.repositories.AmministratoreRepository;

@Service
@Transactional
public class AmministratoreService {
	
	@Autowired
	private AmministratoreRepository admRepo;

	public List<Amministratore> cercaAmministratori() {
		return this.admRepo.findAll();
	}
	
	public Amministratore cercaAmministratore(String username) {
		return this.admRepo.findByUsername(username);
	}
	
	@Transactional
	public void cancellaAmministratore(Amministratore amministratore) {
		this.admRepo.delete(amministratore);
	}
	
	public Amministratore cercaAmministratorePerEmail(String email) {
		return this.admRepo.findByEmail(email);
	}
	
	@Transactional
	public void inserisciAmministratore(Amministratore amministratore) {
		this.admRepo.save(amministratore);
	}
	
	public Amministratore cercaPerUsername(String username) {
		return this.admRepo.findByUsername(username);
	}
	
	public Amministratore cercaPerEmail(String email) {
		return this.admRepo.findByEmail(email);
	}
	

	
	//eventualmente inserire cercaPerNome() e cercaPerCognome()
}
