package pizzeria.service;

import pizzeria.exception.DeletePizzaException;

/** Classe de service qui permet la suppression d'une pizza
 * @author Emmanuel
 *
 */
public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC() {
		
		System.out.println("Suppression d'une pizza");
		System.out.println("Veuillez choisir une pizza");				

		try {
			
			getPizzaDAO().deletePizza(getScanner().nextLine());
			
		} catch (DeletePizzaException e) {
			e.printStackTrace();
		}		
		
	}

}
