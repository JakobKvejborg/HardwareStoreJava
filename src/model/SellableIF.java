package model;

import java.time.LocalDateTime;

/**
 * This interface should be implemented for anything that can be sold.
 * 
 * @author Penrose
 * @version 07/12/2023
 */
public interface SellableIF {
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
	
	public boolean decrementStock(int quantity, Location location);
	
	
}
