package model;

/**
 * The <code>AbstractProduct</code> class represents an abstract product entity.
 * It contains common attributes and methods for customers and employees.
 * 
 * @author Jonas
 * @version 15/12/2023
 * @since 07/12/2023
 */
public abstract class AbstractProduct {
	private String name;
	private String description;
	private String barcode;
	private double purchasePrice;
	
	/**
	 * This method constructs an <code>AbstractPerson</code> object with the provided product <code>name</code>, 
	 * <code>description</code>, <code>barcode</code> and <code>purchasePrice</code>.
	 * 
	 * @param name 			The name associated with the product.
	 * @param description 	The description associated with the product.
	 * @param barcode 		The barcode associated with the product.
	 * @param purchasePrice	The purchase price associated with the product.
	 */
	public AbstractProduct(String name, String description, String barcode, double purchasePrice) {
		this.name = name;
		this.description = description;
		this.barcode = barcode;
		this.purchasePrice = purchasePrice;
	}
	
	public AbstractProduct(String name, String description, String barcode, String purchasePrice) {
        this.name = name;
        this.description = description;
        this.barcode = barcode;

        try {
            this.purchasePrice = Double.parseDouble(purchasePrice);
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid purchase price format");
        }
    }
	
	
	
	/**
	 * This method checks if a product is unique or not.
	 * @return a boolean true or false indicating whether the product is unique: <code>true</code>, or not: <code>false</code>.  
	 */
	public abstract boolean isUnique();
	
	/**
	 * This method gets <code>name</code>.
	 * @return a <code>string</code> representing a products name.
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setBarcode(int index, String barcode) {
		this.barcode = barcode;
	}

	/**
	 * This method gets <code>barcode</code>.
	 * @return a <code>string</code> representing a products barcode.
	 */
	public String getBarcode() {
		return barcode;
	}


	
}
