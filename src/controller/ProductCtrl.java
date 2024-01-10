package controller;

import model.AbstractProduct;
import model.LeaseableIF;
import model.LendableIF;
import model.ProductContainer;
import model.SellableIF;

/**
 * @author Jonas og Jakob, Penrose
 * 
 * @version 10/01/2023
 * @since 2023
 */
public class ProductCtrl {
	private ProductContainer productContainer;

	public ProductCtrl() {
		this.productContainer = ProductContainer.getInstance();
	}
	
	public AbstractProduct findProduct(String productId) {
		return productContainer.findProduct(productId);
	}
	
	public SellableIF findSellable(String barcode) {
		return productContainer.findSellable(barcode);
	}
	
	public LeaseableIF findLeaseable(String barcode) {
		return productContainer.findLeaseable(barcode);
	}
	
	public LendableIF findLendable(String barcode) {
		return productContainer.findLendable(barcode);
	}
}
