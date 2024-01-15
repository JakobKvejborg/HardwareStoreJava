package gui;

import controller.CustomerCtrl;
import controller.SaleCtrl;
import model.Customer;
import model.Employee;
import model.Location;
import model.Sale;
import model.SaleOrderLine;
import model.SellableIF;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Julia Rafn
 * @author Jakob Kvejborg
 * @author Patrick
 * @author Penrose
 * @author Jonas Glintborg
 * @author Majbritt
 * @version 12/01/2024
 * @since 10/01/2024
 */

public class SaleMenuPanel extends JPanel {

	private Employee employee;
	private Location location;
	private SaleCtrl saleCtrl;
	private Sale sale;
	private SaleTable saleTableModel;
	private JLabel lblTotalPrice;
	private CustomerCtrl customerCtrl;

	private static final long serialVersionUID = 1L;
	private JTextField txtFindCustomer;
	private JTable tableSale;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textAddress;
	private JTextField textEmail;
	private JLabel lblCustomerDiscount;
	private JLabel lblTotal;
	private JTextField textStock;
	private JTextField textPrice;
	private JTextField textBarcode;
	private JTextField textTotalPrice;
	private JButton btnCheckout;
	private JButton btnCancel;
	private JButton btnCreateCustomer;
	private JButton btnBarcodeEnter;
	private JTextField textDiscountPercentage;
	private JTextPane txtpnProductDescription;

	private class SaleTable extends AbstractTableModel {

		private static final String[] COL_NAMES = { "Vare", "Antal", "Styk pris", "Total Pris", "Fjern" };
		private Sale sale;

		public SaleTable(Sale sale) {
			if (sale == null) {
				sale = new Sale(null);
			}
			this.sale = sale;

		}

		public void setData(Sale sale) {
			this.sale = sale;
			super.fireTableDataChanged();
		}

		@Override
		public String getColumnName(int col) {
			return COL_NAMES[col];
		}

		@Override
		public int getRowCount() {
			return sale.getSaleOrderLinesSize();
		}

		@Override
		public int getColumnCount() {
			return 5;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Object res = null;
			SaleOrderLine saleOrderLine = sale.getSaleOrderLine(rowIndex);
			switch (columnIndex) {
			case 0:
				res = saleOrderLine.getProduct().getName();
				break;
			case 1:
				res = saleOrderLine.getQuantity();
				break;
			case 2:
				res = saleOrderLine.getPrice(LocalDateTime.now());
				break;
			case 3:
				res = saleOrderLine.getPrice(LocalDateTime.now()) * saleOrderLine.getQuantity();
				break;
			case 4:
				res = "-";
				break;
			default:
				res = "<UNKNOWN " + columnIndex + ">";
			}
			return res;
		}

	}

	/**
	 * Create the panel.
	 */
	public SaleMenuPanel(Employee employee, Location location) {
		this.employee = employee;
		this.location = location;
		saleCtrl = new SaleCtrl(employee, location);
		sale = saleCtrl.makeSale();
		createLayout();
	}

