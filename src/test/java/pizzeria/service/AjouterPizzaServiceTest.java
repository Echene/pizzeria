/**
 * 
 */
package pizzeria.service;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
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
		
		systemInMock.provideLines("TEST");
		systemInMock.provideLines("unePizzaTest");
		systemInMock.provideLines(12.00 + "");
		systemInMock.provideLines("Viande");
	}

}
