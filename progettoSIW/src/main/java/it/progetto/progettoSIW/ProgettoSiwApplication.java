package it.progetto.progettoSIW;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import it.progetto.model.Admin;
import it.progetto.repository.AdminRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"it"})
@EnableJpaRepositories("it.progetto.repository")
@EntityScan("it.progetto.*")
public class ProgettoSiwApplication {
	
	@Autowired
    private AdminRepository adminR;

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSiwApplication.class, args);
	}

	@PostConstruct
	private void populateDB() throws IOException, InterruptedException {

        System.out.println("Storing users...");

        Admin admin = new Admin(1L, "admin", null, "ADMIN");
        String adminPassword = new BCryptPasswordEncoder().encode("admin");
        admin.setPassword(adminPassword);
        admin = this.adminR.save(admin);

        System.out.println("Done.\n");
    }
}
