package it.progetto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.progetto.model.Foto;
import it.progetto.repository.FotoRepository;

@Service
public class FotoService {
	@Autowired 
	private FotoRepository foto;
	@Transactional 
	public Foto inserisci(Foto foto) {
		return this.foto.save(foto);
	}
	
	@Transactional
	public List<Foto> tutti(){
		return (List<Foto>) foto.findAll();
	}

	@Transactional
	public Foto fotoPerId(Long id) {
		return this.foto.findById(id).get();
	}
	
	@Transactional
	public Foto fotoPerNome(String nome) {
		return this.foto.findByNome(nome);
	}
}
