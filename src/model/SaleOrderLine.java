package model;

/**
 * contains a sellable product, and the quantity for the product. Should never
 * have a quantity more than 1 for unique products.
 * 
 * @author Penrose
 * @version 07/12/2023
 * @since 07/12/2023
 */
public class SaleOrderLine {

	private SellableIF product;
	private int quantity;

	/**
	 * Contains the product and the amount of that product
	 * 
	 * @param product
	 * @param quantity
	 */
	public SaleOrderLine(SellableIF product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * gets the price of a product
	 * 
	 * @return the price from product
	 */
	public double getPrice() {
		return product.getPrice();
	}
	
	/**
	 * gets the product
	 * @return the product
	 */
	public SellableIF getProduct() {
		return product;
	}
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
