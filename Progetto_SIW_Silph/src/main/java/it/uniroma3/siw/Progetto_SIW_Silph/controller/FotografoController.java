package it.uniroma3.siw.Progetto_SIW_Silph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografo;


@Controller
public class FotografoController {
	
	@RequestMapping("/addFotografo")
	public String addFotografo(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		return "fotografoForm.html";
	}

}
