package model;

/**
 * This interface should be implemented for anything that can be sold.
 * 
 * @author Penrose
 * @version 07/12/2023
 * @since 29/01/2024
 */
public interface SellableIF extends SemiSellableIF {
	
	public boolean decrementStock(int quantity, Location location);
}
