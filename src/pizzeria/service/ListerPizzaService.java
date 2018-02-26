package pizzeria.service;

import pizzeria.model.Pizza;

public class ListerPizzaService extends MenuService {

	@Override
	public void executeUC() {

		System.out.println("Liste des pizzas");

		for (Pizza pizza : getPizzaDAO().findAllPizzas()) {

			System.out.println(pizza.getCode() + " --> " + pizza.getLibelle() + " (" + pizza.getPrix() + " €)");

		}

	}

}
