package it.uniroma3.siw.Progetto_SIW_Silph.controller;

import java.util.List;

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
	
	List<Long> IdfotografieFotografo;
	List<Long> IdAlbumFotografo;
	
	@RequestMapping(value="/fotografo", method= RequestMethod.POST )
	public String newFotografo(@RequestParam (required=false, value="albumsScelti") List<Long> valoriAlbums,
			@RequestParam (required=false, name="fotografieScelte") List<Long> valoriFotografie,
			@Valid @ModelAttribute("fotografo") Fotografo fotografo,
			Model model, BindingResult bindingResult){
		this.IdAlbumFotografo=valoriAlbums;
		this.IdfotografieFotografo=valoriFotografie;
		this.fotografoValidator.validate(fotografo, bindingResult);
		if(!bindingResult.hasErrors()) {
		
			this.fotografoService.inserisci(fotografo);
			model.addAttribute("fotografi", fotografoService.tuttiIFotografi());
			return "fotografi.html";
		}
		else {
			model.addAttribute("fotografo",fotografo);
			model.addAttribute("albums", this.albumService.tuttiGliAlbum());
			model.addAttribute("fotografie", this.fotografiaService.tutteLeFotografie());
			return "fotografoForm.html";
		}
	}
	
	@RequestMapping(value = "/fotografo/{id}", method = RequestMethod.GET)
	public String getFotografo(@PathVariable ("id") Long id, Model model) {
		if(id!=null) {
			Fotografo f= this.fotografoService.FotografoPerId(id);
			if(IdAlbumFotografo!=null) {
				for(Long idAlbum:IdAlbumFotografo ) {
					Album albumFotografo= this.albumService.AlbumPerId(idAlbum);
					f.addAlbum(albumFotografo);
				}
				}
				if (IdfotografieFotografo!=null){
				for(Long idFotografia:IdfotografieFotografo) {
					Fotografia fotografiaAlbum= this.fotografiaService.FotografiaPerId(idFotografia);
					f.addFotografia(fotografiaAlbum);
				} 
				}
			model.addAttribute("fotografo", f);
			return "fotografo.html";
		}else {
			model.addAttribute("fotografi", this.fotografoService.tuttiIFotografi());
			return "fotografi.html";
		}
	}
	
	//tutti i fotografi, per la home
	@RequestMapping(value="/allFotografi")
	public String allFotografi(Model model){
		model.addAttribute("fotografi", this.fotografoService.tuttiIFotografi());
		return "fotografi.html";
		
	}
	
	@RequestMapping(value="/admin/addFotografo", method = RequestMethod.GET)
	public String addFotografo(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		model.addAttribute("albums", this.albumService.tuttiGliAlbum());
		model.addAttribute("fotografie", this.fotografiaService.tutteLeFotografie());
		return "fotografoForm.html";
	}

}
