package pizzeria.service;

import java.util.InputMismatchException;

import pizzeria.exception.UpdatePizzaException;
import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;

/** Classe de service qui permet la modification d'une pizza
 * @author Emmanuel
 *
 */
public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC() throws UpdatePizzaException {

		try {

			System.out.println("Mise � jour d'une pizza");
			System.out.println("Veuillez choisir une pizza");
			Pizza laPizza = getPizzaDAO().findPizzaByCode(getScanner().nextLine());

			System.out.println("Veuillez saisir le nouveau code : ");
			String code = getScanner().nextLine();

			// Throw une exception si le code existe d�j�
			if (getPizzaDAO().findPizzaByCode(code) != null) {

				throw new UpdatePizzaException("Ce code est d�j� utilis� par une autre pizza");

			// Throw une exception si le code est < 2 ou < 4
			} else if (code.length() < 2 || code.length() > 4) {

				throw new UpdatePizzaException("Le code rentr� est de longueur incorrect");
				
			}

			System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
			String nom = getScanner().nextLine();

			// Throw une exception si le nom de la pizza contient un espace
			if (nom.contains(" ")) {
				
				throw new UpdatePizzaException("Le nom de la pizza contient des espaces");
				
			}

			System.out.println("Veuillez saisir le nouveau prix : ");
			double prix = Double.parseDouble(getScanner().nextLine());
			
			System.out.println("Veuillez saisir le nouveau prix : ");
			CategoriePizza categorie = CategoriePizza.findByLibelle(getScanner().nextLine());

			// Mise � jour de la pizza
			getPizzaDAO().updatePizza(laPizza.getCode(), new Pizza(code, nom, prix, categorie));

		} catch (InputMismatchException | UpdatePizzaException e) {
			System.out.println(e.getMessage());
		}

	}

}
