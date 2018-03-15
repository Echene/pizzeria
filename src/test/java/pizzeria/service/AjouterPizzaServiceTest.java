/**
 * 
 */
package pizzeria.service;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import pizzeria.dao.PizzaMemDao;
import pizzeria.exception.SavePizzaException;
import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

/**
 * @author Emmanuel
 *
 */
public class AjouterPizzaServiceTest {
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	/**
	 * Test method for {@link pizzeria.service.AjouterPizzaService#executeUC()}.
	 */
	@Test
	public void testExecuteUC() {
		
		systemInMock.provideLines("TEST", "unePizzaTest", 12.00 + "", "Viande");
		
		PizzaMemDao dao = (PizzaMemDao) MenuService.getPizzaDAO();
		
		int size = dao.findAllPizzas().size();
		
		AjouterPizzaService service = new AjouterPizzaService();
		
		try {
			service.executeUC();
			assertEquals(size + 1, dao.findAllPizzas().size());
		} catch (SavePizzaException e) {
			e.printStackTrace();
		}
		
		Pizza pizza = dao.findPizzaByCode("TEST");
		
		assertNotNull(pizza);
		assertEquals("unePizzaTest", pizza.getLibelle());
		assert(pizza.getPrix() == 12.00);
		assertEquals(CategoriePizza.VIANDE, pizza.getCategorie());
		
		
	}

}
