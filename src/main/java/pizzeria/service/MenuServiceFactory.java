package pizzeria.service;

import pizzeria.exception.PizzaException;

public class MenuServiceFactory {

	/**
	 * Méthode permettant à l'utilisateur de naviguer dans les différents
	 * services
	 * 
	 * @param choix
	 *            Numéro du choix que l'utilisateur saisit
	 * @return Renvoie le service correspondant au choix. <br>
	 *         Renvoie null si le choix ne corresponds � aucun service
	 */
	public static MenuService getInstance(int choix) throws PizzaException {

		if (choix == 1) {

			return new ListerPizzaService();

		} else if (choix == 2) {

			return new AjouterPizzaService();

		} else if (choix == 3) {

			return new ModifierPizzaService();

		} else if (choix == 4) {

			return new SupprimerPizzaService();

		} else if (choix == 5) {

			return new RemplirPizzaService();

		} else if (choix == 99) {

			System.out.println("Aurevoir :'(");

		} else {

			throw new PizzaException("Choix incorrect");

		}

		return null;

	}

}
