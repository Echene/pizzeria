package pizzeria.service;

import pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC() {
		
		System.out.println("Mise à jour d'une pizza");
		System.out.println("Veuillez choisir une pizza");
		Pizza laPizza = getPizzaDAO().findPizzaByCode(getScanner().nextLine());

		System.out.println("Veuillez saisir le nouveau code : ");
		String code = getScanner().nextLine();

		System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
		String nom = getScanner().nextLine();

		System.out.println("Veuillez saisir le nouveau prix : ");
		double prix = Double.parseDouble(getScanner().nextLine());

		getPizzaDAO().updatePizza(laPizza.getCode(), new Pizza(code, nom, prix));
		
	}

}
