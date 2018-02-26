package pizzeria.service;

import pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC() {
		
		System.out.println("Ajout d'une nouvelle pizza");

		System.out.println("Veuillez saisir le code : ");
		String code = getScanner().nextLine();

		System.out.println("Veuillez saisir le nom (sans espace) : ");
		String nom = getScanner().nextLine();

		System.out.println("Veuillez saisir le prix : ");
		double prix = Double.parseDouble(getScanner().nextLine());

		getPizzaDAO().saveNewPizza(new Pizza(code, nom, prix));
		
	}

}
