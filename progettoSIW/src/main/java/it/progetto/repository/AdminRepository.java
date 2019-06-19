package it.progetto.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.validation.BindingResult;

import it.progetto.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long>{
	
	//findByDatiDaRecuperare(sarebbero le variabili)
	public List<Admin> findByIdAndPassword(long id, String password);

	public Admin findByUsername(String username);


}
