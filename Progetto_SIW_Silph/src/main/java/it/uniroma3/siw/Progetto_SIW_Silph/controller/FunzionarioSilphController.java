package it.uniroma3.siw.Progetto_SIW_Silph.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



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
		return "home.html";
	}
	
	//funzionario
	/*
	@RequestMapping("/inserimentoDati")
	public String InserimentoNuoviDati() {
		return "salvataggioNuoviDati.html";
	}*/
	
	 @RequestMapping(value = { "/inserimentoDati" }, method = RequestMethod.GET)
	    public String admin(Model model) {
	        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        String role = details.getAuthorities().iterator().next().getAuthority();    // get first authority
	        model.addAttribute("username", details.getUsername());
	        model.addAttribute("role", role);

	        return "salvataggioNuoviDati.html";
	    }
}
