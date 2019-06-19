package it.uniroma3.siw.Progetto_SIW_Silph;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografia;
import it.uniroma3.siw.Progetto_SIW_Silph.model.Utente;
import it.uniroma3.siw.Progetto_SIW_Silph.repository.UtenteRepository;
import it.uniroma3.siw.Progetto_SIW_Silph.service.FotografiaService;

@Component
public class DBPopulation implements ApplicationRunner {

    @Autowired
    private UtenteRepository FunzionarioRepository;
    
    @Autowired
    private FotografiaService fotografiaService;

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

        Utente admin = new Utente(1L, "Mario", "Rossi", "mariorossi", null, "ADMIN");
        String adminPassword = new BCryptPasswordEncoder().encode("mrpass");
        admin.setPassword(adminPassword);
        admin = this.FunzionarioRepository.save(admin);
        
        Fotografia foto1= new Fotografia();
        foto1.setNome("a");
        foto1.setURLfoto("/images/a.jpg");
        Fotografia foto2= new Fotografia();
        foto2.setNome("b");
        foto2.setURLfoto("/images/b.jpg");
        Fotografia foto3= new Fotografia();
        foto3.setNome("c");
        foto3.setURLfoto("/images/c.jpg");
        Fotografia foto4= new Fotografia();
        foto4.setNome("d");
        foto4.setURLfoto("/images/d.jpg");
        //immagine in remoto
        Fotografia foto5= new Fotografia();
        foto5.setNome("w3");
        foto5.setURLfoto("https://www.w3schools.com/images/w3schools_green.jpg");
        
        this.fotografiaService.inserisci(foto1);
        this.fotografiaService.inserisci(foto2);
        this.fotografiaService.inserisci(foto3);
        this.fotografiaService.inserisci(foto4);
        this.fotografiaService.inserisci(foto5);

        System.out.println("Done.\n");
    }

	
}