package model;

import java.time.LocalDateTime;

/**
 * The <code>AbstractOrder</code> class represents an abstract order entity.
 * It contains common attributes and methods for orders.
 * All the different lending or sale types inherit from <code>AbstractOrder</code>.
 * 
 * @author Penrose
 * @version 15/12/2023
 * @since 07/12/2023
 */
public abstract class AbstractOrder {
	private static int lastOrderNo = 0;
	private int orderNo;
	private LocalDateTime date; 
	private Customer customer;
	private Employee employee;
	
	 /**
     * This method constructs an <code>AbstractOrder</code> object with the provided order number and date.
     *
     * @param orderNo The order number associated with this order.
     * @param date    The date and time when the order was made.
     */
	public AbstractOrder(int orderNo, LocalDateTime date) {
		this.orderNo = ++lastOrderNo;
		this.date = date;
	}
	
	/**
     * This method sets the customer associated with this order.
     * @param customer The <code>Customer</code> object linked to this order.
     */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * This method gets <code>customer</code>.
	 * @return a <code>string</code> representing a customer.
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * This method gets <code>date</code>.
	 * @return a <code>LocalDateTime</code> representing a date.
	 */
	public LocalDateTime getDate() {
		return date;
	}
	
	/**
     * Sets the employee attached to this order.
     * @param employee The <code>Employee</code> object handling this order.
     */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getOrderNo() {
		return orderNo;
	}
}
