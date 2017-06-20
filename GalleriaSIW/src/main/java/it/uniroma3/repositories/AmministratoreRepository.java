package it.uniroma3.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.modello.Amministratore;

public interface AmministratoreRepository extends CrudRepository<Amministratore, Long>{
	
	public List<Amministratore> findAll();
	public Amministratore findByUsername(String username);
	public Amministratore findByEmail(String email);
	
}
