package pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	List<Pizza> listPizzas;

	public PizzaMemDao() {

		listPizzas = new ArrayList<Pizza>();

		listPizzas.add(new Pizza(0, "PEP", "Pépéroni", 12.50, new CategoriePizza("VIANDE")));
		listPizzas.add(new Pizza(1, "MAR", "Margherita", 14.00, new CategoriePizza("VIANDE")));
		listPizzas.add(new Pizza(2, "REIN", "La Reine", 11.50, new CategoriePizza("VIANDE")));
		listPizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12.00, new CategoriePizza("VIANDE")));
		listPizzas.add(new Pizza(4, "CAN", "La cannibale", 12.50, new CategoriePizza("VIANDE")));
		listPizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00, new CategoriePizza("VIANDE")));
		listPizzas.add(new Pizza(6, "ORI", "L'orientale", 13.50, new CategoriePizza("VIANDE")));
		listPizzas.add(new Pizza(7, "IND", "L'indienne", 14.00, new CategoriePizza("VIANDE")));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		if (pizza != null) {
			listPizzas.add(pizza);
		}	
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		int index = findIndexPizzaByCode(codePizza);
		
		if (index != -1 && pizza != null) {
			listPizzas.set(index, pizza);
		}
		
	}

	@Override
	public void deletePizza(String codePizza) {
		
		int index = findIndexPizzaByCode(codePizza);
		
		if (index != -1) {
			listPizzas.remove(index);
		}
		
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
		
		// Si la pizza n'a pas �t� trouv�e
		if(pizza == null) {
			return -1;
		}

		for (int i = 0; i < listPizzas.size(); i++) {
			if (listPizzas.get(i).getCode().equals(pizza.getCode())) {
				return i;
			}
		}
		
		// Si aucun index corresponds
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
