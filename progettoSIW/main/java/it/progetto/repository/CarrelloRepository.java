package it.progetto.repository;

import org.springframework.data.repository.CrudRepository;

import it.progetto.model.Carrello;

public interface CarrelloRepository extends CrudRepository<Carrello, Long> {
	
}
