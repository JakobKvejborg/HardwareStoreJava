package model;

public abstract class AbstractCopy {
	
	private String barcode;
	private UniqueStock stock;
	
	public AbstractCopy(String barcode) {
		this.barcode = barcode;
	}
	
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public UniqueStock getStock() {
		return stock;
	}

	public void setStock(UniqueStock stock) {
		this.stock = stock;
	}
	
	public int getStock(Location location) {
		int res = 0;
		//check if it has stock assigned, and if it is at the given location.
		if(getStock() != null && getStock().getLocation() == location) {
			res = 1;
		}
		return res;
	}

	public boolean decrementStock(int quanity, Location location) {
		boolean res = false;
		if (getStock(location) >= 1) {
			res = getStock().removeCopy(this);
			setStock(null);
		}
		return res;
	}
	
	//public abstract double getPrice(LocalDateTime date);

	
}
