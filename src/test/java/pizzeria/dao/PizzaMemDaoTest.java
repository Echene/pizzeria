/**
 * 
 */
package pizzeria.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;

/**
 * @author Emmanuel
 *
 */
public class PizzaMemDaoTest {

	

	@Test
	public void testPizzaExists() {
		
		PizzaMemDao dao = new PizzaMemDao();

		assertTrue(dao.pizzaExists("PEP"));
		assertFalse(dao.pizzaExists("FALSE"));

	}
	
	@Test
	public void testFindAllPizzas() {
		
		PizzaMemDao dao = new PizzaMemDao();
		
		assertEquals(8, dao.findAllPizzas().size());
		
	}

	@Test
	public void testFindPizzaByCode() {
		
		PizzaMemDao dao = new PizzaMemDao();

		assertNotNull("Aucune pizza trouvée", dao.findPizzaByCode("PEP"));

		assertNull(dao.findPizzaByCode("null"));

		assertNull(dao.findPizzaByCode(null));
	}
	
	@Test
	public void testSaveNewPizza() {
		
		PizzaMemDao dao = new PizzaMemDao();
		int size = dao.findAllPizzas().size();
		
		dao.saveNewPizza(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		dao.saveNewPizza(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		
		assertEquals(size + 2, dao.findAllPizzas().size());
		
		dao.saveNewPizza(null);
		
		assertEquals(size + 2, dao.findAllPizzas().size());		
	}
	
	@Test
	public void testUpdatePizza() {
		
		PizzaMemDao dao = new PizzaMemDao();
		
		String nom = dao.findPizzaByCode("PEP").getLibelle();
		
		dao.updatePizza("PEP", null);
		assertNotNull(dao.findPizzaByCode("PEP"));
		
		assertEquals(nom, dao.findPizzaByCode("PEP").getLibelle());
		dao.updatePizza("PEP", new Pizza("PEP", "TEST", 12, CategoriePizza.SANS_VIANDE));
		assertNotEquals(nom, dao.findPizzaByCode("PEP").getLibelle());

		
	}

	@Test
	public void testFindIndexPizzaByCode() {
		
		PizzaMemDao dao = new PizzaMemDao();

		assertEquals(0, dao.findIndexPizzaByCode("PEP"));
		
		assertEquals(-1, dao.findIndexPizzaByCode("test"));
		
	}
	
	@Test
	public void testDeletePizza() {
		
		PizzaMemDao dao = new PizzaMemDao();
		int size = dao.findAllPizzas().size();
		
		dao.deletePizza("PEP");		
		assertEquals(size - 1, dao.listPizzas.size());
		
		dao.deletePizza("TEST");		
		assertEquals(size - 1 , dao.listPizzas.size());
	}

}
