package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.OrderContainer;
import model.Sale;

/**
 * This class represents a J-Unit test for the class <code>OrderContainer</class>.
 * 
 * @author Patrick Thor Sorenson De Siqueira
 * @version 13/12/2023
 * @since 08/12/2023
 */
public class OrderContainerTest {
	
	/**
	 * <code>setUp()</code> runs before each test method.
	 */
	@BeforeEach
	public void setUp() {
		OrderContainer.getInstance();
	}
	
	/**
	 * This test checks if <code>AddOrder</code> from the <code>OrderContainer</code> succeeds by adding new <code>Sale</code>.
	 */
	@Test
	public void addOrderTest() {
		assertTrue(OrderContainer.getInstance().addOrder(new Sale(null)));
	}
}
