/**
 * 
 */
package pizzeria.dao;

import static pizzeria.bdd.ConnectionBDD.getConnection;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pizzeria.exception.DeletePizzaException;
import pizzeria.exception.SavePizzaException;
import pizzeria.exception.UpdatePizzaException;
import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;

/**
 * @author Emmanuel
 *
 */
public class PizzaBaseDao implements IPizzaDao {

	private static String PIZZA_ID = "ID";
	private static String PIZZA_CODE = "CODE";
	private static String PIZZA_LIBELLE = "LIBELLE";
	private static String PIZZA_PRIX = "PRIX";
	private static String CATEGORIE_LIBELLE = "LIBELLE";

	protected static Connection connect = getConnection();

	public void PizzaDAO() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pizzeria.dao.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas() {

		List<Pizza> pizzas = new ArrayList<Pizza>();

		try {

			String query = "SELECT pizza.ID, pizza.CODE, pizza.LIBELLE, pizza.PRIX, categorie.LIBELLE "
						 + "FROM pizza, categorie " 
						 + "WHERE pizza.CATEGORIE = categorie.ID;";

			PreparedStatement pstmt = connect.prepareStatement(query);

			ResultSet result = pstmt.executeQuery();

			while (result.next()) {

				Pizza pizza = new Pizza(result.getInt(PIZZA_ID), 
						result.getString(PIZZA_CODE),
						result.getString(PIZZA_LIBELLE), 
						result.getDouble(PIZZA_PRIX),
						new CategoriePizza(result.getString(CATEGORIE_LIBELLE)));

				pizzas.add(pizza);
			}

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pizzas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pizzeria.dao.IPizzaDao#saveNewPizza(pizzeria.model.Pizza)
	 */
	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {

		String query = "INSERT INTO pizza(CODE, LIBELLE, PRIX, CATEGORIE) VALUES (?, ?, ?, (SELECT ID FROM categorie WHERE LIBELLE = ?))";

		try {

			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, pizza.getCode());
			pstmt.setString(2, pizza.getLibelle());
			pstmt.setDouble(3, pizza.getPrix());
			pstmt.setString(4, pizza.getCategorie().getLibelle());

			pstmt.executeUpdate();

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pizzeria.dao.IPizzaDao#updatePizza(java.lang.String,
	 * pizzeria.model.Pizza)
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		String query = "UPDATE pizza SET CODE = ?,"
					+ " LIBELLE = ?,"
					+ " PRIX = ?,"
					+ " CATEGORIE = (SELECT ID FROM categorie WHERE LIBELLE = ?)"
					+ " WHERE CODE = ?" ;

		try {

			PreparedStatement pstmt = connect.prepareStatement(query);
			pstmt.setString(1, pizza.getCode());
			pstmt.setString(2, pizza.getLibelle());
			pstmt.setDouble(3, pizza.getPrix());
			pstmt.setString(4, pizza.getCategorie().getLibelle());
			pstmt.setString(5, codePizza);

			int result = pstmt.executeUpdate();
			
			if(result == 0) {
				throw new UpdatePizzaException("Aucune pizza n'a été modifiée");
			}

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pizzeria.dao.IPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {

		String query = "DELETE FROM pizza WHERE pizza.CODE ='" + codePizza + "'";

		try {

			int result = connect.createStatement().executeUpdate(query);
			
			if(result == 0) {
				throw new DeletePizzaException("Code pizza inexistant");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pizzeria.dao.IPizzaDao#findIndexPizzaByCode(java.lang.String)
	 */
	@Override
	public int findIndexPizzaByCode(String codePizza) {

		try {

			String query = "SELECT pizza.ID "
						 + "FROM pizza "
						 + "WHERE pizza.CODE = ?;";

			PreparedStatement pstmt = connect.prepareStatement(query);			
			
			pstmt.setString(1, codePizza);

			ResultSet result = pstmt.executeQuery();
			
			pstmt.close();

			if (result.first()) {		

				return result.getInt(PIZZA_ID);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pizzeria.dao.IPizzaDao#findPizzaByCode(java.lang.String)
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		
		try {

			String query = "SELECT pizza.ID, pizza.CODE, pizza.LIBELLE, pizza.PRIX, categorie.LIBELLE "
						 + "FROM pizza, categorie "
						 + "WHERE pizza.CATEGORIE = categorie.ID "
						 + "AND pizza.CODE = ?;";

			PreparedStatement pstmt = connect.prepareStatement(query);			
			
			pstmt.setString(1, codePizza);

			ResultSet result = pstmt.executeQuery();

			if (result.first()) {

				Pizza pizza = new Pizza(
						result.getInt(PIZZA_ID), 
						result.getString(PIZZA_CODE),
						result.getString(PIZZA_LIBELLE), 
						result.getDouble(PIZZA_PRIX),
						new CategoriePizza(result.getString(CATEGORIE_LIBELLE)));
				
				pstmt.close();

				return pizza;
			}

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pizzeria.dao.IPizzaDao#pizzaExists(java.lang.String)
	 */
	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
