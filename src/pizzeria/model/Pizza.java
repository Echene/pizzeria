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
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}

