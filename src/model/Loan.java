package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * @author Majbritt Kjeldgaard Harsfort
 * @version 14/12/2023
 * @since 14/12/2023
 *
 */
public class Loan extends AbstractOrder {
	private LocalDateTime endDate;
	private LendableIF product;
	

	public Loan(int orderNo, LocalDateTime startDate, LocalDateTime endDate, LendableIF product) {
		super(orderNo, startDate);
		this.endDate = endDate;
		this.product = product;
	}
	
	/**
	 * @return returns the number of days the loan is in (rounded up)
	 */
	public int getDuration() {
		//add 1 to round up.
		//TODO handle when it is the same time both days.
		return (int) super.getDate().until(endDate, ChronoUnit.DAYS) +1;
	}

	/**
	 * @return returns the price for the entire loan
	 */
	public double getPrice() {
		return getDailyPrice() * getDuration();
	}
	
	/**
	 * @return returns the price per day for the loan
	 */
	public double getDailyPrice() {
		return product.getLoanPrice(super.getDate());
	}

	public LocalDateTime getEndDate(){
		return endDate;
	}
}