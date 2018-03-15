/**
 * 
 */
package pizzeria.service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import pizzeria.dao.IPizzaDao;
import pizzeria.exception.UpdatePizzaException;
import pizzeria.model.Pizza;

/**
 * @author Emmanuel
 *
 */
public class ModifierPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testExecuteUC() {

		ArrayList<Pizza> pizzas = new ArrayList<>();
		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
		ModifierPizzaService service = new ModifierPizzaService();

		pizzas.add(null);

		systemInMock.provideLines("PEP", "TEST", "nouvellePizza", 12.00 + "", "Viande");

		Mockito.when(mockedDao.findAllPizzas()).thenReturn(pizzas);

		try {
			service.executeUC();
		} catch (UpdatePizzaException e) {
			e.printStackTrace();
		}

	}

}
