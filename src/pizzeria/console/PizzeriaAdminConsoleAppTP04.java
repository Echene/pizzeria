package pizzeria.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import pizzeria.model.Pizza;

public class PizzeriaAdminConsoleAppTP04 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		List<Pizza> listPizzas = new ArrayList<Pizza>();

		listPizzas.add(new Pizza(0, "PEP", "Pépéroni", 12.50));
		listPizzas.add(new Pizza(1, "MAR", "Margherita", 14.00));
		listPizzas.add(new Pizza(2, "REIN", "La Reine", 11.50));
		listPizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12.00));
		listPizzas.add(new Pizza(4, "CAN", "La cannibale", 12.50));
		listPizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00));
		listPizzas.add(new Pizza(6, "ORI", "L'orientale", 13.50));
		listPizzas.add(new Pizza(7, "IND", "L'indienne", 14.00));

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

				for (int i = 0; i < listPizzas.size(); i++) {

					System.out.println(listPizzas.get(i).getCode() + " --> " + listPizzas.get(i).getLibelle() + " ("
							+ listPizzas.get(i).getPrix() + " €)");

				}

			} else if (choix == 2) {

				System.out.println("Ajout d'une nouvelle pizza");

				System.out.println("Veuillez saisir le code : ");
				code = scan.nextLine();

				System.out.println("Veuillez saisir le nom (sans espace) : ");
				nom = scan.nextLine();

				System.out.println("Veuillez saisir le prix : ");
				prix = Double.parseDouble(scan.nextLine());

				listPizzas.add(new Pizza(code, nom, prix));

			} else if (choix == 3) {

				System.out.println("Mise à jour d'une pizza");
				System.out.println("Veuillez choisir une pizza");
				laPizza = Integer.parseInt(scan.nextLine()) - 1;

				System.out.println("Veuillez saisir le nouveau code : ");
				code = scan.nextLine();

				System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
				nom = scan.nextLine();

				System.out.println("Veuillez saisir le nouveau prix : ");
				prix = Double.parseDouble(scan.nextLine());

				listPizzas.set(laPizza, new Pizza(code, nom, prix));

			} else if (choix == 4) {

				System.out.println("Suppression d'une pizza");
				System.out.println("Veuillez choisir une pizza");

				listPizzas.remove((Integer.parseInt(scan.nextLine()) - 1));

			} else if (choix == 99) {

				System.out.println("Aurevoir :'(");

			}

			System.out.println("\n");

		} while (choix != 99);

	}

}
