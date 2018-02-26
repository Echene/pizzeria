package pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	List<Pizza> listPizzas;

	public PizzaMemDao() {

		listPizzas = new ArrayList<Pizza>();

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
		listPizzas.set(findIndexPizzaByCode(codePizza), pizza);

	}

	@Override
	public void deletePizza(String codePizza) {
		listPizzas.remove(findIndexPizzaByCode(codePizza));

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for (Pizza pizza : listPizzas) {
			if (pizza.getCode().equals(codePizza)) {

				return pizza;
			}
		}
		return null;
	}

	public int findIndexPizzaByCode(String codePizza) {
		Pizza pizza = findPizzaByCode(codePizza);
		for (int i = 0; i < listPizzas.size(); i++) {
			if(listPizzas.get(i).getCode().equals(pizza.getCode()) ) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		for (Pizza pizza : listPizzas) {
			if (pizza.getCode().equals(codePizza)) {
				return true;
			}
		}
		return false;
	}

}
