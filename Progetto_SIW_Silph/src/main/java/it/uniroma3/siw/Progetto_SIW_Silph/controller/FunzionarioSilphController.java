package it.uniroma3.siw.Progetto_SIW_Silph.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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
	
	//funzionario
	@RequestMapping(value="/operazioniFunzionario", method=RequestMethod.POST)
	public String operazioneGiusta(@RequestParam("operazione") String operazioneValore) {
		return "gestione"+operazioneValore+".html";
		
	}
	

	
	
	

}