	private void createLayout() {
		setBorder(new EmptyBorder(10, 10, 10, 10));

		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPaneSale = new JSplitPane();
		add(splitPaneSale, BorderLayout.CENTER);

		JPanel panelSaleNorthWest = new JPanel();
		splitPaneSale.setLeftComponent(panelSaleNorthWest);
		panelSaleNorthWest.setLayout(new BorderLayout(0, 0));

		JPanel panelNorthWest = new JPanel();
		panelSaleNorthWest.add(panelNorthWest, BorderLayout.NORTH);
		panelNorthWest.setLayout(new BorderLayout(0, 0));

		JPanel panelBarcode = new JPanel();
		panelNorthWest.add(panelBarcode, BorderLayout.SOUTH);
		panelBarcode.setLayout(new BorderLayout(0, 0));

		textBarcode = new JTextField();
		textBarcode.setColumns(10);
		panelBarcode.add(textBarcode);
		textBarcode.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					barcodeEntered();
				}
			}
		});
		btnBarcodeEnter = new JButton("Enter");
		panelBarcode.add(btnBarcodeEnter, BorderLayout.EAST);
		btnBarcodeEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				barcodeEntered();
			}
		});

		JPanel panelWestCenter = new JPanel();
		panelSaleNorthWest.add(panelWestCenter, BorderLayout.CENTER);
		panelWestCenter.setLayout(new BorderLayout(0, 0));

		JPanel panelCenterSouthWest = new JPanel();
		panelWestCenter.add(panelCenterSouthWest, BorderLayout.SOUTH);
		GridBagLayout gbl_panelCenterSouthWest = new GridBagLayout();
		gbl_panelCenterSouthWest.columnWidths = new int[] { 0, 85, 0 };
		gbl_panelCenterSouthWest.rowHeights = new int[] { 0, 0, 28, 0 };
		gbl_panelCenterSouthWest.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelCenterSouthWest.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelCenterSouthWest.setLayout(gbl_panelCenterSouthWest);

		txtFindCustomer = new JTextField();
		txtFindCustomer.setText("Indtast tlf.nr.");
		txtFindCustomer.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (!txtFindCustomer.getText().isEmpty()) {
					txtFindCustomer.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtFindCustomer.getText().isEmpty()) {
					txtFindCustomer.setText("Indtast tlf.nr.");
				}
			}
		});
		txtFindCustomer.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					Customer customer = saleCtrl.setCustomer(txtFindCustomer.getText());
					textName.setText(customer.getName());
					textAddress.setText(customer.getAddress());
					textPhone.setText(customer.getPhone());
					textEmail.setText(customer.getEmail());
					txtFindCustomer.setText("");
				}
			}
		});
		
		GridBagConstraints gbc_txtFindCustomer = new GridBagConstraints();
		gbc_txtFindCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_txtFindCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFindCustomer.gridx = 0;
		gbc_txtFindCustomer.gridy = 0;
		panelCenterSouthWest.add(txtFindCustomer, gbc_txtFindCustomer);
		txtFindCustomer.setColumns(10);

		btnCreateCustomer = new JButton("Opret ny kunde");
		GridBagConstraints gbc_btnCreateCustomer = new GridBagConstraints();
		gbc_btnCreateCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateCustomer.gridx = 1;
		gbc_btnCreateCustomer.gridy = 0;
		panelCenterSouthWest.add(btnCreateCustomer, gbc_btnCreateCustomer);

		btnCreateCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateCustomerWindow customerWindow = new CreateCustomerWindow(customerCtrl);
				customerWindow.setVisible(true);

				if (customerWindow.isOkClicked()) {

					String name = customerWindow.getName();
					String address = customerWindow.getAddress();
					String phone = customerWindow.getPhone();
					String email = customerWindow.getEmail();

					textName.setText(name);
					textAddress.setText(address);
					textPhone.setText(phone);
					textEmail.setText(email);
				}
			}
		});

		textName = new JTextField();
		textName.setText("Navn");
		textName.setEditable(false);
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.gridx = 0;
		gbc_textName.gridy = 1;
		panelCenterSouthWest.add(textName, gbc_textName);
		textName.setColumns(10);

		textAddress = new JTextField();
		textAddress.setText("Addresse");
		textAddress.setEditable(false);
		GridBagConstraints gbc_textAddress = new GridBagConstraints();
		gbc_textAddress.insets = new Insets(0, 0, 5, 0);
		gbc_textAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAddress.gridx = 1;
		gbc_textAddress.gridy = 1;
		panelCenterSouthWest.add(textAddress, gbc_textAddress);
		textAddress.setColumns(10);

		textPhone = new JTextField();
		textPhone.setText("Telefon Nummer");
		textPhone.setEditable(false);
		GridBagConstraints gbc_textPhone = new GridBagConstraints();
		gbc_textPhone.insets = new Insets(0, 0, 0, 5);
		gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPhone.gridx = 0;
		gbc_textPhone.gridy = 2;
		panelCenterSouthWest.add(textPhone, gbc_textPhone);
		textPhone.setColumns(10);

		textEmail = new JTextField();
		textEmail.setText("Email");
		textEmail.setEditable(false);
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 2;
		panelCenterSouthWest.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);

		JPanel panelCenterNorthWest = new JPanel();
		panelWestCenter.add(panelCenterNorthWest, BorderLayout.CENTER);
		panelCenterNorthWest.setLayout(new BorderLayout(0, 0));

		JPanel panelPriceCal = new JPanel();
		panelCenterNorthWest.add(panelPriceCal, BorderLayout.SOUTH);
		GridBagLayout gbl_panelPriceCal = new GridBagLayout();
		gbl_panelPriceCal.columnWidths = new int[] { 79, 59, 62, 93, 0 };
		gbl_panelPriceCal.rowHeights = new int[] { 0, 0 };
		gbl_panelPriceCal.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelPriceCal.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelPriceCal.setLayout(gbl_panelPriceCal);

		lblCustomerDiscount = new JLabel();
		lblCustomerDiscount.setText("Kunde Rabat:");
		GridBagConstraints gbc_lblCustomerDiscount = new GridBagConstraints();
		gbc_lblCustomerDiscount.anchor = GridBagConstraints.EAST;
		gbc_lblCustomerDiscount.insets = new Insets(0, 0, 0, 5);
		gbc_lblCustomerDiscount.gridx = 0;
		gbc_lblCustomerDiscount.gridy = 0;
		panelPriceCal.add(lblCustomerDiscount, gbc_lblCustomerDiscount);

		textDiscountPercentage = new JTextField();
		textDiscountPercentage.setEditable(false);
		textDiscountPercentage.setColumns(10);
		GridBagConstraints gbc_textDiscountPercentage = new GridBagConstraints();
		gbc_textDiscountPercentage.insets = new Insets(0, 0, 0, 5);
		gbc_textDiscountPercentage.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDiscountPercentage.gridx = 1;
		gbc_textDiscountPercentage.gridy = 0;
		panelPriceCal.add(textDiscountPercentage, gbc_textDiscountPercentage);

		lblTotal = new JLabel();
		lblTotal.setText("Total:");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.gridx = 2;
		gbc_lblTotal.gridy = 0;
		panelPriceCal.add(lblTotal, gbc_lblTotal);

		textTotalPrice = new JTextField();
		textTotalPrice.setEditable(false);
		textTotalPrice.setColumns(10);
		GridBagConstraints gbc_textTotalPrice = new GridBagConstraints();
		gbc_textTotalPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTotalPrice.gridx = 3;
		gbc_textTotalPrice.gridy = 0;
		panelPriceCal.add(textTotalPrice, gbc_textTotalPrice);

		JScrollPane scrollPaneSale = new JScrollPane();
		panelCenterNorthWest.add(scrollPaneSale, BorderLayout.CENTER);

		tableSale = new JTable(50, 5);
		/*
		 * tableSale.setModel(new DefaultTableModel( new Object[][]{ // {null, null,
		 * null, null}, // x50 ned af }, new String[]{ "Indk\u00F8bskurv", "Antal",
		 * "Pris", "Fjern" } ));
		 */
		saleTableModel = new SaleTable(saleCtrl.getSale());
		tableSale.setModel(saleTableModel);

		scrollPaneSale.setViewportView(tableSale);

		JPanel panelDescription = new JPanel();
		splitPaneSale.setRightComponent(panelDescription);
		panelDescription.setLayout(new BorderLayout(0, 0));

		JLabel lblProductName = new JLabel("Varens navn her");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		panelDescription.add(lblProductName, BorderLayout.NORTH);

		JSplitPane splitPaneDescription = new JSplitPane();
		panelDescription.add(splitPaneDescription, BorderLayout.CENTER);

		JScrollPane scrollPaneDescription = new JScrollPane();
		splitPaneDescription.setRightComponent(scrollPaneDescription);

		txtpnProductDescription = new JTextPane();
		txtpnProductDescription.setEditable(false);
		txtpnProductDescription.setText(
				"Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. ");
		scrollPaneDescription.setViewportView(txtpnProductDescription);

		JPanel panelDescriptionSideBar = new JPanel();
		splitPaneDescription.setLeftComponent(panelDescriptionSideBar);
		GridBagLayout gbl_panelDescriptionSideBar = new GridBagLayout();
		gbl_panelDescriptionSideBar.columnWidths = new int[] { 0, 0 };
		gbl_panelDescriptionSideBar.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelDescriptionSideBar.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelDescriptionSideBar.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panelDescriptionSideBar.setLayout(gbl_panelDescriptionSideBar);

		JLabel lblPrice = new JLabel("(Lager antal)");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 0;
		panelDescriptionSideBar.add(lblPrice, gbc_lblPrice);

		textStock = new JTextField();
		textStock.setEditable(false);
		GridBagConstraints gbc_textStock = new GridBagConstraints();
		gbc_textStock.insets = new Insets(0, 0, 5, 0);
		gbc_textStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_textStock.gridx = 0;
		gbc_textStock.gridy = 1;
		panelDescriptionSideBar.add(textStock, gbc_textStock);
		textStock.setColumns(10);

