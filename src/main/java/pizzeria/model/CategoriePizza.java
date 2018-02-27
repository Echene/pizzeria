/**
 * 
 */
package pizzeria.model;

/**
 * Classe qui repr�sente une cat�gorie de pizza
 * @author Emmanuel
 *
 */
public enum CategoriePizza {

	/** Cat�gorie de pizza avec viande */
	VIANDE("Viande"),
	POISSON("Poisson"), 
	SANS_VIANDE("SansViande");

	private String categ;

	/** Constructor
	 * @param categ
	 */
	private CategoriePizza(String categ) {
		this.categ = categ;
	}

	public String getCateg() {
		return categ;
	}
	
	
	/** Retourne une cat�gorie de pizza en fonction de son libell�
	 * @return libelle libell�
	 * @return {@link CategoriePizza}
	 */
	public static CategoriePizza findByLibelle(String libelle) {
		for(CategoriePizza categorie: values()) {
			if(categorie.getCateg().equals(libelle)) {
				return categorie;
			}
		}
		return null;
	}
}
