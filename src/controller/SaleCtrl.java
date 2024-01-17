package controller;

import java.time.LocalDateTime;

import model.AbstractOrder;
import model.AbstractProduct;
import model.Customer;
import model.Employee;
import model.Location;
import model.OrderContainer;
import model.Sale;
import model.SaleOrderLine;
import model.SellableIF;

/**
 * @author Jonas og Jakob
 * 
 * @version 12/12/2023
 * @since 08/12/2023
 */
//TODO: add null checks to everything
public class SaleCtrl implements SaleCtrlIF {
	
	private Employee employee;
	private Location location;
	private OrderContainer orderContainer;
	private ProductCtrl productCtrl;
	private CustomerCtrl customerCtrl;
	private Sale sale;
	
	public SaleCtrl(Employee employee, Location location) {
		this.employee = employee;
		this.location = location;
		this.productCtrl = new ProductCtrl();
		this.customerCtrl = new CustomerCtrl();
		this.orderContainer = OrderContainer.getInstance();
	}

	/**
	 * finds a customer by their phone number and adds them to the sale.
	 * it is not necessary to add a customer to complete a sale.
	 * 
	 * @return returns the customer added to the sale.
	 */
	public Customer setCustomer(String phone) {
		Customer customer = customerCtrl.findCustomer(phone);
		sale.setCustomer(customer);
		return customer;
	}
	
	public Customer setCustomer(Customer customer) {
		sale.setCustomer(customer);
		return customer;
	}
	
	
	/**
	 * finds a product, checks if it can be sold, and adds it to the sale in the form of a <code>SaleOrderLine</code>.
	 * 
	 * @param the barcode of the product to be added
	 * @return the found product in the form of a <code>SellableIF</code>.
	 * returns null if the no product has the barcode or the product cannot be sold.
	 */
	//Maybe this function should throw exceptions if the product isn't sellable,
	//or if no product is found.
	public SaleOrderLine addProduct(String barcode) {
		SellableIF product = productCtrl.findSellable(barcode);
		SaleOrderLine saleOrderLine = null;
		if(product != null) {
			//TODO: prevent multiple of the same unique item being added
			//TODO: handle when two of the same non-unique item is added.
			//check if there's at least one of the item.
			if(product.getStock(location) >= 1) {
				saleOrderLine = new SaleOrderLine(product, 1);
				sale.addSaleOrderLine(saleOrderLine);
			}
			else {
				product = null;
			}
		}
		return saleOrderLine;
	}
	
	/**
	 * sets the quantity of the last added OrderLine.
	 * 
	 * @param quantity
	 * @return returns true if the quantity was successfully set.
	 */
	public boolean setQuantity(int quantity) {
		//make sure that you cannot add 0 or negative quantities (guard clause)
		if(quantity < 1) {
			return false;
		}
		
		//get the last SaleOrderLine in the sale
		SaleOrderLine saleOrderLine = sale.getSaleOrderLine(sale.getSaleOrderLinesSize() - 1);
		//check if the SaleOrderLine exists and if the quantity can be anything other than 1 (guard clause)
		if(saleOrderLine == null || saleOrderLine.getProduct().isUnique()) {
			return false;
		}
		
		//check if there's enough stock:
		if(saleOrderLine.getProduct().getStock(location) < quantity) {
			return false;
		}
		
		//set the quantity
		saleOrderLine.setQuantity(quantity);
		return true;
	}

	/**
	 * creates a new sale.
	 * @return returns the created sale.
	 */
	public Sale makeSale() {
		//orderNo is now assigned at completion
//		int newOrderNumber = ++lastOrderNumber; // delete
		sale = new Sale(LocalDateTime.now());
		return sale;
	}

	public void clearSale() {
		sale = null;
	}
	
	/**
	 * completes a sale, checks payment, and makes sure everything is correctly set up.
	 * persists the sale.
	 * 
	 * @return returns the created sale. returns null if the sale was improperly created, or not enough was paid.
	 */
	//TODO: figure out what to do if the customer overpays.
	public Sale completeSale(double payment) {
		// TODO make sure the sale has proper values
		Sale res = null;
		if(payment >= sale.getPrice()) {
			sale.setEmployee(employee);
			sale.setOrderNo(orderContainer.generateOrderNO());
			
			for(int i = 0; i < sale.getSaleOrderLinesSize(); i++) {
				//reduce the stock of each item in the sale
				boolean success = sale.getSaleOrderLine(i).getProduct().decrementStock(
						sale.getSaleOrderLine(i).getQuantity(), location);
				//if success is false, the stock was not handled correctly.
				//TODO: figure out what to do.
			}
			
			orderContainer.addOrder(sale);
			res = sale;
			clearSale();
		}
		return res;
	}

	public AbstractOrder findOrder(int orderNO) {
		return orderContainer.findOrder(orderNO);
	}
	
	public Sale createOrder(int orderNO, LocalDateTime date) {
		Sale order = new Sale(date);
		boolean success = orderContainer.addOrder(order);
		if(!success) {
			order = null;
		}
		return order;
	}
	
	public void updateOrder(int orderNO, LocalDateTime date) {
		AbstractOrder order = findOrder(orderNO);
		if(order != null) {
			order.setOrderNo(orderNO);
			order.setCustomer(null);
			order.setEmployee(employee);
			System.out.println("Order has been updated: " + order);
		} else {
			System.out.println("Order could not be found: " + orderNO);
		}
	}

	public Sale getSale() {
		return sale;
	}
}
