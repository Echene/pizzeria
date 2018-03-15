package pizzeria.service;

import java.util.List;

import pizzeria.model.Pizza;

/** Classe de service qui affiche la liste des pizzas
 * @author Emmanuel
 *
 */
public class ListerPizzaService extends MenuService {

	@Override
	public void executeUC() {

		System.out.println("Liste des pizzas");
		
		List<Pizza> pizzas = getPizzaDAO().findAllPizzas();
		
		System.out.println(); 
		
		if(pizzas != null) {
			
			for (Pizza pizza : getPizzaDAO().findAllPizzas()) {

				System.out.println(pizza.toString()); 

			}
			
		} else {
			
			System.out.println("Liste Null"); 
			
		}

		System.out.println(); 

	}

}
