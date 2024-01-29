package model;

import java.time.LocalDateTime;



/**
 * @author Penrose
 * 
 * @version 29/01/2024
 * @since 29/01/2024
 */
//TODO: give this a better name
public interface SemiSellableIF {
	/**
	 * it gets the price of a product
	 * @return price in double
	 */
	double getSalePrice(LocalDateTime date);
	
	double getOriginalSalePrice(LocalDateTime date);
	double getSaleDiscount(LocalDateTime date);
	/**
	 * @return true if the Sellable is only allowed to sell in quantities of 1
	 */
	boolean isUnique();
	/**
	 * @return The name of the Sellable.
	 */
	String getName();

	String getDescription();
	
	public int getStock(Location location);
}
