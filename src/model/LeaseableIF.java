package model;

import java.time.LocalDateTime;

public interface LeaseableIF {

	String getName();

	double getLeasePrice(LocalDateTime date);
	
	double getOriginalLeasePrice(LocalDateTime date);
	double getDiscountLease(LocalDateTime date);
	
	public int getStock(Location location);
	
	public boolean decrementStock(int quantity, Location location);
	
	String getDescription();
	
	
	
}
