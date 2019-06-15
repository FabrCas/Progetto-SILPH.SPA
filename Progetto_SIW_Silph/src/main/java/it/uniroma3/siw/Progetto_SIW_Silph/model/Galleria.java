package it.uniroma3.siw.Progetto_SIW_Silph.model;

public class Galleria {
	private static Galleria istanza;
	
	private Galleria() {}
	
	public static Galleria getIstance() {
		if(istanza==null) {
			istanza= new Galleria();
		}
		return istanza;
	}
	

}
