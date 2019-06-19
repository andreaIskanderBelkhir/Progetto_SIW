package it.progetto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.progetto.model.Foto;

public interface FotoRepository extends CrudRepository<Foto, Long>{
	
	//findByDatiDaRecuperare(sarebbero le variabili)
	public List<Foto> findByNome(String nome);


}
