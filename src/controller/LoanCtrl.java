package controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import model.Employee;
import model.LendableIF;
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
	
	
	public boolean setDates(LocalDateTime startDate, LocalDateTime endDate) {
		if(startDate.until(endDate, ChronoUnit.DAYS) < 1) {
			return false;
		}
		this.startDate = startDate;
		this.endDate = endDate;
		
		return true;
	}
}
