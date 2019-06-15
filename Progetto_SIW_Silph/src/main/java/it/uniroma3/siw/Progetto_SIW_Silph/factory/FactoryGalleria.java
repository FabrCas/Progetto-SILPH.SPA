package it.uniroma3.siw.Progetto_SIW_Silph.factory;

import it.uniroma3.siw.Progetto_SIW_Silph.Galleria;

public class FactoryGalleria {
	private static FactoryGalleria istanza;
	public void creaGalleria(Galleria galleria) {
		//TODO
	}
	
	public static FactoryGalleria getIstance() {
		if(istanza==null) {
			istanza= new FactoryGalleria();
		}
		return istanza;
	}

	
}
