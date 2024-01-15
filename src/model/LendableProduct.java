package model;

import java.time.LocalDateTime;

/**
 * @author Jakob & Jonas
 * 
 * @version 10/01/2024
 * @since 13-12-2023
 */
public class LendableProduct extends AbstractProduct{
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
	
	public double getLendPrice(LocalDateTime date) {
		return lendPrice;
	}

	public double getLendDiscount() {
		return lendDiscount;
	}

	public double getLeasePrice(LocalDateTime date) {
		return leasePrice;
	}

	public double getLeaseDiscount() {
		return leaseDiscount;
	}

	public boolean isUnique() {
		return true;
	}
	
}
