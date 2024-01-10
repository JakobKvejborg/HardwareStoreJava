  package model;

import java.time.LocalDateTime;

/**
 * @author Jonas, penrose
 * @version 12-12-2023
 * @since 12-12-2023
 */
public class UniqueCopy extends AbstractCopy implements SellableIF{
	private String warrenty;
	private UniqueProduct product;
	
	public UniqueCopy(String barcode,UniqueProduct product) {
		super(barcode);
		this.product = product;
		this.warrenty = product.getDefaultWarranty();
		
	}

	public void setWarranty(String warranty) {
		this.warrenty = warranty;
	}
	

	public boolean isUnique() {
		return true;
	}

	@Override
	public double getPrice(LocalDateTime date) {
		return product.getPrice(date);
	}

	@Override
	public String getName() {
		return product.getName();
	}

	@Override
	public int getStock(Location location) {
		int res = 0;
		//check if it has stock assigned, and if it is at the given location.
		if(getStock() != null && getStock().getLocation() == location) {
			res = 1;
		}
		return res;
	}

	@Override
	public boolean decrementStock(int quanity, Location location) {
		boolean res = false;
		if (getStock(location) >= 1) {
			res = getStock().removeCopy(this);
			setStock(null);
		}
		return res;
	}
	
}
