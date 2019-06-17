package it.progetto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.progetto.model.Album;
import it.progetto.model.Foto;
import it.progetto.repository.AlbumRepository;
import it.progetto.repository.FotoRepository;

@Service
public class AlbumService {
	@Autowired 
	private FotoRepository foto;
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

	public Album albumPerId(Long id) {
		return this.album.findById(id).get();
	}
}
