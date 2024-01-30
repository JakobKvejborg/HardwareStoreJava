package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Jonas, Penrose
 * @version 15-12-2023
 * @since 12-12-2023
 */
public class UniqueProduct extends AbstractProduct implements SemiSellableIF {
	private String defaultWarranty;
	private ArrayList<UniqueStock> stocks;	
	private TemporalPriceList price;
	private TemporalPriceList discount;
	
	public UniqueProduct(String name, String description, String barcode, double purchasePrice, double price, double discount, LocalDateTime creationDate, String defaultWarranty) {
		super(name, description, barcode, purchasePrice);
		this.defaultWarranty = defaultWarranty;
		this.price = new TemporalPriceList();
		this.price.addPrice(price, creationDate);
		this.discount = new TemporalPriceList();
		this.discount.addPrice(discount, creationDate);
		this.stocks = new ArrayList<UniqueStock>();
	}

	public void setDefaultWarranty(String warranty) {
		this.defaultWarranty = warranty;
	}

	@Override
	public double getSalePrice(LocalDateTime date) {
		return price.getPrice(date) * (1 - discount.getPrice(date));
	}

	public void addPrice(double price, LocalDateTime date) {
		this.price.addPrice(price, date);
	}

	public void addDiscount(double discount, LocalDateTime date) {
		this.discount.addPrice(discount, date);
	}
	
	public String getDefaultWarranty() {
		return defaultWarranty;
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
	public double getOriginalSalePrice(LocalDateTime date) {
		return price.getPrice(date);
	}

	@Override
	public double getSaleDiscount(LocalDateTime date) {
		return discount.getPrice(date);
	}
	

}
