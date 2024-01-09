//package gui;
//
//import controller.SaleCtrl;
//import model.*;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class SaleMenuGUI {
//    private JTextField barcodeField;
//    private JLabel displayLabel;
//    private SaleCtrl saleCtrl;
//    private Sale sale;
//    private Location location;
//    private Employee employee;
//    private JButton button5;
//    private JButton button6;
//    private JButton button7;
//    private JButton button8;
//
//    public SaleMenuGUI(Employee employee, Location location) {
//        this.employee = employee;
//        this.location = location;
//        saleCtrl = new SaleCtrl(employee, location);
//
//        JFrame newFrame = new JFrame();
//        newFrame.setPreferredSize(new Dimension(1100, 600));
//
//        JPanel panel = new JPanel();
//        panel.add(new JLabel("Enter Barcode: "));
//
//        barcodeField = new JTextField(20);
//        panel.add(barcodeField);
//
//        createButtons();
//        setButtonListeners();
//        setBarcodeListener();
//
//        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        buttonPanel2.add(button5);
//        buttonPanel2.add(button6);
//        buttonPanel2.add(button7);
//        buttonPanel2.add(button8);
//
//        // Add the panels to the frame
//        newFrame.setLayout(new BorderLayout()); // Does nothing delete maybe
//        newFrame.add(panel, BorderLayout.NORTH);
//        newFrame.add(buttonPanel2, BorderLayout.CENTER);
//
//        newFrame.pack();
//        newFrame.setLocationRelativeTo(null);
//        newFrame.setVisible(true);
//        newFrame.setResizable(false);
//
//        // Displays the product added
//        displayLabel = new JLabel();
//        displayLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align text
//
//        newFrame.add(panel, BorderLayout.NORTH);
//        newFrame.add(buttonPanel2, BorderLayout.CENTER);
//        newFrame.add(displayLabel, BorderLayout.SOUTH);
//    }
//
//    private void createButtons() {
//        button5 = new JButton("Add product");
//        button5.setFont(new Font("Arial", Font.BOLD, 20));
//        button5.setBackground(Color.WHITE);
//        button5.setPreferredSize(new Dimension(300, 100));
//
//        button6 = new JButton("Add product quantity");
//        button6.setFont(new Font("Arial", Font.BOLD, 20));
//        button6.setBackground(Color.WHITE);
//        button6.setPreferredSize(new Dimension(300, 100));
//
//        button7 = new JButton("Create new customer");
//        button7.setFont(new Font("Arial", Font.BOLD, 20));
//        button7.setBackground(Color.WHITE);
//        button7.setPreferredSize(new Dimension(300, 100));
//
//        button8 = new JButton("Checkout");
//        button8.setFont(new Font("Arial", Font.BOLD, 20));
//        button8.setBackground(Color.WHITE);
//        button8.setPreferredSize(new Dimension(300, 100));
//
//    }
//
//    // BARCODE ActionListener
//    private void setBarcodeListener() {
//        barcodeField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String barcode = barcodeField.getText();
////                SellableIF product = saleCtrl.addProduct(barcode); // may be double here
//            }
//        });
//    }
//
////    ___________________________________________________________________________________________
//
//    // BUTTONS ACTIONLISTENER
//    private void setButtonListeners() {
//        button5.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                button5AddProduct();
//            }
//        });
//
//        button6.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                button6addQuantity();
//            }
//        });
//
//
//        button7.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        button8.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                button8checkout();
//            }
//        });
//    }
//
//    private void button5AddProduct() {
//        String barcode = barcodeField.getText();
//
//        Sale sale = saleCtrl.makeSale();
//
//        SellableIF product = saleCtrl.addProduct(barcode);
//
//        displayLabel.setText("Product added: " + product.getName());
//        displayLabel.setFont(new Font("Arial", Font.BOLD, 38));
//
//    }
//
//    private void button6addQuantity() {
//        // Dialog to get the quantity
//        String quantityStr = JOptionPane.showInputDialog("Enter quantity:");
//        int quantity1 = 0;
//        try {
//            quantity1 = Integer.parseInt(quantityStr);
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(null, "Invalid quantity. Please enter a number.");
//            return;
//        }
//
//        String barcode = barcodeField.getText();
//        Sale sale = saleCtrl.makeSale();
//
//        SellableIF product = saleCtrl.addProduct(barcode);
//        saleCtrl.setQuantity(quantity1);
//        if (product != null) {
//            displayLabel.setText("Product added: " + product.getName() + " (x" + quantity1 + (")"));
//            displayLabel.setFont(new Font("Arial", Font.BOLD, 28));
//        }
//    }
//
//    private void button8checkout() {
//        String paymentInput = JOptionPane.showInputDialog("Input payment:");
//        double payment;
//        payment = Double.parseDouble(paymentInput);
//        sale = saleCtrl.completeSale(payment);
//        displayLabel.setText("Total price: " + sale.getPrice() + "kr" + " Paid: " + payment + "kr Change: " + (payment - sale.getPrice()) + "kr");
//    }
//
//
////        _____________________________________________________________________________________
//
//
//}
package gui;


