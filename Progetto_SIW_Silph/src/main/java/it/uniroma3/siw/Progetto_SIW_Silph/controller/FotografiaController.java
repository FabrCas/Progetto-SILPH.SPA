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

	@RequestMapping(value="/fotografia", method= RequestMethod.POST )
	public String newFotografia(@RequestParam (required=false, name="fotografoScelto")Long valoreFotografo,
			@RequestParam (required=false, name="albumScelto")Long valoreAlbum,
			@Valid @ModelAttribute("fotografia") Fotografia fotografia,
			Model model, BindingResult bindingResult){
		this.fotografiaValidator.validate(fotografia, bindingResult);
		if(!bindingResult.hasErrors()) {
			if(valoreFotografo!=null) {
				Fotografo fotografoFotografia= this.fotografoService.FotografoPerId(valoreFotografo);
				fotografia.setFotografo(fotografoFotografia);
			}
			if (valoreAlbum!=null){

				Album albumFotografia= this.albumService.AlbumPerId(valoreAlbum);
				fotografia.setAlbum(albumFotografia);
			}
			this.fotografiaService.inserisci(fotografia);
			model.addAttribute("fotografie", fotografiaService.tutteLeFotografie());
			return "fotografie.html";
		}
		else {
			model.addAttribute("fotografia", fotografia);
			model.addAttribute("fotografi", fotografoService.tuttiIFotografi());
			model.addAttribute("albums", albumService.tuttiGliAlbum());
			return "fotografiaForm.html";
		}
	}


	@RequestMapping(value = "fotografia/{id}", method = RequestMethod.GET)
	public String getFotografia(@PathVariable ("id") Long id, Model model) {
		if(id!=null) {
			model.addAttribute("fotografia", this.fotografiaService.FotografiaPerId(id));
			return "fotografia.html";
		}else {
			model.addAttribute("fotografie",this.fotografiaService.tutteLeFotografie() );
			return "fotografie.html";
		}
	}

	@RequestMapping(value="/gallery")
	public String gallery(Model model) {
		model.addAttribute("fotografie", fotografiaService.tutteLeFotografie());
		return "gallery.html";
	}

	@RequestMapping(value="/admin/addFotografia", method= RequestMethod.GET)
	public String addFotografia(Model model) {
		model.addAttribute("fotografia", new Fotografia());
		model.addAttribute("fotografi", fotografoService.tuttiIFotografi());
		model.addAttribute("albums", albumService.tuttiGliAlbum());
		return "fotografiaForm.html";
	}
}
