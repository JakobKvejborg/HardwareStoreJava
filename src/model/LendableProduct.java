package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
	private ArrayList<UniqueStock> stocks;
	private UniqueStock stock;
	
	public LendableProduct(String name, String descripton, String barcode, double purchasePrice, double lendPrice, double lendDiscount, double leasePrice, double leaseDiscount) {
		super(name, descripton, barcode, purchasePrice);
		this.lendPrice = lendPrice;
		this.lendDiscount = lendDiscount;
		this.leasePrice = leasePrice;
		this.leaseDiscount = leaseDiscount;
		this.stocks = new ArrayList<>();
	}

	public double getLeasePrice(LocalDateTime date) {
		return leasePrice * (1 - leaseDiscount);
	}

	public boolean isUnique() {
		return true;
	}

	/**
	 * Adds a stock to the product. Cannot add the same stock twice.
	 * @param stock
	 * @return if the stock was successfully added
	 */
	public boolean addStock(UniqueStock stock) {
		boolean res = true;
		boolean found = false;
		for(int i = 0; i < stocks.size() && !found; i++) {
			if(stocks.get(i) == stock) {
				found = true;
			}
		}
		if(!found) {
			stocks.add(stock);
			res = true;
		}
		return res;
	}
	
	@Override
	public int getStock(Location location) {
		int res = 0;
		for(int i = 0; i < stocks.size(); i++) {
			if(stocks.get(i).getLocation().equals(location)) {
				res += stocks.get(i).getQuantity();
			}
		}
		return res;
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
