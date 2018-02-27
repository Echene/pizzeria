package pizzeria.model;

import utils.ToString;

/**
 * Classe de gestion de Pizza
 * @author Emmanuel
 */
public class Pizza {
	
	int id;
	
	@ToString(before="- ", after=" --> ", uppercase=true)
	String code;
	
	@ToString(before=" ", after=" ")
	String libelle;
	
	@ToString(before="( ", after=" €) ")
	double prix;
	
	
	CategoriePizza categorie;

	static int compteur = 1;
	
	/** Constructor
	 * @param unCode Le code de la pizza
	 * @param unLibelle Le libelle de la pizza
	 * @param unPrix Le prix de la pizza
	 * @param uneCategorie La categorie de la pizza
	 */
	public Pizza(String unCode, String unLibelle, double unPrix, CategoriePizza uneCategorie) {
		
		this.id = compteur++;
		
		this.code = unCode;
		this.libelle = unLibelle;
		this.prix = unPrix;
		this.categorie = uneCategorie;
	}

	/** Constructor
	 * @param unId L'ID de la pizza
	 * @param unCode Le code de la pizza
	 * @param unLibelle Le libelle de la pizza
	 * @param unPrix Le prix de la pizza
	 * @param uneCategorie La categorie de la pizza
	 */
	public Pizza(int unId, String unCode, String unLibelle, double unPrix, CategoriePizza uneCategorie) {
		this.id = unId;
		this.code = unCode;
		this.libelle = unLibelle;
		this.prix = unPrix;
		this.categorie = uneCategorie;
	}
	
	/** Constructor
	 * 
	 */
	public Pizza() {};
	
	public String toString() {
		return this.code + " " + this.libelle + " " + this.prix + " " + this.categorie;	
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Getter
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/** Getter
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/** Getter
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/** Getter
	 * @return the categorie
	 */
	public CategoriePizza getCategorie() {
		return categorie;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Setter
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/** Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/** Setter
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/** Setter
	 * @param categorie the categorie to set
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
	
}

