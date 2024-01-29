package model;

import java.time.LocalDateTime;

public interface LeaseableIF extends SemiLeaseableIF{
	
	public boolean decrementStock(int quantity, Location location);

}
