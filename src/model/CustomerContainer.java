package model;

import java.util.ArrayList;

/**
 * This class represents a customer container which can store and search for
 * the class <code>Customer</code>.
 * 
 * @author Patrick Thor Sorenson De Siqueira, Majbritt Kjeldgaard Harsfort
 * @version 13/12/2023
 * @since 07/12/2023
 */
public class CustomerContainer {
	private ArrayList<Customer> customers;
	private static CustomerContainer instance;
	
	/**
	 * Constructor creates a list containing <code>customers</code>.
	 */
	private CustomerContainer() {
		customers = new ArrayList<>();
	}
	
	/**
	 * This method creates a instance of CustomerContainer if it does no exist (singleton).
	 * 
	 * @return instance
	 */
	public static CustomerContainer getInstance() {
		if (instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}
	
	/**
	 * This method is used to search for a customer inside the array list
	 * by using customers phone number.
	 * 
	 * @param phone phone number of customer
	 * @return object customer
	 */
	public Customer findCustomer(String phone) {
		Customer customer = null;
		for (int i = 0; i < customers.size() && customer == null; i++)
			if (customers.get(i).getPhone().equalsIgnoreCase(phone)) {
				customer = customers.get(i);
			}
		return customer;
	}
	
	/**
	 * This method adds a customer to the ArrayList.
	 * @param customer is an object from the class Customer
	 * @return <code>true</code> or <code>false</code>
	 */
	public boolean addCustomer(Customer customer) {
		boolean res = false;
		//TODO: make sure no customers have the same phone number.
		if (customer != null) {
			res = customers.add(customer);
		}
		return res;
	}
	
	public void removeCustomer(String phone) {
		Customer customer = findCustomer(phone);
		if(customer != null) {
			customers.remove(customer);
		}
	}
}
