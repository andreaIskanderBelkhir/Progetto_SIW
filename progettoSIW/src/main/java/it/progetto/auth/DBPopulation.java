package it.progetto.auth;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.progetto.model.Admin;
import it.progetto.model.Album;
import it.progetto.model.Foto;
import it.progetto.model.Fotografo;
import it.progetto.repository.AdminRepository;
import it.progetto.repository.AlbumRepository;
import it.progetto.repository.FotoRepository;
import it.progetto.repository.FotografoRepository;

@Component
public class DBPopulation implements ApplicationRunner {

    @Autowired
    private AdminRepository adminR;
    @Autowired
    private FotoRepository fotoR;
    @Autowired
    private FotografoRepository fotografoR;
    @Autowired
    private AlbumRepository albumR;
   

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
        Fotografo fotografoAndrea =new Fotografo("andrea","belkhir");
        Album album1 = new Album ("cose",fotografoAndrea);
        Foto foto1 = new Foto ("foto1",album1,fotografoAndrea,"https://bit.ly/2WWrQDJ");
        System.out.println("Done.\n");
        this.albumR.save(album1);
        this.fotografoR.save(fotografoAndrea);
        this.fotoR.save(foto1);
    }
}

