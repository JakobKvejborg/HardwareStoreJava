package tui;

import controller.SaleCtrl;
import controller.SaleCtrlIF;
import model.Customer;
import model.Employee;
import model.Location;
import model.SellableIF;
import model.Sale;
import model.SaleOrderLine;


/**
 * The Text User Interface responsible for creating sales.
 *
 * @author Penrose
 * @version 11/12/2023
 * @since 07/12/2023
 */
public class SaleTUI {

    private SaleCtrlIF saleCtrl;
    private Employee employee;
    private Location location;
    private TextInput textInput;


    public SaleTUI(Employee employee, Location location) {
        this.employee = employee;
        this.location = location;
        saleCtrl = new SaleCtrl(employee, location);
        textInput = TextInput.getInstance();

    }

    public void start() {
        createSale();
    }

    private boolean isQuitText(String text) {
        return text.equalsIgnoreCase("quit") || text.equalsIgnoreCase("q") || text.equalsIgnoreCase("next")
                || text.equalsIgnoreCase("done");
    }

    private boolean newCustomerText(String text) {
        return text.equalsIgnoreCase("c");
    }

    /**
     * creates a sale all the way to completion.
     */
    private void createSale() {
        Sale sale = saleCtrl.makeSale(); // this returns a sale object

        boolean allProductsAdded = false;
        System.out.println("Input product barcode. If all products have been added, input next.");
        while (!allProductsAdded) {
            String barcode = textInput.readString();
            if (isQuitText(barcode)) {
                allProductsAdded = true;
            } else {
                SellableIF product = addProduct(barcode);
                System.out.println("Input product barcode. If all products have been added, input next.");
            }

        }
        Customer customer = setCustomer();
        System.out.println("total price of sale: " + sale.getPrice());
        System.out.println("Payment in DKK: ");
        double payment = inputPayment();
        sale = saleCtrl.completeSale(payment);
        if (sale == null) {
            System.out.println("The sale could not be completed.");
        } else {
            printSale(sale, payment);
        }

    }

    private Customer createNewCustomer() {
        System.out.println("Press C to create new customer, or input next.");
        String newCustomerInput = textInput.readString();
        Customer customer = null;
        if (newCustomerText(newCustomerInput)) {
            customer = new CustomerTUI().createCustomer();
        }
        return customer;
    }


    private SellableIF addProduct(String barcode) {
    	SaleOrderLine saleOrderLine = saleCtrl.addProduct(barcode);
        SellableIF product = saleOrderLine.getProduct();
        
        if (product == null) {
            System.out.println("Could not read barcode, or product could not be sold, try again.");
        } else {
            System.out.println("Product Added: " + product.getName());
            if (!product.isUnique()) {
                setQuantity();
            }
        }
        return product;
    }

    private void setQuantity() {
        boolean quantitySuccess = false;
        while (!quantitySuccess) {
            System.out.println("Input quantity.");
            int quantity = textInput.readInt();
            quantitySuccess = saleCtrl.setQuantity(quantity);
            if (!quantitySuccess) {
                System.out.println("Could not set the quantity to: " + quantity);
            } else {
                System.out.println("Quantity set successfully.");
            }
        }
    }

    /**
     * Sets a customer for the current sale based on the phone number input.
     * If no customer is found then try again or proceed without a customer.
     *
     * @return The customer object set to the sale, or <code>null</code> if not found.
     */
    private Customer setCustomer() {
        Customer customer = createNewCustomer();
        if (customer != null) {
            //could add a function where a customer is added directly, instead of being found. Would be more efficient.
            customer = saleCtrl.setCustomer(customer);
        } else {
            boolean success = false;
            while (!success) {
                System.out.println("Input customer phone number. If no customer, input \"next\".");
                String phone = textInput.readString();
                if (isQuitText(phone)) {
                    success = true;
                } else {
                    customer = saleCtrl.setCustomer(phone);
                    if (customer != null) {
                        success = true;
                    } else {
                        System.out.println("Could not find the customer!");
                    }
                }
            }
        }
        return customer;
    }

    /**
     * Allows the user to input the amount of cash paid for the sale.
     *
     * @return The amount of cash paid by the user as a <code>double</code>.
     */
    private double inputPayment() {
        //TODO: make this accept payment by card and such, never happening in the time we have been alloted.
        double payment = textInput.readDouble();

        return payment;
    }

    /**
     * This method checks if the payment is greater than the total price.
     *
     * @param sale
     * @param payment
     */
    private void printSale(Sale sale, double payment) {
        //TODO: print the sale info.
        if (sale == null || sale.getPrice() > payment) {
            System.out.println("Sale could not be completed.");
        }
        if (sale.getPrice() <= payment) {
            System.out.println("Sale completed!");
            System.out.println("---------------");
            for (int i = 0; i < sale.getSaleOrderLinesSize(); i++) {
                SaleOrderLine saleOrderLine = sale.getSaleOrderLine(i);
                System.out.print(saleOrderLine.getProduct().getName());
                System.out.print("\t");
                System.out.print(saleOrderLine.getProduct().getPrice(sale.getDate()));
                System.out.print("\t x");
                System.out.println(saleOrderLine.getQuantity());
            }
            System.out.println("---------------");
            System.out.print("total:\t");
            System.out.println(sale.getPrice());
            System.out.print("OrderNo:\t");
            System.out.println(sale.getOrderNo());
            if (sale.getCustomer() != null) {
                System.out.println("Customer attached to the sale: ");
                System.out.println("Name: " + sale.getCustomer().getName());
                System.out.println("Phone: " + sale.getCustomer().getPhone());
                System.out.println("Address: " + sale.getCustomer().getAddress());
                System.out.println("Email: " + sale.getCustomer().getEmail());
                System.out.println();

                //TODO print customer information
            } else {
                System.out.println("No customer attached to the sale.");
                System.out.println();
            }

        }
    }

}
