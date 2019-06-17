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

import it.uniroma3.siw.Progetto_SIW_Silph.model.Album;
import it.uniroma3.siw.Progetto_SIW_Silph.service.AlbumService;
import it.uniroma3.siw.Progetto_SIW_Silph.service.AlbumValidator;

@Controller
public class AlbumController {

	@Autowired
	AlbumService albumService;
	@Autowired
	AlbumValidator albumValidator;

	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String newAlbum(@Valid @ModelAttribute("album") Album album,
			Model model, BindingResult bindingResult) {
		
		this.albumValidator.validate(album, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.albumService.inserisci(album);
			model.addAttribute("albums", this.albumService.tuttiGliAlbum());
			return "album.html";
		}else {
			return "albums.html";
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
		return "albumForm.html";
	}
}
