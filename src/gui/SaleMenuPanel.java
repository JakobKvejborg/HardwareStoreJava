package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;

public class SaleMenuPanel extends JPanel {

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
	private JTextField textField;
	private JButton btnCheckout;
	private JButton btnCancel;
	private JButton btnCreateCustomer;
	private JButton btnBarcodeEnter;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public SaleMenuPanel() {
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
		
		btnBarcodeEnter = new JButton("Enter");
		panelBarcode.add(btnBarcodeEnter, BorderLayout.EAST);
		
		JPanel panelWestCenter = new JPanel();
		panelSaleNorthWest.add(panelWestCenter, BorderLayout.CENTER);
		panelWestCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCenterSouthWest = new JPanel();
		panelWestCenter.add(panelCenterSouthWest, BorderLayout.SOUTH);
		GridBagLayout gbl_panelCenterSouthWest = new GridBagLayout();
		gbl_panelCenterSouthWest.columnWidths = new int[]{0, 85, 0};
		gbl_panelCenterSouthWest.rowHeights = new int[]{0, 0, 28, 0};
		gbl_panelCenterSouthWest.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelCenterSouthWest.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCenterSouthWest.setLayout(gbl_panelCenterSouthWest);
		
		txtFindCustomer = new JTextField();
		txtFindCustomer.setText("Indsæt Tlf.");
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
		
		textName = new JTextField();
		textName.setEditable(false);
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.gridx = 0;
		gbc_textName.gridy = 1;
		panelCenterSouthWest.add(textName, gbc_textName);
		textName.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setEditable(false);
		GridBagConstraints gbc_textAddress = new GridBagConstraints();
		gbc_textAddress.insets = new Insets(0, 0, 5, 0);
		gbc_textAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAddress.gridx = 1;
		gbc_textAddress.gridy = 1;
		panelCenterSouthWest.add(textAddress, gbc_textAddress);
		textAddress.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setEditable(false);
		GridBagConstraints gbc_textPhone = new GridBagConstraints();
		gbc_textPhone.insets = new Insets(0, 0, 0, 5);
		gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPhone.gridx = 0;
		gbc_textPhone.gridy = 2;
		panelCenterSouthWest.add(textPhone, gbc_textPhone);
		textPhone.setColumns(10);
		
		textEmail = new JTextField();
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
		gbl_panelPriceCal.columnWidths = new int[]{79, 59, 62, 93, 0};
		gbl_panelPriceCal.rowHeights = new int[]{0, 0};
		gbl_panelPriceCal.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelPriceCal.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelPriceCal.setLayout(gbl_panelPriceCal);
		
		lblCustomerDiscount = new JLabel();
		lblCustomerDiscount.setText("Kunde Rabat:");
		GridBagConstraints gbc_lblCustomerDiscount = new GridBagConstraints();
		gbc_lblCustomerDiscount.anchor = GridBagConstraints.EAST;
		gbc_lblCustomerDiscount.insets = new Insets(0, 0, 0, 5);
		gbc_lblCustomerDiscount.gridx = 0;
		gbc_lblCustomerDiscount.gridy = 0;
		panelPriceCal.add(lblCustomerDiscount, gbc_lblCustomerDiscount);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panelPriceCal.add(textField_1, gbc_textField_1);
		
		lblTotal = new JLabel();
		lblTotal.setText("Total:");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.gridx = 2;
		gbc_lblTotal.gridy = 0;
		panelPriceCal.add(lblTotal, gbc_lblTotal);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		panelPriceCal.add(textField, gbc_textField);
		
		JScrollPane scrollPaneSale = new JScrollPane();
		panelCenterNorthWest.add(scrollPaneSale, BorderLayout.CENTER);
		
		tableSale = new JTable(50,4);
		tableSale.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Indk\u00F8bskurv", "Antal", "Pris", "Fjern"
			}
		));
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
		
		JTextPane txtpnProductDescription = new JTextPane();
		txtpnProductDescription.setText("Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. Beskrivelse her. Varens beskrivelse her. ");
		scrollPaneDescription.setViewportView(txtpnProductDescription);
		
		JPanel panelDescriptionSideBar = new JPanel();
		splitPaneDescription.setLeftComponent(panelDescriptionSideBar);
		GridBagLayout gbl_panelDescriptionSideBar = new GridBagLayout();
		gbl_panelDescriptionSideBar.columnWidths = new int[]{0, 0};
		gbl_panelDescriptionSideBar.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelDescriptionSideBar.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDescriptionSideBar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblStock = new JLabel("(Pris m/ rabat)");
		GridBagConstraints gbc_lblStock = new GridBagConstraints();
		gbc_lblStock.insets = new Insets(0, 0, 5, 0);
		gbc_lblStock.gridx = 0;
		gbc_lblStock.gridy = 2;
		panelDescriptionSideBar.add(lblStock, gbc_lblStock);
		
		textPrice = new JTextField();
		textPrice.setEditable(false);
		GridBagConstraints gbc_textPrice = new GridBagConstraints();
		gbc_textPrice.insets = new Insets(0, 0, 5, 0);
		gbc_textPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPrice.gridx = 0;
		gbc_textPrice.gridy = 3;
		panelDescriptionSideBar.add(textPrice, gbc_textPrice);
		textPrice.setColumns(10);
		
		JPanel panelSaleSouth = new JPanel();
		add(panelSaleSouth, BorderLayout.SOUTH);
		panelSaleSouth.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSaleGridSouth = new JPanel();
		panelSaleSouth.add(panelSaleGridSouth, BorderLayout.NORTH);
		GridBagLayout gbl_panelSaleGridSouth = new GridBagLayout();
		gbl_panelSaleGridSouth.columnWidths = new int[]{80, 85, 85, 0};
		gbl_panelSaleGridSouth.rowHeights = new int[]{21, 0};
		gbl_panelSaleGridSouth.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSaleGridSouth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelSaleGridSouth.setLayout(gbl_panelSaleGridSouth);
		
		btnCheckout = new JButton("Færdiggør");
		GridBagConstraints gbc_btnCheckout = new GridBagConstraints();
		gbc_btnCheckout.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCheckout.insets = new Insets(0, 0, 0, 5);
		gbc_btnCheckout.gridx = 0;
		gbc_btnCheckout.gridy = 0;
		panelSaleGridSouth.add(btnCheckout, gbc_btnCheckout);
		
		btnCancel = new JButton("Afbryd");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 0;
		panelSaleGridSouth.add(btnCancel, gbc_btnCancel);


	}

}
