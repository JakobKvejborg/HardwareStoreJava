package unitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Customer;
import model.CustomerGroup;

/**
 * This class represents a test of Customer
 * @author Majbritt Kjeldgaard Harsfort
 * @version 11/12/2023
 */

public class CustomerTest {
	private Customer customer;
	private CustomerGroup groupWithDiscount;
	private CustomerGroup groupWithoutDiscount;
	
	/**
	 * <code>setUp()</code> runs before each test method.
	 */
	@BeforeEach
	public void setUp() {
		customer = new Customer("John Doe","Gade 1","1234567890","john@example.dk");		
		
	groupWithDiscount = new CustomerGroup("default group", "private", 20);
	
	
	groupWithoutDiscount = new CustomerGroup("default group number two", "public", 10);
	
	}
	
	@Test
	public void testGetMaxDiscountWithDiscount() {
		customer.setCustomerGroup(groupWithDiscount);
		double maxDiscount = customer.getMaxDiscount();
		Assertions.assertEquals(15,maxDiscount);	
	}
	
	@Test
	public void testGetMaxDiscountWithoutDiscount() {
		customer.setCustomerGroup(groupWithoutDiscount);
		double maxDiscount = customer.getMaxDiscount()	;
		Assertions.assertEquals(0,maxDiscount);	
		}
}