package pizzeria.service;

import pizzeria.exception.SavePizzaException;
import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;

/** Classe de service qui permet l'ajout d'une pizza dans la liste
 * @author Emmanuel
 *
 */
public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC() throws SavePizzaException {
		
		try {
			
			System.out.println("Ajout d'une nouvelle pizza");

			System.out.println("Veuillez saisir le code : ");
			String code = getScanner().nextLine();
			
			if (getPizzaDAO().findPizzaByCode(code) != null) {
				throw new SavePizzaException("Ce code est déjà utilisé par une autre pizza");
			}

			System.out.println("Veuillez saisir le nom (sans espace) : ");
			String nom = getScanner().nextLine();

			System.out.println("Veuillez saisir le prix : ");
			double prix = Double.parseDouble(getScanner().nextLine());
			
			System.out.println("Veuillez saisir la catégorie (VIANDE/SANS_VIANDE/POISSON) : ");
			CategoriePizza categorie = new CategoriePizza(getScanner().nextLine()) ;

			getPizzaDAO().saveNewPizza(new Pizza(code, nom, prix, categorie));
						
		} catch (SavePizzaException e) {
			e.printStackTrace();
		}
		

		
	}

}
