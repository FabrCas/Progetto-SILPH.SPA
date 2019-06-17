package it.uniroma3.siw.Progetto_SIW_Silph;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.Progetto_SIW_Silph.model.FunzionarioSilph;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.FunzionarioSilphRepository;

@Component
public class DBPopulation implements ApplicationRunner {

    @Autowired
    private FunzionarioSilphRepository FunzionarioRepository;


    public void run(ApplicationArguments args) throws Exception {
        this.deleteAll();
        this.populateDB();
    }

    private void deleteAll() {
        System.out.println("Deleting all Funzionario from DB...");
        FunzionarioRepository.deleteAll();
        System.out.println("Done");
    }

    private void populateDB() throws IOException, InterruptedException {

        System.out.println("Storing users...");

        FunzionarioSilph admin = new FunzionarioSilph(1L, "Mario", "Rossi", "mariorossi", null, "ADMIN");
        String adminPassword = new BCryptPasswordEncoder().encode("mrpass");
        admin.setPassword(adminPassword);
        admin = this.FunzionarioRepository.save(admin);

    

        System.out.println("Done.\n");
    }

	
}