package gui;

import controller.CustomerCtrl;
import controller.SaleCtrl;
import model.Customer;
import model.CustomerGroup;
import model.Employee;
import model.Location;
import model.Sale;
import model.SaleOrderLine;
import model.SellableIF;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

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
	private static String[] COL_NAMES = { "Vare", "Antal", "Styk pris", "Total Pris", "Fjern" };

	private static final long serialVersionUID = 1L;
	private JTextField txtFindCustomer;
	private JTable tableSale;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textAddress;
	private JTextField textEmail;
	private JLabel lblCustomerDiscount;
	private JLabel lblTotal;
	private JTextField textBarcode;
	private JTextField textTotalPrice;
	private JButton btnCheckout;
	private JButton btnCancel;
	private JButton btnBarcodeEnter;
	private JTextField textDiscountPercentage;
	private JTextPane txtpnProductDescription;
	private JTextField textStock;
	private JTextField textPrice;
	private JLabel lblProductName;
	private JSplitPane splitPane;
	private JButton btnCreateCustomer;
	private JButton btnFindCustomer;
	private Color yellow = new Color(255, 255, 200);
	private JLabel lblDiscountedPrice;
	private JTextField textDiscountedPrice;
	private JTextField textDiscount;
	private JLabel lblDiscount;

	private class SaleTable extends AbstractTableModel {

		private Sale sale;

		public SaleTable(Sale sale) {
			if (sale == null) {
				sale = new Sale(null);
			}
			this.sale = sale;

		}

		public void setData(Sale sale) {
			if (sale == null) {
				sale = new Sale(null);
			}
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

		public SellableIF getProduct(int row) {
			return sale.getSaleOrderLine(row).getProduct();
		}

		public SaleOrderLine getSaleOrderLine(int row) {
			return sale.getSaleOrderLine(row);
		}

		public String getDescription(int row) {
			return sale.getSaleOrderLine(row).getProduct().getDescription();
		}

		public double getPriceText(int row) {
			return sale.getSaleOrderLine(row).getProduct().getSalePrice(LocalDateTime.now());
		}

		public int getStockText(int row) {
			return sale.getSaleOrderLine(row).getProduct().getStock(location);
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
				res = saleOrderLine.getProduct().getSalePrice(LocalDateTime.now());
				break;
			case 3:
				res = saleOrderLine.getPrice(LocalDateTime.now());
				break;
			case 4:
				res = "<html><font face='Times New Roman' size='4' color='red'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;x</font></html>";
				break;
			default:
				res = "<UNKNOWN " + columnIndex + ">";
			}
			return res;
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 1 && !sale.getSaleOrderLine(row).getProduct().isUnique();
		}

		@Override
		public void setValueAt(Object value, int rowIndex, int columnIndex) {
			if (columnIndex == 1) {
				try {
					int quantity = Integer.parseInt(value.toString());
					saleCtrl.setQuantity(rowIndex, quantity);
				} catch (Exception e) {
					System.out.println("please insert an integer value!");
				}
				updateData();

			}
		}

	}

	/**
	 * Create the panel.
	 */
	public SaleMenuPanel(Employee employee, Location location) {
		this.employee = employee;
		this.location = location;
		saleCtrl = new SaleCtrl(employee, location);
		customerCtrl = new CustomerCtrl();
		sale = saleCtrl.makeSale();
		createLayout();
		updateData();
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
		textBarcode.setText("Indtast stregkode");
		textBarcode.setColumns(10);
		panelBarcode.add(textBarcode);
		textBarcode.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					barcodeEntered();
				}
			}
		});
		btnBarcodeEnter = new JButton("Tilføj");
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
		panelCenterSouthWest.setBorder(new EmptyBorder(5, 0, 0, 0));
		panelWestCenter.add(panelCenterSouthWest, BorderLayout.SOUTH);
		GridBagLayout gbl_panelCenterSouthWest = new GridBagLayout();
		gbl_panelCenterSouthWest.columnWidths = new int[] { 161, 85, 0 };
		gbl_panelCenterSouthWest.rowHeights = new int[] { 0, 0, 28, 0, 0 };
		gbl_panelCenterSouthWest.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelCenterSouthWest.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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

		textBarcode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (!textBarcode.getText().isEmpty()) {
					textBarcode.setText("");
				}

				if (txtFindCustomer.getText().isEmpty()) {
					txtFindCustomer.setText("Indtast tlf.nr.");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textBarcode.getText().isEmpty()) {
					textBarcode.setText("Indtast stregkode");
				}
			}
		});

		txtFindCustomer.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					saleCtrl.setCustomer(txtFindCustomer.getText());
					updateData();
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

		splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 1;
		gbc_splitPane.gridy = 0;
		panelCenterSouthWest.add(splitPane, gbc_splitPane);

		btnFindCustomer = new JButton("      Find kunde      ");
		btnFindCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findCustomerButton();
			}
		});
		splitPane.setLeftComponent(btnFindCustomer);


		btnCreateCustomer = new JButton("Opret ny kunde");
		btnCreateCustomer.setToolTipText(" ");
		btnCreateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCustomerWindow();
			}
		});
		splitPane.setRightComponent(btnCreateCustomer);

		// Add keyboard shortcut (Ctrl + o) using InputMap and ActionMap
		KeyStroke ctrlO = KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK);
		btnCreateCustomer.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ctrlO, "createCustomerWindow");
		btnCreateCustomer.getActionMap().put("createCustomerWindow", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createCustomerWindow();
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
		textAddress.setText("Adresse");
		textAddress.setEditable(false);
		GridBagConstraints gbc_textAddress = new GridBagConstraints();
		gbc_textAddress.insets = new Insets(0, 0, 5, 0);
		gbc_textAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAddress.gridx = 1;
		gbc_textAddress.gridy = 1;
		panelCenterSouthWest.add(textAddress, gbc_textAddress);
		textAddress.setColumns(10);

		textPhone = new JTextField();
		textPhone.setText("Telefonnummer");
		textPhone.setEditable(false);
		GridBagConstraints gbc_textPhone = new GridBagConstraints();
		gbc_textPhone.insets = new Insets(0, 0, 5, 5);
		gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPhone.gridx = 0;
		gbc_textPhone.gridy = 2;
		panelCenterSouthWest.add(textPhone, gbc_textPhone);
		textPhone.setColumns(10);

		textEmail = new JTextField();
		textEmail.setText("Email");
		textEmail.setEditable(false);
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.insets = new Insets(0, 0, 5, 0);
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
		textDiscountPercentage.setText("0%");

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
		tableSale.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		saleTableModel = new SaleTable(saleCtrl.getSale());
		tableSale.setModel(saleTableModel);

		tableSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableSale.rowAtPoint(e.getPoint());
				int col = tableSale.columnAtPoint(e.getPoint());

				if (col == COL_NAMES.length - 1 && row != -1) {
					removeRow(row);
				}
			}
		});

		tableSale.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				// make sure that a row is selected
				if (tableSale.getSelectedRow() != -1) {

					SaleOrderLine product = saleTableModel.getSaleOrderLine(tableSale.getSelectedRow());
					setProductInfo(product);

				}

			}
		});

		scrollPaneSale.setViewportView(tableSale);

		JPanel panelDescription = new JPanel();
		splitPaneSale.setRightComponent(panelDescription);
		panelDescription.setLayout(new BorderLayout(0, 0));

		lblProductName = new JLabel("Produkt");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		panelDescription.add(lblProductName, BorderLayout.NORTH);

		JSplitPane splitPaneDescription = new JSplitPane();
		panelDescription.add(splitPaneDescription, BorderLayout.CENTER);

		JScrollPane scrollPaneDescription = new JScrollPane();
		splitPaneDescription.setRightComponent(scrollPaneDescription);

		txtpnProductDescription = new JTextPane();
		txtpnProductDescription.setEditable(false);
		txtpnProductDescription.setText("Varens beskrivelse her.");
		Font font = new Font("Times New Roman", Font.PLAIN, 20);
		txtpnProductDescription.setFont(font);
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

		JLabel lblStock = new JLabel("Lager antal");
		GridBagConstraints gbc_lblStock = new GridBagConstraints();
		gbc_lblStock.insets = new Insets(0, 0, 5, 0);
		gbc_lblStock.gridx = 0;
		gbc_lblStock.gridy = 0;
		panelDescriptionSideBar.add(lblStock, gbc_lblStock);

		textStock = new JTextField();
		textStock.setEditable(false);
		GridBagConstraints gbc_textStock = new GridBagConstraints();
		gbc_textStock.insets = new Insets(0, 0, 5, 0);
		gbc_textStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_textStock.gridx = 0;
		gbc_textStock.gridy = 1;
		panelDescriptionSideBar.add(textStock, gbc_textStock);
		textStock.setColumns(10);

		JLabel lblFullPrice = new JLabel("Pris");
		GridBagConstraints gbc_lblFullPrice = new GridBagConstraints();
		gbc_lblFullPrice.insets = new Insets(0, 0, 5, 0);
		gbc_lblFullPrice.gridx = 0;
		gbc_lblFullPrice.gridy = 2;
		panelDescriptionSideBar.add(lblFullPrice, gbc_lblFullPrice);

		textPrice = new JTextField();
		textPrice.setEditable(false);
		GridBagConstraints gbc_textPrice = new GridBagConstraints();
		gbc_textPrice.insets = new Insets(0, 0, 5, 0);
		gbc_textPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPrice.gridx = 0;
		gbc_textPrice.gridy = 3;
		panelDescriptionSideBar.add(textPrice, gbc_textPrice);
		textPrice.setColumns(10);

		lblDiscountedPrice = new JLabel("Pris med rabat");
		GridBagConstraints gbc_lblDiscountedPrice = new GridBagConstraints();
		gbc_lblDiscountedPrice.insets = new Insets(0, 0, 5, 0);
		gbc_lblDiscountedPrice.gridx = 0;
		gbc_lblDiscountedPrice.gridy = 4;
		panelDescriptionSideBar.add(lblDiscountedPrice, gbc_lblDiscountedPrice);

		textDiscountedPrice = new JTextField();
		textDiscountedPrice.setEditable(false);
		GridBagConstraints gbc_textDiscountedPrice = new GridBagConstraints();
		gbc_textDiscountedPrice.insets = new Insets(0, 0, 5, 0);
		gbc_textDiscountedPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDiscountedPrice.gridx = 0;
		gbc_textDiscountedPrice.gridy = 5;
		panelDescriptionSideBar.add(textDiscountedPrice, gbc_textDiscountedPrice);
		textDiscountedPrice.setColumns(10);

		lblDiscount = new JLabel("Rabat");
		lblDiscount.setToolTipText("");
		GridBagConstraints gbc_lblDiscount = new GridBagConstraints();
		gbc_lblDiscount.insets = new Insets(0, 0, 5, 0);
		gbc_lblDiscount.gridx = 0;
		gbc_lblDiscount.gridy = 6;
		panelDescriptionSideBar.add(lblDiscount, gbc_lblDiscount);

		textDiscount = new JTextField();
		textDiscount.setEditable(false);
		GridBagConstraints gbc_textDiscount = new GridBagConstraints();
		gbc_textDiscount.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDiscount.gridx = 0;
		gbc_textDiscount.gridy = 7;
		panelDescriptionSideBar.add(textDiscount, gbc_textDiscount);
		textDiscount.setColumns(10);

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
				checkoutClicked();
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
				cancelClicked();
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

	private void cancelClicked() {
		saleCtrl.clearSale();
		saleCtrl.makeSale();
		updateData();
		clearCheckout();

	}

	private void updateTable() {
		saleTableModel.setData(saleCtrl.getSale());
	}

	private void barcodeEntered() {

		clearTotalPrice();

		String barcode = textBarcode.getText();
		SaleOrderLine saleOrderLine = saleCtrl.addProduct(barcode);
		if (saleOrderLine != null) {
			updateData();
			setProductInfo(saleOrderLine);
		} else {
			System.out.println("Product not found or other issue");
		}
		textBarcode.setText("");
	}

	private void checkoutClicked() {
		String paymentInput = JOptionPane.showInputDialog("Indtast betaling:");
		double payment;
		payment = Double.parseDouble(paymentInput);
		sale = saleCtrl.completeSale(payment);
		String totalPrice = "Total: " + sale.getPrice() + " Betalt: " + payment + "kr Tilbage: "
				+ (payment - sale.getPrice()) + "kr";
		lblTotalPrice.setText(totalPrice);
		System.out.println(sale.getPrice());
		saleCtrl.makeSale();
		updateData();
		clearCheckout();
	}

	private void setProductInfo(SaleOrderLine saleOrderLine) {
		SellableIF product = saleOrderLine.getProduct();
		txtpnProductDescription.setText(product.getDescription());
		textPrice.setText(product.getOriginalSalePrice(LocalDateTime.now()) + "kr,-");
		textDiscountedPrice.setText(product.getSalePrice(LocalDateTime.now()) + "kr,-");
		textDiscount.setText((product.getSaleDiscount(LocalDateTime.now()) * 100 + "%"));
		lblProductName.setText(product.getName());
		textStock.setText(product.getStock(location) + " stk.");

	}

	private void setCustomerData(Customer customer) {
		textName.setText(customer.getName());
		textAddress.setText(customer.getAddress());
		textPhone.setText(customer.getPhone());
		textEmail.setText(customer.getEmail());
		textDiscountPercentage.setText(customer.getCustomerGroup().getMaxDiscount(LocalDateTime.now()) * 100 + "%");
	}

	private void clearCustomer() {
		Customer customer = saleCtrl.getSale().getCustomer();

		if (customer == null) {
			textName.setText("Navn");
			textAddress.setText("Adresse");
			textPhone.setText("Telefonnummer");
			textEmail.setText("Email");
			textDiscountPercentage
					.setText(CustomerGroup.getDefaultCustomerGroup().getMaxDiscount(LocalDateTime.now()) * 100 + "%");

		}
	}

	private void updateData() {
		Sale sale = saleCtrl.getSale();
		updateTable();
		textTotalPrice.setText(saleCtrl.getSale().getPrice() + "kr");
		if (sale.getCustomer() != null) {
			setCustomerData(sale.getCustomer());
		} else {
			clearCustomer();
		}
	}

	private void createCustomerWindow() {
		CreateCustomerWindow customerWindow = new CreateCustomerWindow(customerCtrl);
		customerWindow.setVisible(true);
		if (customerWindow.isOkClicked()) {
			saleCtrl.setCustomer(customerWindow.getPhone());
			updateData();
		}
	}

	private void clearCheckout() {
		updateData();
		textPrice.setText("");
		txtpnProductDescription.setText("Varens beskrivelse her.");
		lblProductName.setText("Produkt");
		textStock.setText("");
		textPrice.setText("");
		textDiscountedPrice.setText("");
		textDiscount.setText("");
	}

	private void clearTotalPrice() {
		textTotalPrice.setText("");
		lblTotalPrice.setText("");
	}

	private void removeRow(int row) {
		saleCtrl.removeProduct(row);
		clearCheckout();
	}
	
	private void findCustomerButton() {
		saleCtrl.setCustomer(txtFindCustomer.getText());
		updateData();
		txtFindCustomer.setText("");
	}

}
