//package gui;
//
//import model.*;
//import tui.TryMe;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.jar.JarEntry;
//
//public class SaleGUI extends JFrame {
//
//    private Location location;
//    private Employee employee;
//
//
//    private JTextArea saleInfoTextArea;
//    private JTextField barcodeField;
//    private JTextField textField2;
//    private JButton button1;
//    private JButton button2;
//    private JButton button3;
//    private JButton button4;
////    SaleMenuGUI saleMenuGUI = new SaleMenuGUI();
//
//
//
//    public SaleGUI(Employee employee, Location location) {
//        this.employee = employee;
//        this.location = location;
//
//
////        setLayout(new GridLayout(11, 31, 10, 10));
//        setPreferredSize(new Dimension(1200, 700));
//        setTitle("Vestbjerg program T-800");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//        setResizable(false);
//
//        createComponents();
//        addComponents(); // Barcode field top
//
//        createButtons();
//        addButtons();
//        setButtonListeners();
//
//        pack();
//        setLocationRelativeTo(null); // Center the frame
//        add(textField2);
//    }
//
//
////    ____________________________________________________________________________________________________
//
//    //    BUTTONS
//    private void createButtons() {
//        button1 = new JButton("Sale Menu");
//        button1.setFont(new Font("Arial", Font.BOLD, 20));
//        button1.setBackground(Color.WHITE);
//        button1.setPreferredSize(new Dimension(300, 100));
//
//        button2 = new JButton("Customer Menu");
//        button2.setFont(new Font("Arial", Font.BOLD, 20));
//        button2.setBackground(Color.WHITE);
//        button2.setPreferredSize(new Dimension(300, 100));
//
//        button3 = new JButton("Generate Test Data");
//        button3.setFont(new Font("Arial", Font.BOLD, 20));
//        button3.setBackground(Color.WHITE);
//        button3.setPreferredSize(new Dimension(300, 100));
//
//        button4 = new JButton("Add product");
//        button4.setFont(new Font("Arial", Font.BOLD, 20));
//        button4.setBackground(Color.WHITE);
//        button4.setPreferredSize(new Dimension(300, 100));
////        button4.setVisible(false);
//
//    }
//
//    /**
//     * adds the buttons to the JPanel
//     */
//    private void addButtons() {
//        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        buttonPanel.add(button1);
//        buttonPanel.add(button2);
//        buttonPanel.add(button3);
////        buttonPanel.add(button4);
//
//        add(buttonPanel, BorderLayout.CENTER);
//    }
//
//    private void setButtonListeners() {
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new SaleMenuGUI(employee, location);
//            }
//        });
//
//        button2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        button3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                TryMe.createCustomers();
//                TryMe.createProducts(location);
//                System.out.println("Test data generated.");
//                button3.setEnabled(false);
//            }
//        });
//
//
//    }
//
//    //    ____________________________________________________________________________________________________
//    private void createComponents() {
//        barcodeField = new JTextField(20);
//
//        textField2 = new JTextField(); // bottom text-field
//        textField2.setBounds(150, 250, 150, 150);
//        textField2.setVisible(false);
//    }
//
//
//    //    ENTER BARCODE TOP FIELD
//    private void addComponents() {
//        saleInfoTextArea = new JTextArea(20, 50);
//        add(new JScrollPane(saleInfoTextArea), BorderLayout.CENTER);
//
//        textField2 = new JTextField(); // bottom text-field
//        textField2.setBounds(150, 250, 150, 150);
//        textField2.setVisible(false);
//        add(textField2);
//
//
//    }
//
//
//
//}
package gui;

