package it.uniroma3.siw.Progetto_SIW_Silph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Album;
import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografia;

@Controller
public class FotografiaController {
	
	@RequestMapping("/addFotografia")
	public String addFotografia(Model model) {
		model.addAttribute("fotografia", new Fotografia());
		return "fotografiaForm.html";
	}


}
