package model;

import java.time.LocalDateTime;

/**
 * @author Jakob & Jonas
 * 
 * @version 10/01/2024
 * @since 13-12-2023
 */
public class LendableProduct extends AbstractProduct implements SemiLendableIF, SemiLeaseableIF{
	//TODO: Add temporal Patterns
	private double lendPrice;
	private double lendDiscount;
	private double leasePrice;
	private double leaseDiscount;
	
	public LendableProduct(String name, String descripton, String barcode, double purchasePrice, double lendPrice, double lendDiscount, double leasePrice, double leaseDiscount) {
		super(name, descripton, barcode, purchasePrice);
		this.lendPrice = lendPrice;
		this.lendDiscount = lendDiscount;
		this.leasePrice = leasePrice;
		this.leaseDiscount = leaseDiscount;
	}

	public double getLeasePrice(LocalDateTime date) {
		return leasePrice * (1 - leaseDiscount);
	}

	public boolean isUnique() {
		return true;
	}

	@Override
	public int getStock(Location location) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLoanPrice(LocalDateTime date) {
		return lendPrice * (1 - lendDiscount);
	}

	@Override
	public double getLoanDiscount(LocalDateTime now) {
		return lendDiscount;

	}

	@Override
	public double getOriginalLeasePrice(LocalDateTime date) {
		// TODO Auto-generated method stub
		return leasePrice;
	}

	@Override
	public double getLeaseDiscount(LocalDateTime date) {
		return leaseDiscount;
	}

	@Override
	public double getOriginalLoanPrice(LocalDateTime now) {
		return lendPrice;
	}
}
