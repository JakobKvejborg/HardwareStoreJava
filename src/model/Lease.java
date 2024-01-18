package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


/**
 * @author Jakob, Jonas, Majbritt Kjeldgaard Harsfort
 * 
 * @version 15/12/2023
 * @since 12/12/2023
 */
public class Lease extends AbstractOrder {
	private double totalPaid;
	private LocalDateTime paymentDueDate;
	private LeaseableIF product;
	private String state;

	public Lease(LocalDateTime date, double totalPaid) {
		super(date);
		this.totalPaid = totalPaid;
		this.paymentDueDate = date.plusMonths(1);
		this.state = "Leased";
	}
	
	public Lease(LocalDateTime date) {
		super(date);
	}

	public double getTotalPaid() {
		return totalPaid;
	}

	public double getPaymentDue(LocalDateTime date) {
		int timeSinceStart = (int) super.getDate().until(date, ChronoUnit.MONTHS);
		if(timeSinceStart < 0) {
			throw new RuntimeException("Cannot see a date earlier than the creation date");
		}
		//round up sorta
		timeSinceStart++;
		//TODO: make work with changing prices over time
		return product.getLeasePrice(super.getDate()) * timeSinceStart - totalPaid;
	}
	
	public LocalDateTime getPaymentDueDate() {
		return paymentDueDate;
	}

	public String getState() {
		return state;
	}

	public void setProduct(LeaseableIF product) {
		this.product = product;
	}
}
