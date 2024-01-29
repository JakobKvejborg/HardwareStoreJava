  package model;

import java.time.LocalDateTime;

/**
 * @author Jonas, penrose
 * @version 12-12-2023
 * @since 12-12-2023
 */
public class UniqueCopy extends AbstractCopy implements SellableIF{
	private String warrenty;
	private UniqueProduct product;
	
	public UniqueCopy(String barcode,UniqueProduct product) {
		super(barcode);
		this.product = product;
		this.warrenty = product.getDefaultWarranty();
		
	}

	public void setWarranty(String warranty) {
		this.warrenty = warranty;
	}
	

	public boolean isUnique() {
		return true;
	}

	@Override
	public double getSalePrice(LocalDateTime date) {
		return product.getSalePrice(date);
	}

	@Override
	public String getName() {
		return product.getName();
	}

	@Override
	public String getDescription() {
		return product.getDescription();
	}

	@Override
	public double getOriginalSalePrice(LocalDateTime date) {
		// TODO Auto-generated method stub
		return product.getOriginalSalePrice(date);
	}

	@Override
	public double getSaleDiscount(LocalDateTime date) {
		// TODO Auto-generated method stub
		return product.getSaleDiscount(date);
	}

	
	
}
