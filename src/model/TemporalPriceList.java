package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * makes a list of prices and what time they got updated
 * @author Julia Rafn & Penrose
 * @version 12/12/2023
 * @since 12/12/2023
 */

public class TemporalPriceList {
	private ArrayList<TemporalPrice> prices;

	
	
	public TemporalPriceList() {
		this.prices = new ArrayList<>();
	}

	public ArrayList<TemporalPrice> getPrices() {
		return prices;
	}
	/**
	 * gets a price 
	 * @param date
	 * @return the price 
	 */
	public double getPrice(LocalDateTime date) {
		double res = 0.0d;
		boolean found = false;
		//a backwards loop
		for(int i = prices.size()-1; i >= 0 && !found; i--) {
			//check whether the date is before or after the date being looked up
			if(prices.get(i).getDate().compareTo(date)<=0) {
				res = prices.get(i).getPrice();
				found = true;
			}
		}
		//TODO: throw an error when no price is found.
		if(found = false) {
			throw new RuntimeException("there is no price before the date of " + prices.get(0));
		}
		return res;
	}
	
	/**
	 * add price to list with a date
	 * @param price
	 * @param date
	 */
	public void addPrice(double price, LocalDateTime date) {
		TemporalPrice temporalPrice = new TemporalPrice(date, price);
		prices.add(temporalPrice);
		//TODO sort
	}
}
