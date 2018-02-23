package pizzeria.model;

public class Pizza {
	
	int id;
	String code;
	String libelle;
	double prix;
	
	static int compteur = 1;
	
	public Pizza(String unCode, String unLibelle, double unPrix) {
		
		this.id = compteur++;
		
		this.code = unCode;
		this.libelle = unLibelle;
		this.prix = unPrix;
	}

	public Pizza(int unId, String unCode, String unLibelle, double unPrix) {
		this.id = unId;
		this.code = unCode;
		this.libelle = unLibelle;
		this.prix = unPrix;
	}
	
}

