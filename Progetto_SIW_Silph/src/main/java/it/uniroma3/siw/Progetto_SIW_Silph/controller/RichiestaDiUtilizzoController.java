package it.uniroma3.siw.Progetto_SIW_Silph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.Progetto_SIW_Silph.service.RichiestaFotoService;

@Controller
public class RichiestaDiUtilizzoController {
	@Autowired
	RichiestaFotoService richiestaFotoService;
	
	
	
	@RequestMapping("/visualizzaRichieste")
	public String visualizzaRichieste(Model model){
		model.addAttribute("richieste", this.richiestaFotoService.tutteLeRichiesteFoto());
		return "richiesteDiUtilizzo.html";
	}
	
}
