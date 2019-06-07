package it.progetto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.progetto.model.Fotografo;

public interface FotografoRepository extends CrudRepository<Fotografo, Long>{
	
	//findByDatiDaRecuperare(sarebbero le variabili)
	public List<FotografoRepository> findByNome(String nome);
	}
