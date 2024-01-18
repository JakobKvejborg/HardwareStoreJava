package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Creates a composite product which contains multiple different and similar products,
 * like if you want a complete kitchen as a product to sell.
 * @author Julia Rafn
 * @version 14/12/2023
 * @since 14/12/2023 
 */
public class CompositeProduct implements SellableIF {
	private TemporalPriceList price;
	private TemporalPriceList discount;
	private ArrayList<CompositeLine> compositeLines;
	
	/**
	 * contains a composite products price and discount
	 * @param price		
	 * @param discount	
	 */
	public CompositeProduct(double price, double discount, LocalDateTime creationDate) {
		compositeLines = new ArrayList<>();
		this.price = new TemporalPriceList();
		this.price.addPrice(price, creationDate);
		this.discount = new TemporalPriceList();
		this.discount.addPrice(discount, creationDate);
		
	}

	public double getPrice(LocalDateTime date) {
		return price.getPrice(date) * (1 - discount.getPrice(date));
	}

	public double getDiscount(LocalDateTime date) {
		return discount.getPrice(date);
	}

	@Override
	public boolean isUnique() {
		boolean res = false;
		for(int i = 0; i < compositeLines.size() && !res; i++) {
			res = compositeLines.get(i).getProduct().isUnique();
		}
		return res;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public int getStock(Location location) {
		if(compositeLines.size() == 0) {
			//the product doesn't have anything it is composed of. Throw error?
			return 0;
		}
		int res = compositeLines.get(0).getProduct().getStock(location) / compositeLines.get(0).getQuantity();
		for(int i = 1; i < compositeLines.size(); i++) {
			//get the minimum value of the two
			res = Math.min(res, compositeLines.get(i).getProduct().getStock(location) / compositeLines.get(i).getQuantity());
		}
		return res;
	}

	
	//idk this doesn't work
	@Override
	public boolean decrementStock(int quantity, Location location) {
		if(getStock(location) < quantity) {
			//not enough stock
			return false;
		}
		//do something
		return false;
	}

	@Override
	public double getOriginalPrice(LocalDateTime date) {
		
		return price.getPrice(date);
	}


	
	
	
}
