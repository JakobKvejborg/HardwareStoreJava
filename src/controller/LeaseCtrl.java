package controller;

import model.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakob, Jonas, Majbritt Kjeldgaard Harsfort, Penrose
 * 
 * @version 10/01/2024
 * @since 13/12/2023
 */
public class LeaseCtrl /*implements LeaseCtrlIF*/ {
	private OrderContainer orderContainer;
	private ProductCtrl productCtrl;
	private LocalDateTime date;
	private ArrayList<LeaseableIF> products;
	private Location location;
	private Customer customer;
	

	private Employee employee;
	private Lease lease;
	private CustomerCtrl customerCtrl;

	public LeaseCtrl(Employee employee, Location location) {
		this.employee = employee;
		this.location = location;
		this.date = LocalDateTime.now();
		this.orderContainer = OrderContainer.getInstance();
		this.productCtrl = new ProductCtrl(employee, location);
		this.customerCtrl = new CustomerCtrl();
		this.products = new ArrayList<>();
	}

	public Customer setCustomer(String phone) {
		Customer customer = customerCtrl.findCustomer(phone);
		lease.setCustomer(customer);
		return customer;
	}
	
	public Customer setCustomer(Customer customer) {
		lease.setCustomer(customer);
		return customer;
	}
	
	public void removeProduct(int index) {
		products.remove(index);
	}
	
	public LeaseableIF addProduct(String barcode) {
		LeaseableIF product = productCtrl.findLeaseable(barcode);
		//TODO make sure the copy has not yet been added.
		if(product != null) {
			products.add(product);
		}
		return product;
	}
	
	public Lease makeLease() {
		lease = new Lease(LocalDateTime.now());
		return lease;
	}

	
	public void clearLeases() {
		date = null;
		products = new ArrayList<>();
		customer = null;
	}
	
	
	public boolean validateLeases() {
		//check if there is minimum 1 product
		boolean res = products.size() > 0;
		
		//check if any of the products are out of stock.
		for(int i = 0; i < products.size() && res; i++) {
			res = products.get(i).getStock(location) >= 1;
			
		}
		//check the thing for duplicates. Ask Penrose what this black magic is.
		//Was too lazy to do it in a more readable way
		if(products.stream().distinct().count() != products.size()) {
			res = false;
		}
		
		//TODO validate the date
		if(customer == null) {
			res = false;
		}
		return res;
	}
	
	public ArrayList<Lease> completeLeases(double payment) {
		boolean res = validateLeases();
		OrderContainer orderContainer = OrderContainer.getInstance();
		ArrayList<Lease> completedLeases = new ArrayList<>();
		//loop over all the products, create a new lease for each
		for(int i = 0; i < products.size(); i++) {
			//TODO add payment
			Lease lease = new Lease(date, 0);
			lease.setProduct(products.get(i));
			lease.setCustomer(customer);
			lease.setEmployee(employee);
			lease.setOrderNo(orderContainer.generateOrderNO());
			boolean success = products.get(i).decrementStock(1, location);
			if(success) {
				orderContainer.addOrder(lease);
				completedLeases.add(lease);
			}
		}
		clearLeases();
		return completedLeases;
	}

	public ArrayList<LeaseableIF> getProducts() {
		return products;
	}

	public AbstractOrder findOrder(int orderNO) {
		return orderContainer.findOrder(orderNO);
	}

	public Lease createOrder(int orderNO, LocalDateTime date) {
		Lease order = new Lease(date);
		boolean success = orderContainer.addOrder(order);
		if (!success) {
			order = null;
		}
		return order;
	}

	public void updateOrder(int orderNO, LocalDateTime date) {
		AbstractOrder order = findOrder(orderNO);
		if (order != null) {
			order.setOrderNo(orderNO);
			order.setCustomer(null);
			order.setEmployee(employee);
			System.out.println("Order has been updated: " + order);
		} else {
			System.out.println("Order could not be found: " + orderNO);
		}
	}
	
	public ArrayList<LeaseableIF> getLease() {
		return products;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public double getLeasePrice() {
		return 0.0d;
	}
	
}
