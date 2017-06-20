package it.uniroma3.repositories;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.modello.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long> {
	
	public List<Autore> findAll();
	public List<Autore> findByNome(String nome);
	public List<Autore> findByCognome(String cognome);
	public List<Autore> findByNazionalita(String nazionalita);
	public List<Autore> findByDataNascita(Date data);

}
