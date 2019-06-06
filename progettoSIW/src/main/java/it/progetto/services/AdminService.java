package it.progetto.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.progetto.model.Admin;
import it.progetto.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminrepository;

	public boolean check(Admin admin) {
		Admin admin2 = this.adminrepository.findById(admin.getId()).get();
		if(admin.getPassword().equals(admin2.getPassword())) {
			return true;
		}
		return false;
	}
}
