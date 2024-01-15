package model;

import java.time.LocalDateTime;

/**
 * @author Jakob & Jonas
 * 
 * @version 10/01/2024
 * @since 13-12-2023
 */
public class LendableCopy extends AbstractCopy implements LendableIF, LeaseableIF{
	private String barcode;
	private LendableProduct product;

	public LendableCopy(String barcode, LendableProduct product) {
		super(barcode);
		this.product = product;
	}

	public String getBarcode() {
		return barcode;
	}

	@Override
	public String getName() {
		return product.getName();
	}

	@Override
	public double getLoanPrice(LocalDateTime date) {
		return product.getLendPrice(date);
	}

	@Override
	public double getLeasePrice(LocalDateTime date) {
		return product.getLeasePrice(date);

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
