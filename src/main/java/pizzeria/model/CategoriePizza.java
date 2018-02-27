/**
 * 
 */
package pizzeria.model;

/**
 * @author Emmanuel
 *
 */
public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("SansViande");

	private String categ;

	private CategoriePizza(String categ) {
		this.categ = categ;
	}

	public String getCateg() {
		return categ;
	}
	
	public static CategoriePizza findByLibelle(String libelle) {
		for(CategoriePizza categorie: values()) {
			if(categorie.getCateg().equals(libelle)) {
				return categorie;
			}
		}
		return null;
	}
}
