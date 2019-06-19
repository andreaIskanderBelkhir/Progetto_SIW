package it.progetto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.progetto.model.Album;
import it.progetto.repository.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository album;
	@Transactional 
	public Album inserisci(Album album) {
		return this.album.save(album);
	}
	
	@Transactional
	public List<Album> tutti(){
		return (List<Album>) album.findAll();
	}

	@Transactional
	public Album albumPerId(Long id) {
		return this.album.findById(id).get();
	}
	
	@Transactional
	public Album albumPerNome(String nome) {
		return this.album.findByNome(nome);
	}
}