//        JLabel lblStock = new JLabel("(Pris m/ rabat)");
//        GridBagConstraints gbc_lblStock = new GridBagConstraints();
//        gbc_lblStock.insets = new Insets(0, 0, 5, 0);
//        gbc_lblStock.gridx = 0;
//        gbc_lblStock.gridy = 2;
//        panelDescriptionSideBar.add(lblStock, gbc_lblStock);
//
//        textPrice = new JTextField();
//        textPrice.setEditable(false);
//        GridBagConstraints gbc_textPrice = new GridBagConstraints();
//        gbc_textPrice.insets = new Insets(0, 0, 5, 0);
//        gbc_textPrice.fill = GridBagConstraints.HORIZONTAL;
//        gbc_textPrice.gridx = 0;
//        gbc_textPrice.gridy = 3;
//        panelDescriptionSideBar.add(textPrice, gbc_textPrice);
//        textPrice.setColumns(10);

		JPanel panelSaleSouth = new JPanel();
		add(panelSaleSouth, BorderLayout.SOUTH);
		panelSaleSouth.setLayout(new BorderLayout(0, 0));

		JPanel panelSaleGridSouth = new JPanel();
		panelSaleSouth.add(panelSaleGridSouth, BorderLayout.NORTH);
		GridBagLayout gbl_panelSaleGridSouth = new GridBagLayout();
		gbl_panelSaleGridSouth.columnWidths = new int[] { 80, 85, 85, 0 };
		gbl_panelSaleGridSouth.rowHeights = new int[] { 21, 0 };
		gbl_panelSaleGridSouth.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelSaleGridSouth.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panelSaleGridSouth.setLayout(gbl_panelSaleGridSouth);

		btnCheckout = new JButton("Færdiggør");
		GridBagConstraints gbc_btnCheckout = new GridBagConstraints();
		gbc_btnCheckout.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCheckout.insets = new Insets(0, 0, 0, 5);
		gbc_btnCheckout.gridx = 0;
		gbc_btnCheckout.gridy = 0;
		panelSaleGridSouth.add(btnCheckout, gbc_btnCheckout);
		btnCheckout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String paymentInput = JOptionPane.showInputDialog("Indtast betaling:");
				double payment;
				payment = Double.parseDouble(paymentInput);
				sale = saleCtrl.completeSale(payment);
				String totalPrice = "Betalt: " + payment + "kr Tilbage: " + (payment - sale.getPrice()) + "kr";
				showTotalPrice(totalPrice);
				textTotalPrice.setText(sale.getPrice() + "kr");
				// TODO reset JTable slet alle produkter fra indkøbskurven osv.
			}
		});

		btnCancel = new JButton("Afbryd");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 0;
		panelSaleGridSouth.add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableSale.getModel();
				for (int i = 0; i < model.getRowCount(); i++) {
					model.removeRow(i);
				}
			}
		});
		lblTotalPrice = new JLabel();
		GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
		gbc_lblTotalPrice.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalPrice.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTotalPrice.gridx = 10;
		gbc_lblTotalPrice.gridy = 0; //
		panelSaleGridSouth.add(lblTotalPrice, gbc_lblTotalPrice);

	}

	/**
	 * This method sets the label in the right bottom corner to the total price
	 *
	 * @param totalPrice
	 */

	/*private void setProductDescription(JTextPane txtpnProductDescription) {

        lblTotalPrice = new JLabel();
        GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
        gbc_lblTotalPrice.insets = new Insets(0, 0, 0, 5);
        gbc_lblTotalPrice.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblTotalPrice.gridx = 10;
        gbc_lblTotalPrice.gridy = 0; //
        //Sorry, can't make this work rn, no idea what this code does - Penrose
        //panelSaleGridSouth.add(lblTotalPrice, gbc_lblTotalPrice);

		lblTotalPrice = new JLabel();
		GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
		gbc_lblTotalPrice.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalPrice.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTotalPrice.gridx = 10;
		gbc_lblTotalPrice.gridy = 0; //
		// Sorry, can't make this work rn - Penrose
		// panelSaleGridSouth.add(lblTotalPrice, gbc_lblTotalPrice);

	}*/

	private void barcodeEntered() {
		String barcode = textBarcode.getText();
		SellableIF product = saleCtrl.addProduct(barcode);


        saleTableModel.setData(saleCtrl.getSale());
        
        //DefaultTableModel model = (DefaultTableModel) tableSale.getModel();
        //model.addRow(new Object[]{product.getName(), 1, product.getPrice(LocalDateTime.now()), "???"});
        //setProductDescription(txtpnProductDescription);

		saleTableModel.setData(saleCtrl.getSale());

		// DefaultTableModel model = (DefaultTableModel) tableSale.getModel();
		// model.addRow(new Object[]{product.getName(), 1,
		// product.getPrice(LocalDateTime.now()), "???"});
		//setProductDescription(txtpnProductDescription);
	}


	/**
	 * This method sets the label in the right bottom corner to the total price
	 *
	 * @param totalPrice
	 */
	private void showTotalPrice(String totalPrice) {
		lblTotalPrice.setText(totalPrice);
	}

}
