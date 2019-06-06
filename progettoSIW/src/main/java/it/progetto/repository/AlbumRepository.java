package it.progetto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.progetto.model.Album;


public interface AlbumRepository extends CrudRepository<Album, Long>{
	
	//findByDatiDaRecuperare(sarebbero le variabili)
	public List<Album> findByNome(String nome);


}
