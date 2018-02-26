package pizzeria.service;

public class MenuServiceFactory {
	
	public static MenuService getInstance(int choix) {
		
		if (choix == 1) {

			return new ListerPizzaService();

		} else if (choix == 2) {

			return new AjouterPizzaService();

		} else if (choix == 3) {

			return new ModifierPizzaService();

		} else if (choix == 4) {

			return new SupprimerPizzaService();

		} else if (choix == 99) {

			System.out.println("Aurevoir :'(");

		}
		
		return null;
		
	}

}
