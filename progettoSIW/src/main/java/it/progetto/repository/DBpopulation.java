package it.progetto.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.progetto.model.Admin;
@Component
public class DBpopulation implements ApplicationRunner {
	@Autowired
	private AdminRepository admrep;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		this.deleteAll();
		this.addAll();

	}
	public void deleteAll() {
		admrep.deleteAll();
	}
public void addAll() {
	Admin ad=new Admin("admin","admin","ADMIN");
	admrep.save(ad);
}
}
