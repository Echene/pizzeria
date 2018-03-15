package pizzeria.service;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import pizzeria.dao.IPizzaDao;
import pizzeria.model.Pizza;

/**
 * @author Emmanuel
 *
 */
public class ListerPizzaServiceTest {

	/**
	 * Test method for {@link pizzeria.service.ListerPizzaService#executeUC()}.
	 */
	@Test
	public void testExecuteUC() {

		ArrayList<Pizza> pizzas = new ArrayList<>();
		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
		ListerPizzaService service = new ListerPizzaService();

		pizzas.add(null);

		Mockito.when(mockedDao.findAllPizzas()).thenReturn(null);

		service.executeUC(mockedDao);
		
		
	}

}
