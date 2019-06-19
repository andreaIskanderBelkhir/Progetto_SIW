package it.progetto.repository;

import org.springframework.data.repository.CrudRepository;

import it.progetto.model.Album;

public interface AlbumRepository extends CrudRepository<Album, Long>{
	
	//findByDatiDaRecuperare(sarebbero le variabili)
	public Album findByNome(String nome);


}
