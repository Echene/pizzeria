package pizzeria.service;

import java.util.Scanner;

import pizzeria.dao.IPizzaDao;
import pizzeria.dao.PizzaMemDao;
import pizzeria.model.Pizza;

public abstract class MenuService {

	public abstract void executeUC();

	private static IPizzaDao pizzaDao = null;
	private Scanner scan = null;

	public MenuService() {
		if (pizzaDao == null) {

			pizzaDao = new PizzaMemDao();

			pizzaDao.saveNewPizza(new Pizza(0, "PEP", "Pépéroni", 12.50));
			pizzaDao.saveNewPizza(new Pizza(1, "MAR", "Margherita", 14.00));
			pizzaDao.saveNewPizza(new Pizza(2, "REIN", "La Reine", 11.50));
			pizzaDao.saveNewPizza(new Pizza(3, "FRO", "La 4 fromages", 12.00));
			pizzaDao.saveNewPizza(new Pizza(4, "CAN", "La cannibale", 12.50));
			pizzaDao.saveNewPizza(new Pizza(5, "SAV", "La savoyarde", 13.00));
			pizzaDao.saveNewPizza(new Pizza(6, "ORI", "L'orientale", 13.50));
			pizzaDao.saveNewPizza(new Pizza(7, "IND", "L'indienne", 14.00));
		}
	}

	protected Scanner getScanner() {
		if (scan == null) {
			scan = new Scanner(System.in);
		}
		return scan;
	}

	protected void setScanner(Scanner scan) {
		this.scan = scan;
	}
	
	protected IPizzaDao getPizzaDAO() {
		return pizzaDao;
	}

}
