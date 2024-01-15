package controller;

import java.time.LocalDateTime;

import model.Customer;
import model.Sale;
import model.Employee;
import model.SaleOrderLine;
import model.SellableIF;
import model.ShelfProduct;

/**
 * Mock version of SaleCtrl.
 * Purely for testing purposes, should not be in the final version.
 * 
 * @author Penrose
 * @version 11/12/2023
 * @since 11/12/2023
 */
public class MockSaleCtrl implements SaleCtrlIF {
	
	private Sale sale;
	private SellableIF product;
	private Employee employee;
	
	public MockSaleCtrl(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public Customer setCustomer(String phone) {
		Customer customer = new Customer("John","John Street","12345678","John@Johns.org");
		sale.setCustomer(customer);
		return customer;
	}

	@Override
	public SellableIF addProduct(String barcode) {
		product = new ShelfProduct("Desk", "A desk.", barcode, 300.0d, 700.0d, 0, LocalDateTime.of(2022,1,1,1,1));
		return product;
	}

	@Override
	public boolean setQuantity(int quantity) {
		SaleOrderLine saleOrderLine = new SaleOrderLine(product,quantity);
		sale.addSaleOrderLine(saleOrderLine);
		return true;
	}

	@Override
	public Sale makeSale() {
		sale = new Sale( LocalDateTime.now());
		return sale;
	}

	@Override
	public Sale completeSale(double payment) {
		sale.setEmployee(employee);
		return sale;
	}

	@Override
	public Customer setCustomer(Customer customer) {
		sale.setCustomer(customer);
		return customer;
	}
}
