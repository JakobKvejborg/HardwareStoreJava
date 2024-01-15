package unitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.SaleOrderLine;
import model.Sale;
import model.ShelfProduct;

/**
 * This class represents a J-Unit test for the class <code>Sale</class>.
 * 
 * @author Patrick Thor Sorenson De Siqueira
 * @version 11/12/2023
 * @since 13/12/2023
 */
public class SaleTest {
	private Sale sale;
	private SaleOrderLine saleOrderLineTest;
	
	/**
	 * <code>setUp()</code> runs before each test method.
	 */
	@BeforeEach
	public void setUp() {
		sale = new Sale(LocalDateTime.of(2023, 1, 1, 1, 1));
		saleOrderLineTest = new SaleOrderLine(new ShelfProduct("Oakwood planks", "Plank space", "087543", 9.99, 19.99, 10, LocalDateTime.of(2023, 1, 1, 1, 1)), 1);
		sale.addSaleOrderLine(saleOrderLineTest);
	}
	
	/**
	 * This test multiplies Quantity with Product Price and then compares it with output of <code>sale.getPrice()</code> to make sure they Equal the same.
	 */
	@Test
	public void GetPriceTest() {
		double expectedPrice = saleOrderLineTest.getQuantity() * saleOrderLineTest.getProduct().getPrice(LocalDateTime.of(2023, 1, 1, 1, 1));
		double actualPrice = sale.getPrice();
		assertEquals(expectedPrice, actualPrice);
	}
}
