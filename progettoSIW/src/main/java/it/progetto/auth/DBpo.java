package it.progetto.auth;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import it.progetto.model.Admin;
import it.progetto.repository.AdminRepository;

public class DBpo implements ApplicationRunner {
	@Autowired
	private AdminRepository admin;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		this.population();
	}
	private void population() throws IOException, InterruptedException{
		if(admin.count()==0) {
			Admin admin = new Admin("admin", null, "ADMIN");
			String adminPassword = new BCryptPasswordEncoder().encode("admin");
			admin.setPassword(adminPassword);
			admin = this.admin.save(admin);  
		}
	}
}
