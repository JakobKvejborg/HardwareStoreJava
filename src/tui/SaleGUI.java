package tui;

import controller.SaleCtrl;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaleGUI extends JFrame {

    private Location location;
    private Employee employee;

    private SaleCtrl saleCtrl;
    private JTextArea saleInfoTextArea;
    private JTextField barcodeField;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public SaleGUI(Employee employee, Location location) {
        this.employee = employee;
        this.location = location;
        saleCtrl = new SaleCtrl(employee, location);

//        JFrame frame = new JFrame();
//        frame.setSize(800, 600);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

//        setLayout(new GridLayout(11, 31, 10, 10));
        setPreferredSize(new Dimension(1200, 700));
        setTitle("Vestbjerg program T-800");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        createComponents();
        addComponents(); // Barcode field top
        setListeners();

        createButtons();
        addButtons();
        setButtonListeners();

        pack();
        setLocationRelativeTo(null); // Center the frame
    }


//    ____________________________________________________________________________________________________

    //    BUTTONS
    private void createButtons() {
        button1 = new JButton("1. Sale Menu");
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        button1.setBackground(Color.WHITE);
        button1.setPreferredSize(new Dimension(300, 100));

        button2 = new JButton("2. Customer Menu");
        button2.setFont(new Font("Arial", Font.BOLD, 20));
        button2.setBackground(Color.WHITE);
        button2.setPreferredSize(new Dimension(300, 100));

        button3 = new JButton("3. Generate Test Data");
        button3.setFont(new Font("Arial", Font.BOLD, 20));
        button3.setBackground(Color.WHITE);
        button3.setPreferredSize(new Dimension(300, 100));

    }

    /**
     * adds the buttons to the JPanel
     */
    private void addButtons() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void setButtonListeners() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createSale();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TryMe.createCustomers();
                TryMe.createProducts(location);
                System.out.println("Test data generated.");
            }
        });

    }

//    ____________________________________________________________________________________________________
    private void createComponents() {
        saleInfoTextArea = new JTextArea(20, 50);
        barcodeField = new JTextField(20);
        // Initialize other components as needed
    }


//    ENTER BARCODE TOP FIELD
    private void addComponents() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter Barcode: "));
        panel.add(barcodeField);
        // Add other components to the panel

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(saleInfoTextArea), BorderLayout.CENTER);
    }

    private void setListeners() {
        barcodeField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String barcode = barcodeField.getText();
                SellableIF product = saleCtrl.addProduct(barcode);
                // Process product addition, update UI accordingly
            }
        });
        // Add action listeners for other components
    }

    private void createSale() {
//        Sale sale = saleCtrl.makeSale();
//
//        boolean allProductsAdded = false;
//        System.out.println("Input product barcode. If all products have been added, input next.");
//        while (!allProductsAdded) {
//            String barcode = textInput.readString();
//            if (isQuitText(barcode)) {
//                allProductsAdded = true;
//            } else {
//                SellableIF product = addProduct(barcode);
//                System.out.println("Input product barcode. If all products have been added, input next.");
//            }
//
//        }
//        Customer customer = setCustomer();
//        System.out.println("total price of sale: " + sale.getPrice());
//        System.out.println("Payment in DKK: ");
//        double payment = inputPayment();
//        sale = saleCtrl.completeSale(payment);
//        if (sale == null) {
//            System.out.println("The sale could not be completed.");
//        } else {
//            printSale(sale, payment);
//        }
    }


}