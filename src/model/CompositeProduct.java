package model;

import java.time.LocalDateTime;

/**
 * Creates a composite product which contains multiple different and similar products,
 * like if you want a complete kitchen as a product to sell.
 * @author Julia Rafn
 * @version 14/12/2023
 * @since 14/12/2023 
 */
public class CompositeProduct {
	private double price;
	private double discount;
	
	public CompositeProduct(double price, double discount) {
		this.price = price;
		this.discount = discount;
	}

	public double getPrice(LocalDateTime date) {
		return price;
	}

	public double getDiscount() {
		return discount;
	}
	
	
	
}
