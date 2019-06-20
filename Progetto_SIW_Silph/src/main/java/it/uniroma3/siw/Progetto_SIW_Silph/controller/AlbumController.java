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
	
	List<Long> IdfotografieAlbum;
	List<Long> IdfotografiAlbum;

	@RequestMapping(value="/album", method= RequestMethod.POST )
	public String newAlbum(@RequestParam (required=false, name="fotografiScelti")List<Long> valoriFotografi,
			@RequestParam (required=false, name="fotografieScelte")List<Long> valoriFotografie, @Valid @ModelAttribute("album") Album album,
			Model model, BindingResult bindingResult){
		//inizio stampe per la verifica su console del coretto funzionamento
		if(valoriFotografi!=null) {
				for(Long f: valoriFotografi) {
					System.out.println("Fotografo"+f);
				}
		}
				//fine stampa
		
				//inizio stampe per la verifica su console del coretto funzionamento
		if(valoriFotografie!=null) {
				for(Long f1: valoriFotografie) {
					System.out.println("Fotografia"+f1);
				}
		}
				//fine stampa
				IdfotografieAlbum=valoriFotografie;
				IdfotografiAlbum=valoriFotografi;
		this.albumValidator.validate(album, bindingResult);
		if(!bindingResult.hasErrors()) {
			
			this.albumService.inserisci(album);
			model.addAttribute("albums", albumService.tuttiGliAlbum());
			return "albums.html";
		}
		else {
			model.addAttribute("album",album);
			model.addAttribute("fotografie", this.fotografiaService.tutteLeFotografie());
	        model.addAttribute("fotografi", this.fotografoService.tuttiIFotografi());
			return "albumForm.html";
		}
	}
	
	@RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
	public String getAlbum(@PathVariable ("id") Long id, Model model) {
		if(id!=null) {
			Album a=this.albumService.AlbumPerId(id);
			if(IdfotografiAlbum!=null) {
				for(Long f: IdfotografiAlbum) {
					System.out.println("Fotografo"+f);
				}
			}
			if(IdfotografieAlbum!=null) {
				for(Long f1: IdfotografieAlbum) {
					System.out.println("Fotografia"+f1);
				}
			}

			if(IdfotografiAlbum!=null) {
				for(Long idFotografo:IdfotografiAlbum ) {
					Fotografo fotografoAlbum= this.fotografoService.FotografoPerId(idFotografo);
					a.addFotografo(fotografoAlbum);
					System.out.println(fotografoAlbum.getNome());
					System.out.println(a.getFotografi().contains(fotografoAlbum));
				}
			}
			if (IdfotografieAlbum!=null){
				for(Long idFotografia:IdfotografieAlbum) {
					Fotografia fotografiaAlbum= this.fotografiaService.FotografiaPerId(idFotografia);
					a.addFotografia(fotografiaAlbum);
					System.out.println(fotografiaAlbum.getNome());
					System.out.println(a.getFotografie().contains(fotografiaAlbum));
				}
			}
			model.addAttribute("album", a);
			return "album.html";
		}else {
			model.addAttribute("albums", this.albumService.tuttiGliAlbum());
			return "albums.html";
		}
	}

	//tutti gli album, per la home
	@RequestMapping(value="/allAlbum")
	public String allAlbum(Model model){
		model.addAttribute("albums", this.albumService.tuttiGliAlbum());
		return "albums.html";
		
	}

    @RequestMapping(value ="/admin/addAlbum", method = RequestMethod.GET)
    public String inserimentoDatiadmin(Model model) {
    	model.addAttribute("album",new Album());
        model.addAttribute("fotografie", this.fotografiaService.tutteLeFotografie());
        model.addAttribute("fotografi", this.fotografoService.tuttiIFotografi());
        return "albumForm.html";
    }
	
}