package it.uniroma3.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.modello.Autore;
import it.uniroma3.modello.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long> {

	public List<Opera> findAll();
	public List<Opera> findByAnno(Integer anno);
	public List<Opera> findByTitolo(String titolo);
	public List<Opera> findByTecnica(String tecnica);
	public List<Opera> findByDimensioni(String dimensioni);
	public List<Opera> findByAutore(Autore autore);
	
}
