package pizzeria.service;

public class MenuServiceFactory {
	
	/** M�thode permettant � l'utilisateur de naviguer dans les diff�rents services
	 * @param choix Num�ro du choix que l'utilisateur saisit
	 * @return Renvoie le service correspondant au choix. <br>
	 * Renvoie null si le choix ne corresponds � aucun service
	 */
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
