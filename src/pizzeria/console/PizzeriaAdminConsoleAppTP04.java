package pizzeria.console;

import java.util.Scanner;

import pizzeria.dao.PizzaMemDao;
import pizzeria.model.Pizza;

public class PizzeriaAdminConsoleAppTP04 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		PizzaMemDao pizzaDao = new PizzaMemDao();

		Scanner scan = new Scanner(System.in);
		int choix = 0;
		String code = "";
		String nom = "";
		double prix = 0.00;
		Pizza laPizza = new Pizza();

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
				
				for (Pizza pizza: pizzaDao.findAllPizzas()) {
					System.out.println(pizza.getCode() + " --> " + pizza.getLibelle() + " ("
							+ pizza.getPrix() + " €)");
				}

			} else if (choix == 2) {

				System.out.println("Ajout d'une nouvelle pizza");

				System.out.println("Veuillez saisir le code : ");
				code = scan.nextLine();

				System.out.println("Veuillez saisir le nom (sans espace) : ");
				nom = scan.nextLine();

				System.out.println("Veuillez saisir le prix : ");
				prix = Double.parseDouble(scan.nextLine());

				pizzaDao.saveNewPizza(new Pizza(code, nom, prix));

			} else if (choix == 3) {


				System.out.println("Mise à jour d'une pizza");
				System.out.println("Veuillez choisir une pizza");
				laPizza = pizzaDao.findPizzaByCode(scan.nextLine());

				System.out.println("Veuillez saisir le nouveau code : ");
				code = scan.nextLine();

				System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
				nom = scan.nextLine();

				System.out.println("Veuillez saisir le nouveau prix : ");
				prix = Double.parseDouble(scan.nextLine());

				pizzaDao.updatePizza(laPizza + "", new Pizza(code, nom, prix));

			} else if (choix == 4) {

				System.out.println("Suppression d'une pizza");
				System.out.println("Veuillez choisir une pizza");

				pizzaDao.deletePizza(scan.nextLine());

			} else if (choix == 99) {

				System.out.println("Aurevoir :'(");

			}

			System.out.println("\n");

		} while (choix != 99);

	}

}
