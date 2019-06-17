package it.progetto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import it.progetto.model.Foto;
import it.progetto.model.Fotografo;
import it.progetto.repository.FotoRepository;
import it.progetto.repository.FotografoRepository;

public class FotografoService {
	@Autowired 
	private FotografoRepository fotografo;
	@Transactional 
	public Fotografo inserisci(Fotografo fotografo) {
		return this.fotografo.save(fotografo);
	}
	
	@Transactional
	public List<Fotografo> tutti(){
		return (List<Fotografo>) fotografo.findAll();
	}

	public Fotografo fotografoPerId(Long id) {
		return this.fotografo.findById(id).get();
	}
}
