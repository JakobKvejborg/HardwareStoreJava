package model;

import java.time.LocalDateTime;

/**
 * @author Jakob & Jonas
 * 
 * @version 10/01/2024
 * @since 13-12-2023
 */
public class LendableCopy extends AbstractCopy implements LendableIF, LeaseableIF{
	private LendableProduct product;

	public LendableCopy(String barcode, LendableProduct product) {
		super(barcode);
		this.product = product;
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
	
	
}
