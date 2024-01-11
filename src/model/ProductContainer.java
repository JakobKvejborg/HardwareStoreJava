package model;

import java.util.ArrayList;
/**
 * Contains a list of products
 * @author Jonas og Jakob
 * @version 07/12/2023
 * @since 07/12/2023
 */
public class ProductContainer {
	private static ProductContainer instance;
	private ArrayList<AbstractProduct> products;
	private ArrayList<AbstractCopy> copies;
	
	private ProductContainer() {
		products = new ArrayList<>();
		copies = new ArrayList<>();
	}
	
	public static ProductContainer getInstance() {
		if(instance == null) {
			instance = new ProductContainer();
		}
		return instance;
	}
	
	/** 
	 * Finds a product by barcode
	 * is O(n) 
	 * @param barcode		a barcode in string
	 * @return product, null if no product is found
	 */
	public AbstractProduct findProduct(String barcode) {
		//Binary Search could be implemented if the list is always sorted.
		AbstractProduct res = null;
		boolean found = false;
		for (int i = 0; i < products.size() && !found; i++) {
			//ProductContainer product = products.get(i);
			AbstractProduct product = products.get(i);
			if (product.getBarcode().equals(barcode)) {
				res = product;
				found = true;
			}
		}
		return res;
	}
	
	
	public AbstractCopy findCopy(String barcode) {
		//Binary Search could be implemented if the list is always sorted.
		AbstractCopy res = null;
		boolean found = false;
		for (int i = 0; i < copies.size() && !found; i++) {
			//ProductContainer product = products.get(i);
			AbstractCopy copy = copies.get(i);
			if (copy.getBarcode().equals(barcode)) {
				res = copy;
				found = true;
			}
		}
		return res;
	}
	
	public SellableIF findSellable(String barcode) {
		SellableIF res = null;
		AbstractCopy copy = findCopy(barcode);
		//Check if the found copy can be sold
		if(copy instanceof SellableIF) {
			//change the static type of the copy to a SellableIF
			res = (SellableIF) copy;
		}
		else {
			// if no copy that works is found:
			AbstractProduct product = findProduct(barcode);
			//Check if the product can be sold
			if (product instanceof SellableIF) {
				//change the static type of the product to SellableIF
				res = (SellableIF) product;
			}
		}
		return res;
	}
	
	public LeaseableIF findLeaseable(String barcode) {
		LeaseableIF res = null;
		AbstractCopy copy = findCopy(barcode);
		//Check if the found copy can be leased
		if(copy instanceof SellableIF) {
			//change the static type of the copy to a LeaseableIF
			res = (LeaseableIF) copy;
		}
		//products cannot be leaseable, so it's not necessary to loop through them.
		return res;
	}
	
	public LendableIF findLendable(String barcode) {
		LendableIF res = null;
		AbstractCopy copy = findCopy(barcode);
		//Check if the found copy can be lend
		if(copy instanceof SellableIF) {
			//change the static type of the copy to a LendableIF
			res = (LendableIF) copy;
		}
		//products cannot be lendable, so it's not necessary to loop through them.
		return res;
	}
	
	/** 
	 * adds a product to list 
	 * @param product		represents a product
	 * @return true if the product has been added to the list
	 */
	public boolean addProduct(AbstractProduct product) {
		boolean res = false;
		if(!hasBarcode(product.getBarcode())) {
			products.add(product);
			//TODO: sort the list
			res = true;
		}
		return res;
	}
	
	public boolean hasBarcode(String barcode) {
		boolean res = true;
		if(findCopy(barcode) == null) {
			if(findProduct(barcode) == null) {
				res = false;
			}
		}
		return res;
	}

	public boolean addCopy(AbstractCopy copy) {
		boolean res = false;
		if(!hasBarcode(copy.getBarcode())) {
			copies.add(copy);
			//TODO: sort the list
			res = true;
		}
		return res;
	}
	
	
	public void removeProduct(String barcode) {
		AbstractProduct product = findProduct(barcode);
		
		if(product != null) {
			products.remove(product);
		}
	}
}

