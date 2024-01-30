package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ProductCtrl;
import model.*;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Author
 * Jonas Glintborg
 * Jakob Kvejborg
 */

public class CreateProductWindow extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtFieldDiscount;
    private JTextField txtFieldPrice;
    private JTextField txtFieldQuantity;
    private JTextField txtFieldName;
    private JTextField txtFieldBarcode;
    private JTextField txtFieldDescription;
    private JLabel lblErrorLabelCCW;
    private ProductCtrl productCtrl;
    private Customer customer = null;
    private boolean okClicked = false;
    private ShelfProduct product; // TODO maybe AbstractProduct instead
    private ProductContainer productContainer;
    private ProductsPanel productsPanel;



    /**
     * Create the dialog.
     */
    public CreateProductWindow(ProductCtrl productCtrl, ProductContainer productContainer) {
        setResizable(false);
        setModal(true);
        this.productCtrl = productCtrl;
        createLayout();
        this.productContainer = ProductContainer.getInstance();

    }

    private void createLayout() {
        setTitle("Tilføj nyt product");
        setBounds(100, 100, 320, 228);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 244, 0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);

        {
            JLabel lblName = new JLabel("Navn:");
            GridBagConstraints gbc_lblName = new GridBagConstraints();
            gbc_lblName.anchor = GridBagConstraints.EAST;
            gbc_lblName.insets = new Insets(0, 0, 5, 5);
            gbc_lblName.gridx = 0;
            gbc_lblName.gridy = 0;
            contentPanel.add(lblName, gbc_lblName);
        }
        {
            txtFieldName = new JTextField();
            GridBagConstraints gbc_txtFieldName = new GridBagConstraints();
            gbc_txtFieldName.insets = new Insets(0, 0, 5, 0);
            gbc_txtFieldName.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtFieldName.gridx = 1;
            gbc_txtFieldName.gridy = 0;
            contentPanel.add(txtFieldName, gbc_txtFieldName);
            txtFieldName.setColumns(10);
        }
        {
            JLabel lblAdress = new JLabel("Antal:");
            GridBagConstraints gbc_lblAdress = new GridBagConstraints();
            gbc_lblAdress.anchor = GridBagConstraints.EAST;
            gbc_lblAdress.insets = new Insets(0, 0, 5, 5);
            gbc_lblAdress.gridx = 0;
            gbc_lblAdress.gridy = 1;
            contentPanel.add(lblAdress, gbc_lblAdress);
        }
        {
            txtFieldQuantity = new JTextField();
            GridBagConstraints gbc_txtFieldQuantity = new GridBagConstraints();
            gbc_txtFieldQuantity.insets = new Insets(0, 0, 5, 0);
            gbc_txtFieldQuantity.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtFieldQuantity.gridx = 1;
            gbc_txtFieldQuantity.gridy = 1;
            contentPanel.add(txtFieldQuantity, gbc_txtFieldQuantity);
            txtFieldQuantity.setColumns(10);
        }
        {
            JLabel lblPhone = new JLabel("Pris:");
            GridBagConstraints gbc_lblPhone = new GridBagConstraints();
            gbc_lblPhone.anchor = GridBagConstraints.EAST;
            gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
            gbc_lblPhone.gridx = 0;
            gbc_lblPhone.gridy = 2;
            contentPanel.add(lblPhone, gbc_lblPhone);
        }
        {
            txtFieldPrice = new JTextField();
            GridBagConstraints gbc_txtFieldPrice = new GridBagConstraints();
            gbc_txtFieldPrice.insets = new Insets(0, 0, 5, 0);
            gbc_txtFieldPrice.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtFieldPrice.gridx = 1;
            gbc_txtFieldPrice.gridy = 2;
            contentPanel.add(txtFieldPrice, gbc_txtFieldPrice);
            txtFieldPrice.setColumns(10);
        }
        {
            JLabel lblEmail = new JLabel("Rabat:");
            GridBagConstraints gbc_lblEmail = new GridBagConstraints();
            gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
            gbc_lblEmail.anchor = GridBagConstraints.EAST;
            gbc_lblEmail.gridx = 0;
            gbc_lblEmail.gridy = 3;
            contentPanel.add(lblEmail, gbc_lblEmail);
        }
        {
            txtFieldDiscount = new JTextField();
            GridBagConstraints gbc_txtFieldDiscount = new GridBagConstraints();
            gbc_txtFieldDiscount.insets = new Insets(0, 0, 5, 0);
            gbc_txtFieldDiscount.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtFieldDiscount.gridx = 1;
            gbc_txtFieldDiscount.gridy = 3;
            contentPanel.add(txtFieldDiscount, gbc_txtFieldDiscount);
            txtFieldDiscount.setColumns(10);
        }
        {
            JLabel lblBarCode = new JLabel("Stregkode:");
            GridBagConstraints gbc_lblBarCode = new GridBagConstraints();
            gbc_lblBarCode.anchor = GridBagConstraints.EAST;
            gbc_lblBarCode.insets = new Insets(0, 0, 5, 5);
            gbc_lblBarCode.gridx = 0;
            gbc_lblBarCode.gridy = 4;
            contentPanel.add(lblBarCode, gbc_lblBarCode);
        }
        {
            txtFieldBarcode = new JTextField();
            GridBagConstraints gbc_txtFieldBarcode = new GridBagConstraints();
            gbc_txtFieldBarcode.insets = new Insets(0, 0, 5, 0);
            gbc_txtFieldBarcode.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtFieldBarcode.gridx = 1;
            gbc_txtFieldBarcode.gridy = 4;
            contentPanel.add(txtFieldBarcode, gbc_txtFieldBarcode);
            txtFieldBarcode.setColumns(10);
        }
        {
            JLabel lblDescription = new JLabel("Beskrivelse:");
            GridBagConstraints gbc_lblDescription = new GridBagConstraints();
            gbc_lblDescription.anchor = GridBagConstraints.EAST;
            gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
            gbc_lblDescription.gridx = 0;
            gbc_lblDescription.gridy = 5;
            contentPanel.add(lblDescription, gbc_lblDescription);
        }
        {
            txtFieldDescription = new JTextField();
            GridBagConstraints gbc_txtFieldDescription = new GridBagConstraints();
            gbc_txtFieldDescription.insets = new Insets(0, 0, 5, 0);
            gbc_txtFieldDescription.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtFieldDescription.gridx = 1;
            gbc_txtFieldDescription.gridy = 5;
            contentPanel.add(txtFieldDescription, gbc_txtFieldDescription);
            txtFieldDescription.setColumns(10);
        }


        {

            JPanel buttonPane = new JPanel();
            buttonPane.setBorder(new EmptyBorder(0, 0, 5, 5));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            JButton cancelButton = new JButton("Anuller");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancelClicked();
                }
            });
            JButton okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    okClicked(new Location("here h", "address"));
                    printAllProducts();
                }
            });
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
            {
                lblErrorLabelCCW = new JLabel("");
                lblErrorLabelCCW.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
                lblErrorLabelCCW.setForeground(new Color(205, 0, 0));
                buttonPane.add(lblErrorLabelCCW);
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setHgap(4);
                flowLayout.setVgap(0);
                buttonPane.add(panel);
            }
            okButton.setActionCommand("OK");
            {
                getRootPane().setDefaultButton(okButton);
                buttonPane.add(okButton);
            }
            {
                JPanel panel = new JPanel();
                FlowLayout flowLayout = (FlowLayout) panel.getLayout();
                flowLayout.setHgap(2);
                flowLayout.setVgap(0);
                buttonPane.add(panel);
            }
            cancelButton.setActionCommand("Anuller");
            {
                buttonPane.add(cancelButton);
            }
        }
    }


    public boolean isOkClicked() {
        return okClicked;
    }

    private void okClicked(Location location) {
        okClicked = true;

        if (txtFieldName.getText().isEmpty() || txtFieldQuantity.getText().isEmpty() || txtFieldPrice.getText().isEmpty() || txtFieldDiscount.getText().isEmpty()) {
            lblErrorLabelCCW.setText("Udfyld alle felter!");
        } else {
            double purchasePriceAsString = Integer.parseInt(txtFieldPrice.getText().trim());
            double priceValue = Double.parseDouble(txtFieldPrice.getText().trim());
            int quantityValue = Integer.parseInt(txtFieldQuantity.getText().trim());
            double discountValue = Double.parseDouble(txtFieldDiscount.getText().trim());


////
//			        // Use the converted purchasePriceAsString
            product = productCtrl.createShelfProduct(
                    txtFieldName.getText(),
                    txtFieldBarcode.getText(),
                    txtFieldDescription.getText(),
                    0.0d, //Insert purchase price
                    priceValue,
                    discountValue / 100,
                    LocalDateTime.now()
            );
            int quantity;
            //TODO: add min and max quantity to this
			productCtrl.createShelfStock(product, quantityValue);
            
            setVisible(false);
            dispose();
           

        }
    }

    public Customer getCustomer() {
        return customer;
    }

    private void cancelClicked() {
        okClicked = false;
        setVisible(false);
    }

    public String getName() {
        return txtFieldName.getText();
    }

    public String getQuantity() {
        return txtFieldQuantity.getText();
    }

    public String getPrice() {
        return txtFieldPrice.getText();
    }

    public String getDiscount() {
        return txtFieldDiscount.getText();
    }
    private void printAllProducts() {
        System.out.println(ProductContainer.getInstance().getProducts());
    }
}

