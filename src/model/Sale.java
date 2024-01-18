package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The order that is used for selling different sellable products.
 *
 * @author Penrose
 * @version 07/12/2023
 * @since 07/12/2023
 */
public class Sale extends AbstractOrder {

    private double craftmanDiscount;
    private double quantityDiscount;
    private double collectionDiscount;
//	private int orderNo = 100000;

    private ArrayList<SaleOrderLine> saleOrderLines;

    /**
     * Represents a sale of a product
     *
     * @param orderNo contains the number unique to a specific sale
     * @param date    contains the date the sale was made
     */
    public Sale(LocalDateTime date) {
        super(date);
        saleOrderLines = new ArrayList<>();
        craftmanDiscount = 0.0d;
        quantityDiscount = 0.0d;
        collectionDiscount = 0.0d;
    }

    /**
     * adds a saleOrderLine to the sale
     *
     * @param saleOrderLine
     */
    public void addSaleOrderLine(SaleOrderLine saleOrderLine) {
        saleOrderLines.add(saleOrderLine);
    }

    /**
     * Gets total price of all products for a sale
     *
     * @return a double representing the total cost of a sale
     */
    public double getPrice() {
        double total = 0.0d;
        for (int i = 0; i < saleOrderLines.size(); i++) {
            total += saleOrderLines.get(i).getPrice(super.getDate());
        }
        double totalDiscount = craftmanDiscount + quantityDiscount + collectionDiscount;
        double maxDiscount;
        if (super.getCustomer() == null) {
            maxDiscount = CustomerGroup.getDefaultCustomerGroup().getMaxDiscount(super.getDate());
        } else {
            maxDiscount = super.getCustomer().getMaxDiscount(super.getDate());
        }
        //TODO: make this thing not dumb
        if (totalDiscount > maxDiscount) {
            totalDiscount = maxDiscount;
        }
        //return total * (1.0d - totalDiscount)
        return total * (1.0d - maxDiscount);

    }

    /**
     * @param index of the <code>SaleOrderLine</code>
     * @return The <code>SaleOrderLine</code>
     */
    public SaleOrderLine getSaleOrderLine(int index) {
        return saleOrderLines.get(index);
    }

    /**
     * @return The the number of <code>SaleOrderLine</code>s in the sale.
     */
    public int getSaleOrderLinesSize() {
        return saleOrderLines.size();
    }

	public void removeSaleOrderLine(int index) {
		saleOrderLines.remove(index);
	}


}
