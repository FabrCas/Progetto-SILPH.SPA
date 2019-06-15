package it.uniroma3.siw.Progetto_SIW_Silph;

import java.util.List;
import java.util.Map;


import it.uniroma3.siw.Progetto_SIW_Silph.factory.FactoryGalleria;
import it.uniroma3.siw.Progetto_SIW_Silph.model.Album;
import it.uniroma3.siw.Progetto_SIW_Silph.model.Fotografo;
import it.uniroma3.siw.Progetto_SIW_Silph.model.RichiestaFoto;

public class Galleria {
	private FactoryGalleria factoryGalleria;
	private static Galleria istanza;
	private List<RichiestaFoto> richiesteFoto;
	private Map<Long,Fotografo> fotografi;
	private Map<Long, Album> albums;
	
	//private per rendere l'oggetto singleton
	private Galleria() {
		this.factoryGalleria= FactoryGalleria.getIstance();
		this.factoryGalleria.creaGalleria(this);
	}
	
	public static Galleria getIstance() {
		if(istanza==null) {
			istanza= new Galleria();
		}
		return istanza;
	}
	
	public List<RichiestaFoto> getRichiesteFoto() {
		return richiesteFoto;
	}

	public void setRichiesteFoto(List<RichiestaFoto> richiesteFoto) {
		this.richiesteFoto = richiesteFoto;
	}

	public Map<Long, Fotografo> getFotografi() {
		return fotografi;
	}

	public void setFotografi(Map<Long, Fotografo> fotografi) {
		this.fotografi = fotografi;
	}

	public Map<Long, Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Map<Long, Album> albums) {
		this.albums = albums;
	}


}
