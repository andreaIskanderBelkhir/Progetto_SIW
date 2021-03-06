package it.progetto.auth;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.progetto.model.Admin;
import it.progetto.repository.AdminRepository;

@Component
public class DBPopulation implements ApplicationRunner {

    @Autowired
    private AdminRepository adminR;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.deleteAll();
        this.populateDB();
    }

    private void deleteAll() {
        System.out.println("Deleting all users from DB...");
        adminR.deleteAll();
        System.out.println("Done");
    }

    private void populateDB() throws IOException, InterruptedException {

        System.out.println("Storing users...");

        Admin admin = new Admin(1L, "admin", null, "ADMIN");
        String adminPassword = new BCryptPasswordEncoder().encode("admin");
        admin.setPassword(adminPassword);
        admin = this.adminR.save(admin);

        System.out.println("Done.\n");
    }
}

