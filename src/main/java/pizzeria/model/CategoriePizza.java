/**
 * 
 */
package pizzeria.model;

/**
 * Classe qui représente une catégorie de pizza
 * 
 * @author Emmanuel
 *
 */
public class CategoriePizza {
	
	String libelle;

	/** Constructor
	 * @param libelle
	 */
	public CategoriePizza(String libelle) {
		this.libelle = libelle;
	}

	/** Getter
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/** Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
