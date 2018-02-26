package pizzeria.service;

public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC() {
		
		System.out.println("Suppression d'une pizza");
		System.out.println("Veuillez choisir une pizza");				

		getPizzaDAO().deletePizza(getScanner().nextLine());
		
	}

}
