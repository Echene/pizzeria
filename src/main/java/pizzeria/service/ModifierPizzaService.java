package pizzeria.service;

import java.util.InputMismatchException;

import pizzeria.exception.UpdatePizzaException;
import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC() throws UpdatePizzaException {

		try {

			System.out.println("Mise à jour d'une pizza");
			System.out.println("Veuillez choisir une pizza");
			Pizza laPizza = getPizzaDAO().findPizzaByCode(getScanner().nextLine());

			System.out.println("Veuillez saisir le nouveau code : ");
			String code = getScanner().nextLine();

			if (getPizzaDAO().findPizzaByCode(code) != null) {

				throw new UpdatePizzaException("Ce code est déjà utilisé par une autre pizza");

			} else if (code.length() < 2 || code.length() > 4) {

				throw new UpdatePizzaException("Le code rentré est de longueur incorrect");
				
			}

			System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
			String nom = getScanner().nextLine();

			if (nom.contains(" ")) {
				
				throw new UpdatePizzaException("Le nom de la pizza contient des espaces");
				
			}

			System.out.println("Veuillez saisir le nouveau prix : ");
			double prix = Double.parseDouble(getScanner().nextLine());
			
			System.out.println("Veuillez saisir le nouveau prix : ");
			CategoriePizza categorie = CategoriePizza.findByLibelle(getScanner().nextLine());

			getPizzaDAO().updatePizza(laPizza.getCode(), new Pizza(code, nom, prix, categorie));

		} catch (InputMismatchException | UpdatePizzaException e) {
			System.out.println(e.getMessage());
		}

	}

}
