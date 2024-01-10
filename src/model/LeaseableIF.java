package model;

public interface LeaseableIF {

	String getName();

	double getLeasePrice();
	
	public int getStock(Location location);
	
	public boolean decrementStock(int quantity, Location location);
	
}
