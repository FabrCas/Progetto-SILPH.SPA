package it.uniroma3.siw.Progetto_SIW_Silph.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

	@RequestMapping(value="/InserimentoFotografieAlbum", method= RequestMethod.POST )
	public String selezioneFotografie(@Valid @ModelAttribute("album") Album album,
			Model model, BindingResult bindingResult){
		this.albumValidator.validate(album, bindingResult);
		if(!bindingResult.hasErrors()) {
			model.addAttribute("album",album);
			model.addAttribute("fotografie", fotografiaService.tutteLeFotografie());
			return "album_inserimentoFoto.html";
		}
		else {
			return "albumForm.html";
		}
	}
	
	@RequestMapping(value="/InserimentoFotografiAlbum", method=RequestMethod.POST)
	public String selezioneFotografi(@Valid @ModelAttribute("album") Album album,
			Model model,@Valid @RequestParam("fotografie") Long[] fotografieSelezionate) {
		for(Long Idfoto:fotografieSelezionate) {
			Fotografia fotografia= fotografiaService.FotografiaPerId(Idfoto);
			album.addFotografia(fotografia);
		}
		model.addAttribute("album",album);
		model.addAttribute("fotografi", fotografoService.tuttiIFotografi());
		return "album_inserimentoFotografi.html";
	}

	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String newAlbum(@Valid @ModelAttribute("album") Album album,
			Model model, @RequestParam("fotografi") Long[] fotografiSelezionati ){
		for(Long Idfotografo:fotografiSelezionati) {
			Fotografo fotografo= fotografoService.FotografoPerId(Idfotografo);
			album.addFotografo(fotografo);
		}
		albumService.inserisci(album);
		model.addAttribute("albums",albumService.tuttiGliAlbum());
		return "albums.html";
		
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
		
		//aggiunti
		 UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        String role = details.getAuthorities().iterator().next().getAuthority();    // get first authority
	        model.addAttribute("username", details.getUsername());
	        model.addAttribute("role", role);
		return "albumForm.html";
	}
	
	

}
