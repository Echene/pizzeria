package pizzeria.service;

import java.util.Scanner;

import pizzeria.dao.IPizzaDao;
import pizzeria.dao.PizzaMemDao;
import pizzeria.exception.PizzaException;
import pizzeria.exception.SavePizzaException;
import pizzeria.exception.UpdatePizzaException;
import pizzeria.model.Pizza;

/**
 * @author Emmanuel
 *
 */
public abstract class MenuService {

	public abstract void executeUC() throws PizzaException;

	private static IPizzaDao pizzaDao = null;
	private Scanner scan = null;

	/** Constructeur
	 * 
	 */
	public MenuService() {
		if (pizzaDao == null) {

			pizzaDao = new PizzaMemDao();

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
