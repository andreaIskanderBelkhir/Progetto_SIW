package it.progetto.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.progetto.model.Richiesta;
import it.progetto.repository.RichiestaRepository;

@Service
public class RichiestaServices {

	@Autowired
	private RichiestaRepository richiestaRepository;
	
	@Transactional
	public List<Richiesta> tutti(){
		return (List<Richiesta>) richiestaRepository.findAll();
	}
}
