package pizzeria.dao;
import java.util.List;

import pizzeria.exception.DeletePizzaException;
import pizzeria.exception.SavePizzaException;
import pizzeria.exception.UpdatePizzaException;
import pizzeria.model.Pizza;


public interface IPizzaDao {
	List<Pizza> findAllPizzas();

	void saveNewPizza(Pizza pizza) throws SavePizzaException;

	void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;

	void deletePizza(String codePizza) throws DeletePizzaException;

	int findIndexPizzaByCode(String codePizza);
	
	Pizza findPizzaByCode(String codePizza);

	boolean pizzaExists(String codePizza);
}
