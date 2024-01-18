package model;

import java.time.LocalDateTime;

/**
 * @author Jonas, Penrose
 * @version 15-12-2023
 * @since 12-12-2023
 */
public class UniqueProduct extends AbstractProduct {
	private String defaultWarranty;
	private TemporalPriceList price;
	private TemporalPriceList discount;
	
	public UniqueProduct(String name, String description, String barcode, double purchasePrice, double price, double discount, LocalDateTime creationDate, String defaultWarranty) {
		super(name, description, barcode, purchasePrice);
		this.defaultWarranty = defaultWarranty;
		this.price = new TemporalPriceList();
		this.price.addPrice(price, creationDate);
		this.discount = new TemporalPriceList();
		this.discount.addPrice(discount, creationDate);
	}

	public void setDefaultWarranty(String warranty) {
		this.defaultWarranty = warranty;
	}

	public double getPrice(LocalDateTime date) {
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

	public double getOriginalPrice(LocalDateTime date) {
		// TODO Auto-generated method stub
		return price.getPrice(date);
	}

	public double getDiscount(LocalDateTime date) {
		// TODO Auto-generated method stub
		return discount.getPrice(date);
	}
	

}
