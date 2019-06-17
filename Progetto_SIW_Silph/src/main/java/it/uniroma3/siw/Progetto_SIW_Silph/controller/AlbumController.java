package it.uniroma3.siw.Progetto_SIW_Silph.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.Progetto_SIW_Silph.model.Album;
import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografia;
import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografo;
import it.uniroma3.siw.Progetto_SIW_Silph.service.AlbumService;
import it.uniroma3.siw.Progetto_SIW_Silph.service.AlbumValidator;
import it.uniroma3.siw.Progetto_SIW_Silph.service.FotografiaService;
import it.uniroma3.siw.Progetto_SIW_Silph.service.FotografoService;

@Controller
public class AlbumController {

	@Autowired
	AlbumService albumService;
	@Autowired
	FotografoService fotografoService;
	@Autowired
	FotografiaService fotografiaService;
	
	@Autowired
	AlbumValidator albumValidator;

	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String newAlbum(@Valid @ModelAttribute("album") Album album,
			Model model, BindingResult bindingResult, @RequestParam("fotografie") Long[] fotografieSelezionate,
			@RequestParam("fotografi") Long[] fotografiSelezionati ){
		this.albumValidator.validate(album, bindingResult);
		if(!bindingResult.hasErrors()) {
			for(Long Idfoto:fotografieSelezionate) {
				Fotografia fotografia= fotografiaService.FotografiaPerId(Idfoto);
				album.addFotografia(fotografia);
			}
			for(Long Idfotografo:fotografiSelezionati) {
				Fotografo fotografo= fotografoService.FotografoPerId(Idfotografo);
				album.addFotografo(fotografo);
			}
			this.albumService.inserisci(album);
			model.addAttribute("albums", this.albumService.tuttiGliAlbum());
			return "albums.html";
		}else {
			return "albumForm.html";
		}
	}
	
	@RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
	public String getAlbum(@PathVariable ("id") Long id, Model model) {
		if(id!=null) {
			model.addAttribute("album", this.albumService.AlbumPerId(id));
			return "album.html";
		}else {
			model.addAttribute("albums", this.albumService.tuttiGliAlbum());
			return "albums.html";
		}
	}
	
	//per passare alla form
	@RequestMapping("/addAlbum")
	public String addAlbum(Model model) {
		model.addAttribute("album", new Album());
		model.addAttribute("fotografie", fotografiaService.tutteLeFotografie());
		model.addAttribute("fotografi", fotografoService.tuttiIFotografi());
		return "albumForm.html";
	}
	
	
	//ci manda alla pagina dei creatori
	@RequestMapping("/roma3")
	public String roma3(Model model) {
		return "roma3studenti.html";
	}
}
