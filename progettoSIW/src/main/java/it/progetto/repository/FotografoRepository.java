package it.progetto.repository;

import org.springframework.data.repository.CrudRepository;

import it.progetto.model.Fotografo;

public interface FotografoRepository extends CrudRepository<Fotografo, Long>{
	
	//findByDatiDaRecuperare(sarebbero le variabili)
	public Fotografo findByNomeAndCognome(String nome,String cognome);
	}
