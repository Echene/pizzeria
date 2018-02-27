/**
 * 
 */
package pizzeria.model;

/**
 * Classe qui représente une catégorie de pizza
 * @author Emmanuel
 *
 */
public enum CategoriePizza {

	/** Catégorie de pizza avec viande */
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
	
	
	/** Retourne une catégorie de pizza en fonction de son libellé
	 * @return libelle libellé
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
