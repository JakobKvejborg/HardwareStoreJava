package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import controller.ProductCtrl;
import model.AbstractProduct;
import model.Employee;
import model.LendableIF;
import model.Location;
import model.ProductContainer;
import model.SaleOrderLine;
import model.SellableIF;
import model.SemiLeaseableIF;
import model.SemiLendableIF;
import model.SemiSellableIF;
import model.LendableIF;
import model.LeaseableIF;
import java.lang.NumberFormatException;

import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.ListSelectionModel;

public class ProductsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textBarcode;
	private JTable table;
	private JButton btnBarcodeEnter;
	public ProductTable productTable;
	private static String[] COL_NAMES = { "Vare", "Antal", "Indkøbspris", "Stregkode", "Salgspris", "Salgsrabat",
			"Lånepris", "Lånerabat", "Leasepris", "Leaserabat", "Fjern" };
	private ProductCtrl productCtrl;
	private JTextPane txtpnProductDescription;
	private JLabel lblProductLabel;
	private Employee employeee;
	private Location location;

	private class ProductTable extends AbstractTableModel {

		/**
		 * 
		 */
		private ArrayList<AbstractProduct> products;

		public ProductTable(ArrayList<AbstractProduct> products) {
			if (products == null) {
				products = new ArrayList<>();
			}
			this.products = products;
		}

		@Override
		public String getColumnName(int col) {
			return COL_NAMES[col];
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return ProductContainer.getInstance().getProducts().size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return COL_NAMES.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			AbstractProduct product = products.get(rowIndex);
			Object res = null;
			switch (columnIndex) {
			case 0:
				res = product.getName();
				break;
			case 1:
				res = product.getStock(location);
				break;
			case 2:
				res = product.getPurchasePrice();
				break;
			case 3:
				res = product.getBarcode();
				break;
			case 4:
				if (product instanceof SemiSellableIF) {
					SemiSellableIF sellableProduct = (SemiSellableIF) product;
					res = sellableProduct.getOriginalSalePrice(LocalDateTime.now());
				}
				break;
			case 5:
				if (product instanceof SemiSellableIF) {
					SemiSellableIF sellableProduct = (SemiSellableIF) product;
					res = sellableProduct.getSaleDiscount(LocalDateTime.now()) * 100 + "%";
				}
				break;
			case 6:
				if (product instanceof SemiLendableIF) {
					SemiLendableIF lendableProduct = (SemiLendableIF) product;
					res = lendableProduct.getOriginalLoanPrice(LocalDateTime.now());
				}
				break;
			case 7:
				if (product instanceof SemiLendableIF) {
					SemiLendableIF lendableProduct = (SemiLendableIF) product;
					res = lendableProduct.getLoanDiscount(LocalDateTime.now()) * 100 + "%";
				}
				break;
			case 8:
				if (product instanceof SemiLeaseableIF) {
					SemiLeaseableIF leaseableProduct = (SemiLeaseableIF) product;
					res = leaseableProduct.getOriginalLeasePrice(LocalDateTime.now());
				}
				break;
			case 9:
				if (product instanceof SemiLeaseableIF) {
					SemiLeaseableIF leaseableProduct = (SemiLeaseableIF) product;
					res = leaseableProduct.getLeaseDiscount(LocalDateTime.now()) * 100 + "%";
				}
				break;
			case 10:
				res = "<html><font face='Times New Roman' size='4' color='red'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;x</font></html>";
				break;
			default:
				res = null;
				break;
			}
			return res;
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			switch (column) {
			// Name
			case 0:
				return true;
			// Amount
			case 1:
				// TODO: implement editing of stock
				return false;
			// Purchase Price
			case 2:
				return true;
			// Barcode
			case 3:
				return true;
			// Sale Price
			case 4:
				return products.get(row) instanceof SemiSellableIF;
			// Sale Discount
			case 5:
				return products.get(row) instanceof SemiSellableIF;
			// Loan Price
			case 6:
				return products.get(row) instanceof SemiLendableIF;
			// Loan Discount
			case 7:
				return products.get(row) instanceof SemiLendableIF;
			// Lease Price
			case 8:
				return products.get(row) instanceof SemiLeaseableIF;
			// Lease Discount
			case 9:
				return products.get(row) instanceof SemiLeaseableIF;
			// Remmove
			case 10:
				return false;
			default:
				return false;
			}
		}

		@Override
		public void setValueAt(Object value, int rowIndex, int columnIndex) {
			AbstractProduct product = products.get(rowIndex);
			switch (columnIndex) {
			// Name
			case 0:
				product.setName(value.toString());
				break;
			// amount
			case 1:
				// TODO: make this work
				break;
			// Purchase Price
			case 2:
				try {
					double newPurchasePrice = Double.parseDouble(value.toString());
					product.setPurchasePrice(newPurchasePrice);
				}
				// TODO tell user the error
				catch (NumberFormatException e) {
				}
				break;

			// Barcode
			case 3:
				try {
					// TODO: do this better, check if it's only numbers instead of an int
					int newBarcode = Integer.parseInt(value.toString());
					String newBarcodeString = String.valueOf(newBarcode);
					product.setBarcode(rowIndex, newBarcodeString);
				}
				// TODO tell user the error
				catch (NumberFormatException e) {
				}
				break;
			// Sale Price
			case 4:
				try {
					if (products.get(rowIndex) instanceof SemiSellableIF) {
					double newPurchasePrice = Double.parseDouble(value.toString());
					SemiSellableIF semiSellableProduct = (SemiSellableIF) product;
					//semiSellableProduct.setSalePrice(newPurchasePrice);
					}
				}
				// TODO tell user the error
				catch (NumberFormatException e) {
				}
				break;
			default:
				break;
		}

		fireTableCellUpdated(rowIndex, columnIndex);

		}

		public void setData(ArrayList<AbstractProduct> products) {
			if (products == null) {
				products = new ArrayList<>();
			}
			this.products = products;
			super.fireTableDataChanged();
		}

	}

	/**
	 * Create the panel.
	 */
	public ProductsPanel(Employee employee, Location location) {

		this.employeee = employee;
		this.location = location;

		ProductCtrl productCtrl = new ProductCtrl(employee, location); // maybe wrong

		setBorder(new EmptyBorder(10, 10, 35, 10));
		setLayout(new BorderLayout(0, 0));
		setVisible(true);

		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		textBarcode = new JTextField();
		panel_1.add(textBarcode, BorderLayout.CENTER);
		textBarcode.setText("Indtast stregkode");

		panel_1.add(textBarcode, BorderLayout.CENTER);
		textBarcode.setColumns(10);
		textBarcode.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
//                if (e.getKeyCode() == 10) {
				barcodeEntered();
//                }
			}
		});

		btnBarcodeEnter = new JButton("Enter");
		btnBarcodeEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productTable.setData(ProductContainer.getInstance().getProducts());
				barcodeEntered();
			}
		});
		panel_1.add(btnBarcodeEnter, BorderLayout.EAST);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 108, 85, 85, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 21, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JButton btnAddProduct = new JButton("Tilføj nyt produkt      ");
		btnAddProduct.setToolTipText(" ");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProductButton();

			}
		});
		GridBagConstraints gbc_btnAddProduct = new GridBagConstraints();
		gbc_btnAddProduct.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddProduct.gridx = 0;
		gbc_btnAddProduct.gridy = 0;
		panel_2.add(btnAddProduct, gbc_btnAddProduct);

		// Shortcut ctrl + 1 to open CreateProductWindow
		KeyStroke ctrl1 = KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK);
		btnAddProduct.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ctrl1, "addProductButton");
		btnAddProduct.getActionMap().put("addProductButton", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addProductButton();
			}
		});

		JButton btnAddLoanProduct = new JButton("Tilføj udlånsprodukt");
		GridBagConstraints gbc_btnAddLoanProduct = new GridBagConstraints();
		gbc_btnAddLoanProduct.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddLoanProduct.gridx = 1;
		gbc_btnAddLoanProduct.gridy = 0;
		panel_2.add(btnAddLoanProduct, gbc_btnAddLoanProduct);

		JButton btnAddLeasingProduct = new JButton("Tilføj leasingprodukt");
		GridBagConstraints gbc_btnAddLeasingProduct = new GridBagConstraints();
		gbc_btnAddLeasingProduct.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddLeasingProduct.gridx = 2;
		gbc_btnAddLeasingProduct.gridy = 0;
		panel_2.add(btnAddLeasingProduct, gbc_btnAddLeasingProduct);

		JButton btnAddUniqueProduct = new JButton("Tilføj garantiprodukt");
		GridBagConstraints gbc_btnAddUniqueProduct = new GridBagConstraints();
		gbc_btnAddUniqueProduct.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddUniqueProduct.gridx = 0;
		gbc_btnAddUniqueProduct.gridy = 1;
		panel_2.add(btnAddUniqueProduct, gbc_btnAddUniqueProduct);

		JButton btnAddCompositeProduct = new JButton("Tilføj produktpakke  ");
		GridBagConstraints gbc_btnAddCompositeProduct = new GridBagConstraints();
		gbc_btnAddCompositeProduct.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddCompositeProduct.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAddCompositeProduct.gridx = 1;
		gbc_btnAddCompositeProduct.gridy = 1;
		panel_2.add(btnAddCompositeProduct, gbc_btnAddCompositeProduct);

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		productTable = new ProductTable(ProductContainer.getInstance().getProducts());
		table = new JTable(productTable);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(productTable);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (table.getSelectedRow() != -1) {
					int selectedRowIndex = table.getSelectedRow();
					AbstractProduct selectedProduct = productTable.products.get(selectedRowIndex);
					setProductInfo(selectedProduct);

				}

			}
		});

		JPanel panel_4 = new JPanel();
		splitPane.setRightComponent(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		lblProductLabel = new JLabel("Produkt");
		lblProductLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblProductLabel, BorderLayout.NORTH);

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1, BorderLayout.CENTER);

		txtpnProductDescription = new JTextPane();
		txtpnProductDescription.setText("Varens beskrivelse her.");
		txtpnProductDescription.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtpnProductDescription.setEditable(true);
		scrollPane_1.setViewportView(txtpnProductDescription);

		textBarcode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (!textBarcode.getText().isEmpty()) {
					textBarcode.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textBarcode.getText().isEmpty()) {
					textBarcode.setText("Indtast stregkode");
				}
			}
		});

	}

	private void barcodeEntered() {
		String barcode = textBarcode.getText().trim();

		if (!barcode.isEmpty()) {
			ArrayList<AbstractProduct> products = ProductContainer.getInstance().getProducts();
			AbstractProduct productFound = null;

			for (AbstractProduct product : products) {
				if (product.getBarcode().startsWith(barcode)) { // startsWith, contains, equals
					productFound = product;
					break;
				}
			}

			if (productFound != null) {

				// updates the description to match the found product
				String productFoundDescription = productFound.getDescription();
				txtpnProductDescription.setText(productFoundDescription);
				lblProductLabel.setText(productFound.getName());

				products.remove(productFound);
				products.add(0, productFound);
				productTable.setData(products);
				table.scrollRectToVisible(table.getCellRect(0, 0, true));
			}

		}
	}

	private void setProductInfo(AbstractProduct product) {
		if (product != null) {
			txtpnProductDescription.setText(product.getDescription());
			lblProductLabel.setText(product.getName());
		}
	}

	private void addProductButton() {
		textBarcode.setText("Indtast stregkode");
		CreateProductWindow createProductWindow = new CreateProductWindow(productCtrl, ProductContainer.getInstance());
		createProductWindow.setVisible(true);
	}

}