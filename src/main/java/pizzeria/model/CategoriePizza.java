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
public enum CategoriePizza {

	/** Catégorie de pizza avec viande */
	VIANDE("Viande"),

	/** Catégorie de pizza avec poisson */
	POISSON("Poisson"),

	/** Catégorie de pizza sans viande */
	SANS_VIANDE("SansViande");

	private String categ;

	/**
	 * Constructor
	 * 
	 * @param categ Catégorie de la pizza
	 */
	private CategoriePizza(String categ) {
		this.categ = categ;
	}

	public String getCateg() {
		return categ;
	}

	/**
	 * Retourne une catégorie de pizza en fonction de son libellé
	 * 
	 * @return libelle libellé de la catégorie
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
