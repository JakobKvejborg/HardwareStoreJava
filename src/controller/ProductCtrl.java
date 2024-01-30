package controller;

import model.*;

import java.time.LocalDateTime;

/**
 * @author Jonas og Jakob, Penrose
 * 
 * @version 10/01/2023
 * @since 2023
 */
public class ProductCtrl {
	private ProductContainer productContainer;
	private Location location;
	private Employee employee;

	public ProductCtrl(Employee employee, Location location) {
		this.productContainer = ProductContainer.getInstance();
		this.employee = employee;
		this.location = location;
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

	public ShelfProduct createShelfProduct(String name, String barcode, String description, double purchasePrice, double price, double discount, LocalDateTime date) {
		ShelfProduct product = new ShelfProduct(name, description, barcode, purchasePrice, price, discount, date);
//		ShelfStock productStock = new ShelfStock(new Location("here", "address"), 2,2, 2); // maybe, jakob
//		product.addStock(productStock);     // maybe, jakob
		boolean success = productContainer.addProduct(product);
		
		if(!success) {
			product = null;
		}
        return product;
	}
	
	public ShelfStock createShelfStock(String barcode, int quantity) 
	{
		AbstractProduct product = findProduct(barcode);

		if(product instanceof ShelfProduct) {
			return createShelfStock((ShelfProduct) product, quantity);
		}
		else {
			return null;
		}
	}
	
    //TODO: add min and max quantity to this
	public ShelfStock createShelfStock(ShelfProduct product, int quantity) 
	{
		if(product == null) {
			return null;
		}
        ShelfStock shelfStock = new ShelfStock(location, quantity, 5, 45);
        product.addStock(shelfStock); // maybe, jakob
        productContainer.addProduct(product); // maybe, jakob
        return shelfStock;
	
	}
	
	
	public void updateProduct(String name, String barcode, String description, double purchasePrice, int index) {
		AbstractProduct product = findProduct(barcode);
		if (product != null) {
			product.setName(name);
			product.setDescription(description);
			product.setBarcode(index, barcode);
			product.setPurchasePrice(purchasePrice);
			System.out.println("Product has been updated: " + product);
		} else {
			System.out.println("Product could not be found: " + barcode);
		}
	}
	
	public void removeProduct(String barcode) {
		productContainer.removeProduct(barcode);
	}
}
