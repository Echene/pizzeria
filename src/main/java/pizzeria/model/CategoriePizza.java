/**
 * 
 */
package pizzeria.model;

/**
 * Classe qui repr�sente une cat�gorie de pizza
 * 
 * @author Emmanuel
 *
 */
public enum CategoriePizza {

	/** Cat�gorie de pizza avec viande */
	VIANDE("Viande"),

	/** Cat�gorie de pizza avec poisson */
	POISSON("Poisson"),

	/** Cat�gorie de pizza sans viande */
	SANS_VIANDE("SansViande");

	private String categ;

	/**
	 * Constructor
	 * 
	 * @param categ Cat�gorie de la pizza
	 */
	private CategoriePizza(String categ) {
		this.categ = categ;
	}

	public String getCateg() {
		return categ;
	}

	/**
	 * Retourne une cat�gorie de pizza en fonction de son libell�
	 * 
	 * @return libelle libell� de la cat�gorie
	 * @return {@link CategoriePizza}
	 */
	public static CategoriePizza findByLibelle(String libelle) {
		for (CategoriePizza categorie : values()) {
			if (categorie.getCateg().equals(libelle)) {
				return categorie;
			}
		}
		return null;
	}
}
