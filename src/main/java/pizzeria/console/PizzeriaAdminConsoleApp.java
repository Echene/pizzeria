package pizzeria.console;

import java.util.Arrays;
import java.util.Scanner;

import pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Pizza[] tabPizzas = new Pizza[8];
		tabPizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		tabPizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		tabPizzas[2] = new Pizza(2, "REIN", "La Reine", 11.50);
		tabPizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		tabPizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		tabPizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		tabPizzas[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		tabPizzas[7] = new Pizza(7, "IND", "L'indienne", 14.00);

		Scanner scan = new Scanner(System.in);
		int choix = 0;
		String code = "";
		String nom = "";
		double prix = 0.00;
		int laPizza = 0;

		do {

			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");

			System.out.println("Veuillez choisir une option");
			choix = Integer.parseInt(scan.nextLine());

			if (choix == 1) {

				System.out.println("Liste des pizzas");

				for (int i = 0; i < tabPizzas.length; i++) {

					System.out.println(tabPizzas[i].getCode() + " --> " + tabPizzas[i].getLibelle() + " ("
							+ tabPizzas[i].getPrix() + " €)");

				}

			} else if (choix == 2) {

				System.out.println("Ajout d'une nouvelle pizza");

				System.out.println("Veuillez saisir le code : ");
				code = scan.nextLine();

				System.out.println("Veuillez saisir le nom (sans espace) : ");
				nom = scan.nextLine();

				System.out.println("Veuillez saisir le prix : ");
				prix = Double.parseDouble(scan.nextLine());

				tabPizzas = Arrays.copyOf(tabPizzas, tabPizzas.length + 1);

				tabPizzas[tabPizzas.length - 1] = new Pizza(code, nom, prix);

			} else if (choix == 3) {

				System.out.println("Mise à jour d'une pizza");
				System.out.println("Veuillez choisir une pizza");
				laPizza = Integer.parseInt(scan.nextLine());

				System.out.println("Veuillez saisir le nouveau code : ");
				code = scan.nextLine();

				System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
				nom = scan.nextLine();

				System.out.println("Veuillez saisir le nouveau prix : ");
				prix = Double.parseDouble(scan.nextLine());

				tabPizzas[laPizza] = new Pizza(code, nom, prix);

			} else if (choix == 4) {

				System.out.println("Suppression d'une pizza");
				System.out.println("Veuillez choisir une pizza");
				laPizza = Integer.parseInt(scan.nextLine()) - 1;

				Pizza[] tabPizzasCopy = new Pizza[tabPizzas.length - 1];

				for (int i = 0; i < tabPizzasCopy.length; i++) {
					if (i >= laPizza) {
						tabPizzasCopy[i] = tabPizzas[i + 1];
					} else {
						tabPizzasCopy[i] = tabPizzas[i];
					}

				}

				tabPizzas = tabPizzasCopy;

			} else if (choix == 99) {

				System.out.println("Aurevoir :'(");

			}

			System.out.println("\n");

		} while (choix != 99);

	}

}
