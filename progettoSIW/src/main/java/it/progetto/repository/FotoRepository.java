package it.progetto.repository;

import org.springframework.data.repository.CrudRepository;

import it.progetto.model.Foto;

public interface FotoRepository extends CrudRepository<Foto, Long>{
	
	//findByDatiDaRecuperare(sarebbero le variabili)
	public Foto findByNome(String nome);


}
