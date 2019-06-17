package it.progetto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.progetto.model.Richiesta;

public interface RichiestaRepository extends CrudRepository<Richiesta, Long>{

	public List<Richiesta> findByNomeAndCognome(String nome , String cognome);

}
