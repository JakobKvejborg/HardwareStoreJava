package model;

import java.time.LocalDateTime;


	/**
	 * @author PenroseUCN
	 * 
	 * @since 10/01/2024
	 */
public interface LendableIF {
	/**
	 * it gets the price of a product
	 * @return price in double
	 */
	double getLoanPrice(LocalDateTime date);
	/**
	 * @return The name of the Lendable.
	 */
	String getName();
}