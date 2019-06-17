package it.uniroma3.siw.Progetto_SIW_Silph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class FunzionarioSilphController {
	
	
	//dopo l'accesso, solo funzionario
	@RequestMapping("/attivitaFunzionario")
	public String attivitaFunzionario() {
		return "reindirizzamentoFunzionario.html";
	}
	
	//dall'index, funzionario e utente
	@RequestMapping("/toSito")
	public String vaiAlSito() {
		return "paginaSito.html";
	}
	
	//funzionario
	@RequestMapping("/inserimentoDati")
	public String InserimentoNuoviDati() {
		return "salvataggioNuoviDati.html";
	}
}
