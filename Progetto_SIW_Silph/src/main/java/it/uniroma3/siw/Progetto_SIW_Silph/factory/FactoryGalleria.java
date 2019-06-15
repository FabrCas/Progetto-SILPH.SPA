package it.uniroma3.siw.Progetto_SIW_Silph.factory;


public class FactoryGalleria {
	private static FactoryGalleria istanza;
	
	public void creaGalleria() {
		//TODO
		//udjdhf
	}
	
	public static FactoryGalleria getIstance() {
		if(istanza==null) {
			istanza= new FactoryGalleria();
		}
		return istanza;
	}

	
}
