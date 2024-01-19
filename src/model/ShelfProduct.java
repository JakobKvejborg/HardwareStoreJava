package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * is a not unique product
 * @author Jonas
 * 
 *@version 11/12/2023
 *@since 07/12/2023
 */
public class ShelfProduct extends AbstractProduct implements SellableIF {
	
	private static double purchasePrice;
	private ArrayList<ShelfStock> stocks;	
	//TODO: Make price not break old sales when it is changed.
	private TemporalPriceList price;
	//TODO: Make discount not break old sales when it is changed.
	private TemporalPriceList discount;
	
	public ShelfProduct(String name, String descripton, String barcode, double purchasePrice, double price, double discount, LocalDateTime creationDate) {
		super(name, descripton, barcode, purchasePrice);
		this.price = new TemporalPriceList();
		this.price.addPrice(price, creationDate);
		this.discount = new TemporalPriceList();
		this.discount.addPrice(discount, creationDate);
		stocks = new ArrayList<>();
	}
	
	public ShelfProduct(String name, String description, String barcode, double purchasePrice) {
		super(name, description, barcode, purchasePrice);
	}
	
	public int getQuantity(Location location) {
		int res = 0;
		for(int i = 0; i < stocks.size(); i++) {
			if(stocks.get(i).getLocation().equals(location)) {
				res += stocks.get(i).getQuantity();
			}
		}
		return res;
	}
	
	public int getStock(Location location) {
		int res = 0;
		for(int i = 0; i < stocks.size(); i++) {
			if(stocks.get(i).getLocation() == location) {
				res += stocks.get(i).getQuantity();
			}
		}
		return res;
	}
	
	/**
	 * makes it so the class can't be unique
	 */
	@Override
	public boolean isUnique() {
		return false;
	}
	
	
	/**
	 * gets tthe price at a specific date
	 * @param date
	 */
	@Override
	public double getSalePrice(LocalDateTime date) {
		return price.getPrice(date) * (1 - discount.getPrice(date));
	}

	/**
	 * Adds a stock to the product. Cannot add the same stock twice.
	 * @param stock
	 * @return if the stock was successfully added
	 */
	public boolean addStock(ShelfStock stock) {
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

	/**
	 * decrements the stock at a given location
	 * 
	 * @return returns false if there isn't enough stock at a location.
	 */
	@Override
	public boolean decrementStock(int quantity, Location location) {
		boolean res = false;
		boolean found = false;
		for(int i = 0; i < stocks.size() && !found; i++) {
			if(stocks.get(i).getLocation() == location) {
				if( stocks.get(i).getQuantity() >= quantity) {
					stocks.get(i).decreaseQuantity(quantity);
					res = true;
					found = true;
				}
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
