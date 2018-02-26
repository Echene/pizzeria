package pizzeria.console;

import java.util.Scanner;

import pizzeria.service.AjouterPizzaService;
import pizzeria.service.ListerPizzaService;
import pizzeria.service.MenuServiceFactory;
import pizzeria.service.ModifierPizzaService;
import pizzeria.service.SupprimerPizzaService;

public class PizzeriaAdminConsoleAppTP04 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int choix = 0;

		do {

			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			System.out.println("***********************************");

			System.out.println("Veuillez choisir une option");
			choix = Integer.parseInt(scan.nextLine());
			
			MenuServiceFactory.getInstance(choix).executeUC();;


		} while (choix != 99);

	}

}
