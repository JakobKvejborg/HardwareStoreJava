package model;

import java.time.LocalDateTime;


	/**
	 * @author PenroseUCN
	 * 
	 * @since 10/01/2024
	 */
public interface LendableIF extends SemiLendableIF {
	
	
	public boolean decrementStock(int quantity, Location location);

}