package model;

import java.time.LocalDateTime;
import model.SaleOrderLine;
import java.util.ArrayList;

/**
 * @author Jakob, Jonas, Majbritt Kjeldgaard Harsfort
 * 
 * @version 15/12/2023
 * @since 12/12/2023
 */
public class Lease extends AbstractOrder {
	private double totalPaid;
	private LocalDateTime paymentDue;
	private LeaseableIF product;
	private String state;

	public Lease(int orderNo, LocalDateTime date, double totalPaid) {
		super(orderNo, date);
		this.totalPaid = totalPaid;
		this.paymentDue = date.plusMonths(1);
		this.state = "Leased";

	}

	public double getPrice() {
		return 0;
	}
	
	public double getTotalPaid() {
		return totalPaid;
	}

	public LocalDateTime getPaymentDue() {
		return paymentDue;
	}

	public String getState() {
		return state;
	}
}
