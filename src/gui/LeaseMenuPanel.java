package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import controller.CustomerCtrl;
import controller.LeaseCtrl;
import controller.SaleCtrl;
import model.Customer;
import model.Employee;
import model.LeaseableIF;
import model.Location;
import model.Sale;
import model.SaleOrderLine;
import model.SellableIF;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LeaseMenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtFieldBarcode;
	private JTable tableLease;
	private JTextField textDiscountPercentage;
	private JTextField textTotalPrice;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textAddress;
	private JTextField textEmail;
	private JTextField textStock;
	private JTextField textPrice;
	private JTextField textFieldFromDate;
	private JTextField textFieldToDate;
	private JTextField textFieldLeaseDuration;
	private JTextField textFindCustomer;
	private JButton btnCheckout;
	private JButton btnCancel;
	private JButton btnCreateCustomer;
	private JButton btnBarcodeEnter;
	private LeaseTable leaseTableModel;
	private Employee employee;
	private Location location;
	private LeaseCtrl leaseCtrl;
	private static String[] COL_NAMES = {	"Vare", "Pris", "Fjern"};
	private JLabel lblTotalPrice;
	private JEditorPane dtrpnIItemDescription;
	private JTextField textDiscount;
	private JTextField textDiscountedPrice;
	private JLabel lblProductName;
	private CustomerCtrl customerCtrl;
	private JSplitPane splitPane;
	private JButton btnFindCustomer;

	private class LeaseTable extends AbstractTableModel {

    	private ArrayList<LeaseableIF> products;
    	
    	public LeaseTable(ArrayList<LeaseableIF> products) {
    		if(products == null) {
    			products = new ArrayList<>();
    		}
    		this.products = products;
    		
    	}
    	
    	public void setData(ArrayList<LeaseableIF> products) {
    		this.products = products;
    		super.fireTableDataChanged();
    	}
    	
    	@Override
    	public String getColumnName(int col) {
    		return COL_NAMES[col];
    	}
    	
		@Override
		public int getRowCount() {
			return products.size();
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Object res = null;
			LeaseableIF product = products.get(rowIndex);
			switch(columnIndex) {
				case 0:
					res = product.getName();
					break;
				case 1:
					res = product.getLeasePrice(LocalDateTime.now());
					break;
				case 2:
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
	public LeaseMenuPanel(Employee employee, Location location) {
        this.employee = employee;
        this.location = location;
        leaseCtrl = new LeaseCtrl(employee, location);
		createLayout();

	}


	private void createLayout() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPaneLease = new JSplitPane();
		add(splitPaneLease, BorderLayout.CENTER);
		
		JPanel panelFinalButtons = new JPanel();
		panelFinalButtons.setBorder(null);
		add(panelFinalButtons, BorderLayout.SOUTH);
		GridBagLayout gbl_panelFinalButtons = new GridBagLayout();
		gbl_panelFinalButtons.columnWidths = new int[]{79, 63, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelFinalButtons.rowHeights = new int[]{21, 0};
		gbl_panelFinalButtons.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelFinalButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelFinalButtons.setLayout(gbl_panelFinalButtons);
		
		btnCheckout = new JButton("Færdiggør");
		GridBagConstraints gbc_btnCheckout = new GridBagConstraints();
		gbc_btnCheckout.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCheckout.insets = new Insets(0, 0, 0, 5);
		gbc_btnCheckout.gridx = 0;
		gbc_btnCheckout.gridy = 0;
		panelFinalButtons.add(btnCheckout, gbc_btnCheckout);
		btnCheckout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				checkoutClicked();
			}
		});
		btnCancel = new JButton("Afbryd");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelClicked();
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 0;
		panelFinalButtons.add(btnCancel, gbc_btnCancel);
		
		lblTotalPrice = new JLabel("");
		GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
		gbc_lblTotalPrice.gridx = 11;
		gbc_lblTotalPrice.gridy = 0;
		panelFinalButtons.add(lblTotalPrice, gbc_lblTotalPrice);
		
		JPanel panelDescription = new JPanel();
		panelDescription.setBorder(null);
		splitPaneLease.setRightComponent(panelDescription);
		panelDescription.setLayout(new BorderLayout(0, 0));

		
		JSplitPane splitPaneDescription = new JSplitPane();
		splitPaneDescription.setBorder(null);
		panelDescription.add(splitPaneDescription, BorderLayout.CENTER);

		
		JPanel panelDescriptionSidebar = new JPanel();
		splitPaneDescription.setLeftComponent(panelDescriptionSidebar);
		GridBagLayout gbl_panelDescriptionSidebar = new GridBagLayout();
		gbl_panelDescriptionSidebar.columnWidths = new int[] {0, 0};
		gbl_panelDescriptionSidebar.rowHeights = new int[]{10, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelDescriptionSidebar.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDescriptionSidebar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDescriptionSidebar.setLayout(gbl_panelDescriptionSidebar);
		
		JLabel lblStock = new JLabel("Lager Antal");
		GridBagConstraints gbc_lblStock = new GridBagConstraints();
		gbc_lblStock.insets = new Insets(0, 0, 5, 0);
		gbc_lblStock.gridx = 0;
		gbc_lblStock.gridy = 0;
		panelDescriptionSidebar.add(lblStock, gbc_lblStock);
		
		textStock = new JTextField();
		textStock.setEditable(false);
		GridBagConstraints gbc_textStock = new GridBagConstraints();
		gbc_textStock.insets = new Insets(0, 0, 5, 0);
		gbc_textStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_textStock.gridx = 0;
		gbc_textStock.gridy = 1;
		panelDescriptionSidebar.add(textStock, gbc_textStock);
		textStock.setColumns(10);
		
		JLabel lblFullPrice = new JLabel("Pris /m Rabat");
		GridBagConstraints gbc_lblFullPrice = new GridBagConstraints();
		gbc_lblFullPrice.insets = new Insets(0, 0, 5, 0);
		gbc_lblFullPrice.gridx = 0;
		gbc_lblFullPrice.gridy = 2;
		panelDescriptionSidebar.add(lblFullPrice, gbc_lblFullPrice);
		
		textPrice = new JTextField();
		textPrice.setEditable(false);
		GridBagConstraints gbc_textPrice = new GridBagConstraints();
		gbc_textPrice.insets = new Insets(0, 0, 5, 0);
		gbc_textPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPrice.gridx = 0;
		gbc_textPrice.gridy = 3;
		panelDescriptionSidebar.add(textPrice, gbc_textPrice);
		textPrice.setColumns(10);
		
		JLabel lblDiscountedPrice = new JLabel("Pris med rabat");
		GridBagConstraints gbc_lblDiscountedPrice = new GridBagConstraints();
		gbc_lblDiscountedPrice.insets = new Insets(0, 0, 5, 0);
		gbc_lblDiscountedPrice.gridx = 0;
		gbc_lblDiscountedPrice.gridy = 4;
		panelDescriptionSidebar.add(lblDiscountedPrice, gbc_lblDiscountedPrice);
		
		textDiscountedPrice = new JTextField();
		textDiscountedPrice.setEditable(false);
		textDiscountedPrice.setColumns(10);
		GridBagConstraints gbc_textDiscountedPrice = new GridBagConstraints();
		gbc_textDiscountedPrice.insets = new Insets(0, 0, 5, 0);
		gbc_textDiscountedPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDiscountedPrice.gridx = 0;
		gbc_textDiscountedPrice.gridy = 5;
		panelDescriptionSidebar.add(textDiscountedPrice, gbc_textDiscountedPrice);
		
		JLabel lblDiscount = new JLabel("Rabat");
		lblDiscount.setToolTipText("");
		GridBagConstraints gbc_lblDiscount = new GridBagConstraints();
		gbc_lblDiscount.insets = new Insets(0, 0, 5, 0);
		gbc_lblDiscount.gridx = 0;
		gbc_lblDiscount.gridy = 6;
		panelDescriptionSidebar.add(lblDiscount, gbc_lblDiscount);
		
		textDiscount = new JTextField();
		textDiscount.setEditable(false);
		textDiscount.setColumns(10);
		GridBagConstraints gbc_textDiscount = new GridBagConstraints();
		gbc_textDiscount.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDiscount.gridx = 0;
		gbc_textDiscount.gridy = 7;
		panelDescriptionSidebar.add(textDiscount, gbc_textDiscount);
		
		JScrollPane scrollPaneDescription = new JScrollPane();
		scrollPaneDescription.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneDescription.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		splitPaneDescription.setRightComponent(scrollPaneDescription);
		
		dtrpnIItemDescription = new JEditorPane();
		dtrpnIItemDescription.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dtrpnIItemDescription.setEditable(false);
		dtrpnIItemDescription.setText("Varens beskrivelse her.");
		scrollPaneDescription.setViewportView(dtrpnIItemDescription);
		
		lblProductName = new JLabel("Varens Navn");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		panelDescription.add(lblProductName, BorderLayout.NORTH);
		
		JPanel panelMain = new JPanel();
		splitPaneLease.setLeftComponent(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBarcode = new JPanel();
		panelMain.add(panelBarcode, BorderLayout.NORTH);
		panelBarcode.setLayout(new BorderLayout(0, 0));
		
		txtFieldBarcode = new JTextField();
		txtFieldBarcode.setText("Indtast stregkode");
		txtFieldBarcode.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == 10) {
        			barcodeEntered();
        		}
        	}
        });
		panelBarcode.add(txtFieldBarcode, BorderLayout.CENTER);
		txtFieldBarcode.setColumns(10);
		
		btnBarcodeEnter = new JButton("Enter");
		btnBarcodeEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barcodeEntered();
			}
		});
		panelBarcode.add(btnBarcodeEnter, BorderLayout.EAST);
		
		JPanel panelAtBottom = new JPanel();
		panelMain.add(panelAtBottom, BorderLayout.SOUTH);
		panelAtBottom.setLayout(new BoxLayout(panelAtBottom, BoxLayout.Y_AXIS));
		
		JPanel panelTotal = new JPanel();
		panelAtBottom.add(panelTotal);
		GridBagLayout gbl_panelTotal = new GridBagLayout();
		gbl_panelTotal.columnWidths = new int[]{76, 62, 55, 111, 0};
		gbl_panelTotal.rowHeights = new int[]{19, 0};
		gbl_panelTotal.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelTotal.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTotal.setLayout(gbl_panelTotal);
		
		JLabel lblCustomerDiscount = new JLabel("Kunde Rabat:");
		GridBagConstraints gbc_lblCustomerDiscount = new GridBagConstraints();
		gbc_lblCustomerDiscount.anchor = GridBagConstraints.WEST;
		gbc_lblCustomerDiscount.insets = new Insets(0, 0, 0, 5);
		gbc_lblCustomerDiscount.gridx = 0;
		gbc_lblCustomerDiscount.gridy = 0;
		panelTotal.add(lblCustomerDiscount, gbc_lblCustomerDiscount);
		
		textDiscountPercentage = new JTextField();
		textDiscountPercentage.setText("0%");
		textDiscountPercentage.setEditable(false);
		GridBagConstraints gbc_textDiscountPercentage = new GridBagConstraints();
		gbc_textDiscountPercentage.anchor = GridBagConstraints.NORTHWEST;
		gbc_textDiscountPercentage.insets = new Insets(0, 0, 0, 5);
		gbc_textDiscountPercentage.gridx = 1;
		gbc_textDiscountPercentage.gridy = 0;
		panelTotal.add(textDiscountPercentage, gbc_textDiscountPercentage);
		textDiscountPercentage.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.gridx = 2;
		gbc_lblTotal.gridy = 0;
		panelTotal.add(lblTotal, gbc_lblTotal);
		
		textTotalPrice = new JTextField();
		textTotalPrice.setEditable(false);
		GridBagConstraints gbc_textTotalPrice = new GridBagConstraints();
		gbc_textTotalPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTotalPrice.gridx = 3;
		gbc_textTotalPrice.gridy = 0;
		panelTotal.add(textTotalPrice, gbc_textTotalPrice);
		textTotalPrice.setColumns(10);
		
		JScrollPane scrollPaneLease = new JScrollPane();
		panelMain.add(scrollPaneLease, BorderLayout.CENTER);
		
		tableLease = new JTable(50, 5);
		leaseTableModel = new LeaseTable(leaseCtrl.getLease());
		tableLease.setModel(leaseTableModel);
		
		tableLease.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableLease.rowAtPoint(e.getPoint());
				int col = tableLease.columnAtPoint(e.getPoint());

				if (col == COL_NAMES.length - 1 && row != -1) {
					removeRow(row);
				}
			}
		});

		JPanel panelDate = new JPanel();
		panelAtBottom.add(panelDate);
		GridBagLayout gbl_panelDate = new GridBagLayout();
		gbl_panelDate.columnWidths = new int[]{0, 60, 25, 0, 0};
		gbl_panelDate.rowHeights = new int[]{19, 0};
		gbl_panelDate.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelDate.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelDate.setLayout(gbl_panelDate);
		
		JLabel lblDate = new JLabel("Dato:");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 0;
		panelDate.add(lblDate, gbc_lblDate);
		
		textFieldFromDate = new JTextField();
		textFieldFromDate.setEditable(false);
		textFieldFromDate.setColumns(10);
		GridBagConstraints gbc_textFieldFromDate = new GridBagConstraints();
		gbc_textFieldFromDate.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldFromDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFromDate.gridx = 1;
		gbc_textFieldFromDate.gridy = 0;
		panelDate.add(textFieldFromDate, gbc_textFieldFromDate);
		
		textFieldToDate = new JTextField();
		textFieldToDate.setEditable(false);
		textFieldToDate.setColumns(10);
		GridBagConstraints gbc_textFieldToDate = new GridBagConstraints();
		gbc_textFieldToDate.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldToDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldToDate.gridx = 2;
		gbc_textFieldToDate.gridy = 0;
		panelDate.add(textFieldToDate, gbc_textFieldToDate);
		
		textFieldLeaseDuration = new JTextField();
		textFieldLeaseDuration.setEditable(false);
		textFieldLeaseDuration.setColumns(10);
		GridBagConstraints gbc_textFieldLeaseDuration = new GridBagConstraints();
		gbc_textFieldLeaseDuration.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLeaseDuration.gridx = 3;
		gbc_textFieldLeaseDuration.gridy = 0;
		panelDate.add(textFieldLeaseDuration, gbc_textFieldLeaseDuration);
		
		JPanel panelCustomer = new JPanel();
		panelCustomer.setBorder(new EmptyBorder(5, 0, 0, 0));
		panelAtBottom.add(panelCustomer);
		GridBagLayout gbl_panelCustomer = new GridBagLayout();
		gbl_panelCustomer.columnWidths = new int[]{161, 223, 0};
		gbl_panelCustomer.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelCustomer.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelCustomer.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCustomer.setLayout(gbl_panelCustomer);
		
		textFindCustomer = new JTextField();
		textFindCustomer.setText("Indtast tlf.nr.");
		textFindCustomer.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (!textFindCustomer.getText().isEmpty()) {
					textFindCustomer.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textFindCustomer.getText().isEmpty()) {
					textFindCustomer.setText("Indtast tlf.nr.");
				}
			}
		});

		txtFieldBarcode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (!txtFieldBarcode.getText().isEmpty()) {
					txtFieldBarcode.setText("");
				}

				if (textFindCustomer.getText().isEmpty()) {
					textFindCustomer.setText("Indtast tlf.nr.");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtFieldBarcode.getText().isEmpty()) {
					txtFieldBarcode.setText("Indtast stregkode");
				}
			}
		});
		
		textFindCustomer.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					leaseCtrl.setCustomer(textFindCustomer.getText());
					updateData();
					textFindCustomer.setText("");
				}
			}
		});
		
		GridBagConstraints gbc_textFindCustomer = new GridBagConstraints();
		gbc_textFindCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_textFindCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFindCustomer.gridx = 0;
		gbc_textFindCustomer.gridy = 0;
		panelCustomer.add(textFindCustomer, gbc_textFindCustomer);
		
		splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 1;
		gbc_splitPane.gridy = 0;
		panelCustomer.add(splitPane, gbc_splitPane);
		
		btnCreateCustomer = new JButton("Opret ny kunde");
		btnCreateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCustomerWindow();
			}
		});
		splitPane.setRightComponent(btnCreateCustomer);
		
		btnFindCustomer = new JButton("      Find kunde      ");
		btnFindCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leaseCtrl.setCustomer(textFindCustomer.getText());
				updateData();
				textFindCustomer.setText("");
			}
		});
		splitPane.setLeftComponent(btnFindCustomer);
		
		textName = new JTextField();
		textName.setText("Navn");
		textName.setEditable(false);
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.gridx = 0;
		gbc_textName.gridy = 1;
		panelCustomer.add(textName, gbc_textName);
		textName.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setText("Addresse");
		textAddress.setEditable(false);
		GridBagConstraints gbc_textAddress = new GridBagConstraints();
		gbc_textAddress.insets = new Insets(0, 0, 5, 0);
		gbc_textAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAddress.gridx = 1;
		gbc_textAddress.gridy = 1;
		panelCustomer.add(textAddress, gbc_textAddress);
		textAddress.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setText("Telefon Nummer");
		textPhone.setEditable(false);
		GridBagConstraints gbc_textPhone = new GridBagConstraints();
		gbc_textPhone.insets = new Insets(0, 0, 0, 5);
		gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPhone.gridx = 0;
		gbc_textPhone.gridy = 2;
		panelCustomer.add(textPhone, gbc_textPhone);
		textPhone.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setText("Email");
		textEmail.setEditable(false);
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 2;
		panelCustomer.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);
		
		scrollPaneLease.setViewportView(tableLease);
		
		tableLease = new JTable();
		//TODO insert controller data
		leaseTableModel = new LeaseTable(null);
		tableLease.setModel(leaseTableModel);
		scrollPaneLease.setViewportView(tableLease);
	}


	private void cancelClicked() {
		leaseCtrl.clearLeases();
        leaseTableModel.setData(leaseCtrl.getProducts());
        updateTable();
	}
	
	private void updateTable() {
		leaseTableModel.setData(leaseCtrl.getLease());
		textTotalPrice.setText(leaseCtrl.getLeasePrice() + "");
	}
	

	private void barcodeEntered() {
		clearTotalPrice();
		
		String barcode = txtFieldBarcode.getText();
        LeaseableIF product = leaseCtrl.addProduct(barcode);
        leaseTableModel.setData(leaseCtrl.getProducts());
        
        updateTable();
		setProductInfo(product);
		txtFieldBarcode.setText("");
	}
	
