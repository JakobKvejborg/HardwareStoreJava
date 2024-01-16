package tui;

import java.time.LocalDateTime;

import model.Aisle;
import model.Customer;
import model.CustomerContainer;
import model.LendableCopy;
import model.LendableProduct;
import model.Location;
import model.ShelfProduct;
import model.ShelfStock;
import model.UniqueCopy;
import model.UniqueProduct;
import model.ProductContainer;
import model.UniqueStock;

/**
 * This class is used to create test environment with dummy data.
 * 
 * @author Patrick Thor Sorenson De Siqueira
 * @version 15/12/2023
 * @since 14/12/2023
 */
public class TryMe {
	private static CustomerContainer customerContainer;
	private static ProductContainer productContainer;
	
	/**
	 * This method creates two <code>Customer</code> as dummy data and adds them to <code>customerContainer</code>.
	 */
	public static void createCustomers() {
		customerContainer = CustomerContainer.getInstance();
		Customer customer1 = new Customer("John", "UCN", "12345678", "School@UCN.dk");
		Customer customer2 = new Customer("Jane", "The Moon", "87654321", "Moonbase@Alpha.dk");
		
		customerContainer.addCustomer(customer1);
		customerContainer.addCustomer(customer2);
	}
	
	/**
	 * This method creates two <code>ShelfProduct</code> and <code>UniqueCopy</code> as dummy data and adds them to <code>productContainer</code> and stock.
	 */
	public static void createProducts(Location location) {
		
		//Aisle aisle = new Aisle("Area 51, shelf 3.", location);
		
		productContainer = ProductContainer.getInstance();
		ShelfProduct product1 = new ShelfProduct("Table", "Et langt bord til 6 personer.\nKan fås i 39 forskellige farver.", "123456", 9.99, 19.99, 0, LocalDateTime.now());
		ShelfProduct product2 = new ShelfProduct("Chair", "En grim rød stol med kun 3 ben.", "654321", 25.99, 35.99, 0.15, LocalDateTime.now());
		ShelfProduct product3 = new ShelfProduct("Skruer", "4,5x60/40mm rustfrie skruer 100stk. Perfekt til at skrue ned i sin egen finger. \nKan også bruges til træ.", "1", 30.99, 79.99, 0, LocalDateTime.now());
		ShelfStock product1Stock = new ShelfStock(location, 5, 2, 20);
		ShelfStock product2Stock = new ShelfStock(location, 12, 3, 20);
		ShelfStock product3Stock = new ShelfStock(location, 10, 4, 10);

		product1.addStock(product1Stock);
		product2.addStock(product2Stock);
		product3.addStock(product3Stock);
		
		productContainer.addProduct(product1);
		productContainer.addProduct(product2);
		productContainer.addProduct(product3);
		
		UniqueProduct product4 = new UniqueProduct("Fridge", "Very cold", "111", 399.99, 699.99, 0.05, LocalDateTime.now(), "This warrenty is a String!");
		
		productContainer.addProduct(product4);
		
		UniqueCopy copy1 = new UniqueCopy("222", product4);
		UniqueCopy copy2 = new UniqueCopy("333", product4);
		UniqueStock copyStock = new UniqueStock(location, 2, 7);
		copy1.setStock(copyStock);
		copy2.setStock(copyStock);
		copyStock.addCopy(copy1);
		copyStock.addCopy(copy2);
		
		LendableProduct lendableProduct = new LendableProduct("Tractor", "wroom wroom!", "987789", 4999, 12, 0, 13, 0);
		LendableCopy leaseCopy = new LendableCopy("999", lendableProduct);
		UniqueStock loanLeaseStock = new UniqueStock(location, 2, 7);
		leaseCopy.setStock(loanLeaseStock);
		loanLeaseStock.addCopy(leaseCopy);
		
		productContainer.addCopy(copy1);
		productContainer.addCopy(copy2);
		productContainer.addCopy(leaseCopy);

		

	}
	
}
