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

	@RequestMapping(value="/album", method= RequestMethod.GET )
	public String selezioneFotografie(@RequestParam (required=false, name="fotografiScelti")Long[] valoriFotografi,
			@RequestParam (required=false, name="fotografieScelte")Long[] valoriFotografie, @Valid @ModelAttribute("album") Album album,
			Model model, BindingResult bindingResult){
		this.albumValidator.validate(album, bindingResult);
		if(!bindingResult.hasErrors()) {
			for(Long idFotografo:valoriFotografi ) {
				Fotografo fotografoAlbum= this.fotografoService.FotografoPerId(idFotografo);
				album.addFotografo(fotografoAlbum);
			}
			for(Long idFotografia:valoriFotografie) {
				Fotografia fotografiaAlbum= this.fotografiaService.FotografiaPerId(idFotografia);
				album.addFotografia(fotografiaAlbum);
			}
			this.albumService.inserisci(album);
			model.addAttribute("albums", albumService.tuttiGliAlbum());
			return "albums.html";
		}
		else {
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
	

    @RequestMapping(value ="/admin/addAlbum", method = RequestMethod.GET)
    public String inserimentoDatiadmin(Model model) {
    	model.addAttribute("album",new Album());
        model.addAttribute("fotografie", this.fotografiaService.tutteLeFotografie());
        model.addAttribute("fotografi", this.fotografoService.tuttiIFotografi());
        return "albumForm.html";
    }
	
	
	
	
	
	

}
