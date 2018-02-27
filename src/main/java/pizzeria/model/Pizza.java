package pizzeria.model;

public class Pizza {
	
	int id;
	String code;
	String libelle;
	double prix;
	CategoriePizza categorie;

	static int compteur = 1;
	
	public Pizza(String unCode, String unLibelle, double unPrix, CategoriePizza uneCategorie) {
		
		this.id = compteur++;
		
		this.code = unCode;
		this.libelle = unLibelle;
		this.prix = unPrix;
		this.categorie = uneCategorie;
	}

	public Pizza(int unId, String unCode, String unLibelle, double unPrix, CategoriePizza uneCategorie) {
		this.id = unId;
		this.code = unCode;
		this.libelle = unLibelle;
		this.prix = unPrix;
		this.categorie = uneCategorie;
	}
	
	public Pizza() {};
	
	public String toString() {
		return this.code + " " + this.libelle + " " + this.prix + " " + this.categorie;	
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

