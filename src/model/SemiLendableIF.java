package model;

import java.time.LocalDateTime;

/**
 * @author Penrose
 * 
 * @version 29/01/2024
 * @since 29/01/2024
 */
//TODO: give this a better name
public interface SemiLendableIF {
	/**
	 * it gets the price of a product
	 * @return price in double
	 */
	double getLoanPrice(LocalDateTime date);
	/**
	 * @return The name of the Lendable.
	 */
	String getName();
	
	public int getStock(Location location);

	double getLoanDiscount(LocalDateTime date);
	double getOriginalLoanPrice(LocalDateTime date);
}
