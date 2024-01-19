package controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import model.Employee;
import model.LendableIF;
import model.Loan;
import model.Location;

public class LoanCtrl {

	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Location location;
	private Employee employee;
	private ArrayList<LendableIF> products;
	
	
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
		
		return null;
	}
	
	
	public boolean validateLoans() {
		//check that the loan is at least 1 day long
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

	public boolean setDates(LocalDateTime startDate, LocalDateTime endDate) {
		if(startDate.until(endDate, ChronoUnit.DAYS) < 1) {
			return false;
		}
		this.startDate = startDate;
		this.endDate = endDate;
		
		return true;
	}
}
