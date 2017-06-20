package it.uniroma3.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import it.uniroma3.modello.Autore;
import it.uniroma3.modello.Opera;
import it.uniroma3.repositories.OperaRepository;

@Service
@Transactional
public class OperaService {

	@Autowired
	private OperaRepository repository;
	
	
	public List<Opera> cercaOpere(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void aggiungiOpera(Opera opera) {
		this.repository.save(opera);
	}
	
	public List<Opera> cercaPerTitolo(String titolo) {
		return this.repository.findByTitolo(titolo);
	}
	
	public List<Opera> cercaPerAnno(Integer anno) {
		return this.repository.findByAnno(anno);
	}
	
	public List<Opera> cercaPerTecnica(String tecnica) {
		return this.repository.findByTecnica(tecnica);
	}
	
	public List<Opera> cercaPerDimensioni(String dimensioni) {
		return this.repository.findByDimensioni(dimensioni);
	}
	
	public List<Opera> cercaPerAutore(Autore autore) {
		return this.repository.findByAutore(autore);
	}

	
	public Opera cercaOpera(Long id) {
		return this.repository.findOne(id);
	}
	
	public void cancellaOpera(Long id) {
		this.repository.delete(id);
	}
	

}
