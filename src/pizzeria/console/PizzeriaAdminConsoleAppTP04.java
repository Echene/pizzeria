package pizzeria.console;

import java.util.Scanner;

import pizzeria.service.AjouterPizzaService;
import pizzeria.service.ListerPizzaService;
import pizzeria.service.ModifierPizzaService;
import pizzeria.service.SupprimerPizzaService;

public class PizzeriaAdminConsoleAppTP04 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int choix = 0;

		do {

			new ListerPizzaService().afficherMenu();

			System.out.println("Veuillez choisir une option");
			choix = Integer.parseInt(scan.nextLine());

			if (choix == 1) {

				new ListerPizzaService().executeUC();

			} else if (choix == 2) {

				new AjouterPizzaService().executeUC();

			} else if (choix == 3) {

				new ModifierPizzaService().executeUC();

			} else if (choix == 4) {

				new SupprimerPizzaService().executeUC();

			} else if (choix == 99) {

				System.out.println("Aurevoir :'(");

			}

			System.out.println("\n");

		} while (choix != 99);

	}

}
