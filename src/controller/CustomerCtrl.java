package controller;

import model.AbstractProduct;
import model.Customer;
import model.CustomerContainer;

/**
 * This class represents customer controller which creates an instance of
 * customer container and sends the commands to the container.
 * @author Patrick Thor Sorenson De Siqueira, Majbritt Kjeldgaard Harsfort
 * @version 13/12/2023
 * @since 07/12/2023
 */
public class CustomerCtrl implements CustomerCtrlIF {
	private CustomerContainer customerContainer;
	
	/**
	 * Constructor creates an instance of customer container.
	 */
	public CustomerCtrl() {
		this.customerContainer = CustomerContainer.getInstance();
	}
	
	/**
	 * This method is used to call a method from customer container.
	 * 
	 * @param phone phone number of customer
	 * @return object customer
	 */
	public Customer findCustomer(String phone) {
		return customerContainer.findCustomer(phone);
	}

	/**
	 * Method to create a new customer with name etc.
	 * Then adds the new customer to the <code>ArrayList</code> in the customer container.
	 *
	 * @param name
	 * @param address
	 * @param phone
	 * @param email
	 */
	public Customer createCustomer(String name, String address, String phone, String email) {
		Customer customer = new Customer(name, address, phone, email);
		boolean success = customerContainer.addCustomer(customer);
		if(!success) {
			customer = null;
		}
		return customer;
	}
	
	public void updateCustomer(String name, String address, String phone, String email) {
		Customer customer = findCustomer(phone);
		if(customer != null) {
			customer.setName(name);
			customer.setAddress(address);
			customer.setPhone(phone);
			customer.setEmail(email);
			System.out.println("Customer information has been updated: " + customer);
		} else {
			System.out.println("Customer could not be found: " + phone);
		}
	}
}
