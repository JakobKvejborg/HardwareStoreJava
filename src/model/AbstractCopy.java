package model;

public abstract class AbstractCopy {
	
	private String barcode;
	private UniqueStock stock;
	
	public AbstractCopy(String barcode) {
		this.barcode = barcode;
	}
	
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public UniqueStock getStock() {
		return stock;
	}

	public void setStock(UniqueStock stock) {
		this.stock = stock;
	}
	
	//public abstract double getPrice(LocalDateTime date);

	
}
