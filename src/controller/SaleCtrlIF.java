package controller;

import model.Customer;
import model.Sale;
import model.SaleOrderLine;
import model.SellableIF;


/**
 * all the methods that are required for the SaleTUI to work,
 * so mock SaleCtrl is possible to make.
 * 
 * @author Penrose
 * @version 08/12/2023
 * @since 07/12/2023
 */
public interface SaleCtrlIF {

	public Customer setCustomer(String phone);
	public Customer setCustomer(Customer customer);
	public SaleOrderLine addProduct(String barcode);
	public boolean setQuantity(int quantity);
	public Sale makeSale();
	public Sale completeSale(double payment);
}
