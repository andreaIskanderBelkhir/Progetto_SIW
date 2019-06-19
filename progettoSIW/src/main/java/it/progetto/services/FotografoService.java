package it.progetto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.progetto.model.Fotografo;
import it.progetto.repository.FotografoRepository;

@Service
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

	@Transactional
	public Fotografo fotografoPerId(Long id) {
		return this.fotografo.findById(id).get();
	}
	
	@Transactional
	public Fotografo fotografoPerNomeEcognome(String nome,String cognome) {
		return this.fotografo.findByNomeAndCognome(nome,cognome);
	}
}
