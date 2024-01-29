package model;

import java.time.LocalDateTime;

/**
 * @author Penrose
 * 
 * @version 29/01/2024
 * @since 29/01/2024
 */
//TODO: give this a better name
public interface SemiLeaseableIF {
	
	String getName();

	double getLeasePrice(LocalDateTime date);
	
	double getOriginalLeasePrice(LocalDateTime date);
	double getLeaseDiscount(LocalDateTime date);
	
	public int getStock(Location location);
	
	
	String getDescription();
}
