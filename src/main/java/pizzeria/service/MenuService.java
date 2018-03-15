package pizzeria.service;
import java.util.Scanner;

import pizzeria.dao.IPizzaDao;
import pizzeria.dao.PizzaBaseDao;
import pizzeria.dao.PizzaMemDao;
import pizzeria.exception.PizzaException;

/**
 * @author Emmanuel
 *
 */
public abstract class MenuService {

	public abstract void executeUC() throws PizzaException;

	private static IPizzaDao pizzaDao = null;
	private static Scanner scan = null;

	/** Constructeur
	 * 
	 */
	public MenuService() {
		if (pizzaDao == null) {

			pizzaDao = new PizzaBaseDao();

		}
	}

	protected static Scanner getScanner() {
		if (scan == null) {
			scan = new Scanner(System.in);
		}
		return scan;
	}

	protected void setScanner(Scanner scan) {
		MenuService.scan = scan;
	}

	protected static IPizzaDao getPizzaDAO() {
		if (pizzaDao == null) {
			pizzaDao = new PizzaBaseDao();			
		}
		return pizzaDao;
	}

}
