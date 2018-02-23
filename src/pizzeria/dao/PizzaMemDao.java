package pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	List<Pizza> listPizzas;

	public PizzaMemDao() {

		listPizzas = new ArrayList<Pizza>();

		listPizzas.add(new Pizza(0, "PEP", "Pépéroni", 12.50));
		listPizzas.add(new Pizza(1, "MAR", "Margherita", 14.00));
		listPizzas.add(new Pizza(2, "REIN", "La Reine", 11.50));
		listPizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12.00));
		listPizzas.add(new Pizza(4, "CAN", "La cannibale", 12.50));
		listPizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00));
		listPizzas.add(new Pizza(6, "ORI", "L'orientale", 13.50));
		listPizzas.add(new Pizza(7, "IND", "L'indienne", 14.00));

	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		listPizzas.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		listPizzas.set(findPizzaByCode(codePizza).getId(), pizza);

	}

	@Override
	public void deletePizza(String codePizza) {
		listPizzas.remove(findPizzaByCode(codePizza).getId());

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for (Pizza pizza : listPizzas) {
			if (pizza.getCode() == codePizza) {
				return pizza;
			}
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		for (Pizza pizza : listPizzas) {
			if (pizza.getCode() == codePizza) {
				return true;
			}
		}
		return false;
	}

}