/*	private void checkoutClicked() {
		String paymentInput = JOptionPane.showInputDialog("Indtast betaling:");
		double payment;
		payment = Double.parseDouble(paymentInput);
		leases = leaseCtrl.completeLease(payment);
		String totalPrice = "Total: " + leases.getPrice() + " Betalt: " + payment + "kr Tilbage: "
				+ (payment - leases.getLeasePrice()) + "kr";
		System.out.println(leases.getLeasePrice());
		leaseCtrl.makeLease();
		updateData();
		clearCheckout();
	}*/ //TODO this class need fixing ^
	
	private void showTotalPrice(String totalPrice) {
		lblTotalPrice.setText(totalPrice);
	}

	private void setProductInfo(LeaseableIF product) {
		dtrpnIItemDescription.setText(product.getDescription());
		textPrice.setText(product.getOriginalLeasePrice(LocalDateTime.now()) + "kr,-");
		textDiscountedPrice.setText(product.getLeasePrice(LocalDateTime.now()) + "kr,-" );
		textDiscount.setText((product.getDiscountLease(LocalDateTime.now())*100+ "%"));
		lblProductName.setText(product.getName());
		textStock.setText(product.getStock(location) + " stk.");

	}
	
	private void setCustomerData(Customer customer) {
		textName.setText(customer.getName());
		textAddress.setText(customer.getAddress());
		textPhone.setText(customer.getPhone());
		textEmail.setText(customer.getEmail());
		textDiscountPercentage.setText(customer.getCustomerGroup().getMaxDiscount(LocalDateTime.now())*100+ "%");
	}
	

	private void clearCustomer() {
		Customer customer = leaseCtrl.getCustomer();

		if (customer == null) {
			textName.setText("Navn");
			textAddress.setText("Adresse");
			textPhone.setText("Telefonnummer");
			textEmail.setText("Email");
		}
	}
	
	private void updateData() {
		
		updateTable();
		textTotalPrice.setText(leaseCtrl.getLeasePrice() + "kr");
		if (leaseCtrl.getCustomer() != null) {
			setCustomerData(leaseCtrl.getCustomer());
		} else {
			clearCustomer();
		}
	}

	private void createCustomerWindow() {
		CreateCustomerWindow customerWindow = new CreateCustomerWindow(customerCtrl);
		customerWindow.setVisible(true);
		if (customerWindow.isOkClicked()) {
			leaseCtrl.setCustomer(customerWindow.getPhone());
			updateData();
			}
		}
	

	private void clearCheckout() {
		updateData();
		textPrice.setText("");
		dtrpnIItemDescription.setText("Varens beskrivelse her.");
		lblProductName.setText("Produkt");
		textStock.setText("");
	}

	private void clearTotalPrice() {
		textTotalPrice.setText("");
		lblTotalPrice.setText("");
	}

	private void removeRow(int row) {
		leaseCtrl.removeProduct(row);
		clearCheckout();
	}
}
