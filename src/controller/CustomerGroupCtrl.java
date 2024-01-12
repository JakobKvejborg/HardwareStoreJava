package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Customer;
import model.CustomerGroup;
import model.TemporalPriceList;

/**
 * @author Jonas
 * @version 12-01-2024
 * @since 12-01-2024
 */
public class CustomerGroupCtrl {
	private ArrayList<CustomerGroup> customerGroups;
	
	private CustomerGroupCtrl() {
		customerGroups = new ArrayList<>();
	}
	
	public CustomerGroup findCustomerGroup(String type) {
		CustomerGroup customerGroup = null;
		for (int i = 0; i < customerGroups.size() && customerGroup == null; i++)
			if (customerGroups.get(i).getType().equalsIgnoreCase(type)) {
				customerGroup = customerGroups.get(i);
			}
		return customerGroup;
	}
	
	public boolean addCustomerGroup(CustomerGroup customerGroup) {
		boolean res = false;
		//TODO: make sure no customerGroups have the same type.
		if (customerGroup != null) {
			res = customerGroups.add(customerGroup);
		}
		return res;
	}
	
	public void removeCustomerGroup(String type) {
		CustomerGroup customerGroup = findCustomerGroup(type);
		if(customerGroup != null) {
			customerGroups.remove(customerGroup);
		}
	}
	
	public CustomerGroup createCustomerGroup(String name, String type, double maxDiscount, LocalDateTime date) {
		CustomerGroup customerGroup = new CustomerGroup(name, type, maxDiscount, null);
		boolean success = addCustomerGroup(customerGroup);
		if(!success) {
			customerGroup = null;
		}
		return customerGroup;
	}
	
	public void updateCustomerGroup(String name, String type, TemporalPriceList maxDiscount) {
		CustomerGroup customerGroup = findCustomerGroup(type);
		if(customerGroup != null) {
			customerGroup.setName(name);
			customerGroup.setType(type);
			customerGroup.setMaxDiscount(maxDiscount);
			System.out.println("Customer information has been updated: " + customerGroup);
		} else {
			System.out.println("Customer could not be found: " + type);
		}
	}
}
