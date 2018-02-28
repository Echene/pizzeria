package pizzeria.service;

import pizzeria.exception.DeletePizzaException;

/**
 * Classe de service qui permet la suppression d'une pizza
 * 
 * @author Emmanuel
 *
 */
public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC() throws DeletePizzaException {

		System.out.println("Suppression d'une pizza");
		System.out.println("Veuillez choisir une pizza");

		try {

			String codePizza = getScanner().nextLine();

			if (getPizzaDAO().findPizzaByCode(codePizza) == null) {
				throw new DeletePizzaException("Code pizza inexistant");
			}

			getPizzaDAO().deletePizza(codePizza);

		} catch (DeletePizzaException e) {
			e.printStackTrace();
		}

	}

}
