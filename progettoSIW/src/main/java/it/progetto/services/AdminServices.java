package it.progetto.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.progetto.model.Admin;
import it.progetto.repository.AdminRepository;

@Service
public class AdminServices {

	@Autowired
	private AdminRepository adminRepository;
	
	@Transactional
	public Admin adminPerId(Long id) {
		return this.adminRepository.findById(id).get();
	}
}
