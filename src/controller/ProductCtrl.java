package controller;

import model.AbstractProduct;
import model.LeaseableIF;
import model.LendableIF;
import model.ProductContainer;
import model.SellableIF;
import model.ShelfProduct;

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

	public AbstractProduct findProduct(String barcode) {
		return productContainer.findProduct(barcode);
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

	public ShelfProduct createProduct(String name, String barcode, String description, double purchasePrice) {
		ShelfProduct product = new ShelfProduct(name, barcode, description, purchasePrice);
		boolean success = productContainer.addProduct(product);
		if(!success) {
			product = null;
		}
		return product;
	}
	
	public void updateProduct(String name, String barcode, String description, double purchasePrice) {
		AbstractProduct product = findProduct(barcode);
		if (product != null) {
			product.setName(name);
			product.setDescription(description);
			product.setBarcode(barcode);
			product.setPurchasePrice(purchasePrice);
			System.out.println("Product has been updated: " + product);
		} else {
			System.out.println("Product could not be found: " + barcode);
		}
	}
}
