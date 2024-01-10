package controller;

import model.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Jakob, Jonas, Majbritt Kjeldgaard Harsfort, Penrose
 * 
 * @version 10/01/2024
 * @since 13/12/2023
 */
public class LeaseCtrl {
	private OrderContainer orderContainer;
	private ProductCtrl productCtrl;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private List<LeaseableIF> products;
	private Location location;

	public LeaseCtrl(Location location) {
		orderContainer = OrderContainer.getInstance();
		this.location = location;
	}

	public LeaseableIF addProduct(String barcode) {
		LeaseableIF product = productCtrl.findLeaseable(barcode);
		//TODO make sure the copy has not yet been added.
		if(product != null) {
			products.add(product);
		}
		return product;
	}
	
	public boolean validateLoans() {
		//check if there is minimum 1 product
		boolean res = products.size() > 0;
		
		//check if any of the products are out of stock.
		for(int i = 0; i < products.size() && res; i++) {
			res = products.get(i).getStock(location) >= 1;
			
		}
		//check the thing for duplicates. Ask Penrose what this black magic is.
		//Was too lazy to do it in a more readable way
		if(products.stream().distinct().count() != products.size()) {
			res = false;
		}
		return res;
	}
}
