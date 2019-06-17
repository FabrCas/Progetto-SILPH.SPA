package it.uniroma3.siw.Progetto_SIW_Silph.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.Progetto_SIW_Silph.service.RichiestaFotoService;

@Controller
public class FunzionarioSilphController {
	@Autowired
	RichiestaFotoService richiestaFotoService;
	
	

	
	@RequestMapping("/attivitaFunzionario")
	public String attivitaFunzionario() {
		return "reindirizzamentoFunzionario.html";
	}
	
	@RequestMapping("/toSito")
	public String vaiAlSito() {
		return "paginaSito.html";
	}
	
	@RequestMapping("/inserimentoDati")
	public String InserimentoNuoviDati() {
		return "salvataggioNuoviDati.html";
	}
	
	@RequestMapping("/visualizzaRichieste")
	public String visualizzaRichieste(Model model){
		model.addAttribute("richieste", this.richiestaFotoService.tutteLeRichiesteFoto());
		return "richiesteDiUtilizzo.html";
	}
	
	
	

}
