package it.uniroma3.siw.Progetto_SIW_Silph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografia;
import it.uniroma3.siw.Progetto_SIW_Silph.service.AlbumService;
import it.uniroma3.siw.Progetto_SIW_Silph.service.FotografiaService;
import it.uniroma3.siw.Progetto_SIW_Silph.service.FotografiaValidator;
import it.uniroma3.siw.Progetto_SIW_Silph.service.FotografoService;

@Controller
public class FotografiaController {
	@Autowired 
	FotografiaService fotografiaService;
	
	@Autowired
	AlbumService albumService;
	
	@Autowired 
	FotografoService fotografoService;
	
	@Autowired
	FotografiaValidator fotografiaValidator;
	
	//TODO
	//Inserimento fotografia, dalla form, con collezioni.
	
	
	@RequestMapping(value = "/fotografia/{id}", method = RequestMethod.GET)
	public String getAlbum(@PathVariable ("id") Long id, Model model) {
		if(id!=null) {
			model.addAttribute("fotografia", this.fotografiaService.FotografiaPerId(id));
			return "fotografia.html";
		}else {
			model.addAttribute("fotografie",this.fotografiaService.tutteLeFotografie() );
			return "fotografie.html";
		}
	}
	
	@RequestMapping("/admin/addFotografia")
	public String addFotografia(Model model) {
		model.addAttribute("fotografia", new Fotografia());
		return "fotografiaForm.html";
	}


}
