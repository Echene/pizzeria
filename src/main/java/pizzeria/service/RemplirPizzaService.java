/**
 * 
 */
package pizzeria.service;

import java.util.List;

import pizzeria.dao.PizzaBaseDao;
import pizzeria.dao.PizzaMemDao;
import pizzeria.exception.PizzaException;
import pizzeria.model.Pizza;

/**
 * @author Emmanuel
 *
 */
public class RemplirPizzaService extends MenuService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see pizzeria.service.MenuService#executeUC()
	 */
	@Override
	public void executeUC() throws PizzaException {

		PizzaBaseDao baseDao = new PizzaBaseDao();
		PizzaMemDao memDao = new PizzaMemDao();

		List<Pizza> pizzas = memDao.findAllPizzas();

		for (Pizza p : pizzas) {
			if (baseDao.findPizzaByCode(p.getCode()) == null) {

				System.out.println("Ajout de la pizza " + p.getLibelle());
				baseDao.saveNewPizza(p);
			}
		}

	}

}
