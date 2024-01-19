package controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import model.Customer;
import model.Employee;
import model.LendableIF;
import model.Loan;
import model.Location;
import model.OrderContainer;

public class LoanCtrl {

	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Location location;
	private Employee employee;
	private ArrayList<LendableIF> products;
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LoanCtrl(Employee employee, Location location) {
		this.employee = employee;
		this.location = location;
		this.products = new ArrayList<>();
	}
	
	public void clearLoans() {
		this.startDate = null;
		this.endDate = null;
		this.products = new ArrayList<>();
	}
	
	public ArrayList<Loan> completeLoans(){
		boolean success = validateLoans();
		
		for(int i = 0; i < products.size(); i++) {
			LendableIF product = products.get(i);
			product.decrementStock(1, location);
			Loan loan = new Loan(startDate, endDate, product);
			loan.setCustomer(customer);
			loan.setEmployee(employee);
			loan.setOrderNo(OrderContainer.getInstance().generateOrderNO());
			OrderContainer.getInstance().addOrder(loan);
		
		}
		return null;
	}
	
	
	public boolean validateLoans() {
		if(employee == null || location == null || customer == null || startDate == null || endDate == null ) {
			return false;
		}
		
		//check that the loan is at least 1 day long.
		if(startDate.until(endDate, ChronoUnit.DAYS) < 1) {
			return false;
		}
		//penrose black magic, don't feel like writing it in a readable way
		//makes sure that all products in the loan are unique
		if(products.stream().distinct().count() != products.size()) {
			return false;
		}
		
		//check that all of the products are in stock
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getStock(location) <= 0) {
				return false;
			}
		}
		return true;
	}
	
	public double getLoanPrice(){
		double total = 0.0d;
		for(int i = 0; i < products.size(); i++) {
			total += products.get(i).getLoanPrice(startDate);
		}
		return total * getDuration();
	}

	private double getDuration() {
		return startDate.until(endDate, ChronoUnit.DAYS);
	}

	public boolean setDates(LocalDateTime startDate, LocalDateTime endDate) {
		if(startDate.until(endDate, ChronoUnit.DAYS) < 1) {
			return false;
		}
		this.startDate = startDate;
		this.endDate = endDate;
		
		return true;
	}
}
