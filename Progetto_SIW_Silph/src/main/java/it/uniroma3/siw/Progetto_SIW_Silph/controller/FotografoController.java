package it.uniroma3.siw.Progetto_SIW_Silph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografo;
import it.uniroma3.siw.Progetto_SIW_Silph.service.AlbumService;
import it.uniroma3.siw.Progetto_SIW_Silph.service.FotografiaService;
import it.uniroma3.siw.Progetto_SIW_Silph.service.FotografoService;
import it.uniroma3.siw.Progetto_SIW_Silph.service.FotografoValidator;

@Controller
public class FotografoController {
	
	@Autowired
	private FotografoService fotografoService;
	
	@Autowired
	private FotografoValidator fotografoValidator;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private FotografiaService fotografiaService;
	
	
	//TODO
	//Inserimento fotografo, dalla form, con collezioni.
	
	@RequestMapping(value = "/fotografo/{id}", method = RequestMethod.GET)
	public String getAlbum(@PathVariable ("id") Long id, Model model) {
		if(id!=null) {
			model.addAttribute("fotografo", this.fotografoService.FotografoPerId(id));
			return "fotografo.html";
		}else {
			model.addAttribute("fotografi", this.fotografoService.tuttiIFotografi());
			return "fotografi.html";
		}
	}
	
	@RequestMapping("/addFotografo")
	public String addFotografo(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		return "fotografoForm.html";
	}

}
