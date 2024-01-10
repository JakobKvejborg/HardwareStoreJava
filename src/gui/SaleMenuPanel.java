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
	private JTextField textDiscountPercentage;
	private JTable tableSale;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textAddress;
	private JTextField textEmail;
	private JTextField textTotalPrice;
	private JLabel lblCustomerDiscount;
	private JLabel lblTotal;
	private JTextField textStock;
	private JTextField textPrice;
	private JTextField textBarcode;

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
		
		JButton btnBarcodeEnter = new JButton("Enter");
		panelBarcode.add(btnBarcodeEnter, BorderLayout.EAST);
		
		JPanel panelSouthWest = new JPanel();
		panelSaleNorthWest.add(panelSouthWest, BorderLayout.SOUTH);
		panelSouthWest.setLayout(new BorderLayout(0, 0));
		
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
		
		JButton btnCreateCustomer = new JButton("Opret ny kunde");
		GridBagConstraints gbc_btnCreateCustomer = new GridBagConstraints();
		gbc_btnCreateCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateCustomer.gridx = 1;
		gbc_btnCreateCustomer.gridy = 0;
		panelCenterSouthWest.add(btnCreateCustomer, gbc_btnCreateCustomer);
		
		textName = new JTextField();
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.gridx = 0;
		gbc_textName.gridy = 1;
		panelCenterSouthWest.add(textName, gbc_textName);
		textName.setColumns(10);
		
		textAddress = new JTextField();
		GridBagConstraints gbc_textAddress = new GridBagConstraints();
		gbc_textAddress.insets = new Insets(0, 0, 5, 0);
		gbc_textAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAddress.gridx = 1;
		gbc_textAddress.gridy = 1;
		panelCenterSouthWest.add(textAddress, gbc_textAddress);
		textAddress.setColumns(10);
		
		textPhone = new JTextField();
		GridBagConstraints gbc_textPhone = new GridBagConstraints();
		gbc_textPhone.insets = new Insets(0, 0, 0, 5);
		gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPhone.gridx = 0;
		gbc_textPhone.gridy = 2;
		panelCenterSouthWest.add(textPhone, gbc_textPhone);
		textPhone.setColumns(10);
		
		textEmail = new JTextField();
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
		gbl_panelPriceCal.columnWidths = new int[]{79, 73, 81, 73, 0};
		gbl_panelPriceCal.rowHeights = new int[]{0, 0};
		gbl_panelPriceCal.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelPriceCal.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelPriceCal.setLayout(gbl_panelPriceCal);
		
		lblCustomerDiscount = new JLabel();
		lblCustomerDiscount.setText("Kunde Rabat");
		GridBagConstraints gbc_lblCustomerDiscount = new GridBagConstraints();
		gbc_lblCustomerDiscount.insets = new Insets(0, 0, 0, 5);
		gbc_lblCustomerDiscount.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCustomerDiscount.gridx = 0;
		gbc_lblCustomerDiscount.gridy = 0;
		panelPriceCal.add(lblCustomerDiscount, gbc_lblCustomerDiscount);
		
		textDiscountPercentage = new JTextField();
		textDiscountPercentage.setEditable(false);
		GridBagConstraints gbc_textDiscountPercentage = new GridBagConstraints();
		gbc_textDiscountPercentage.insets = new Insets(0, 0, 0, 5);
		gbc_textDiscountPercentage.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDiscountPercentage.gridx = 1;
		gbc_textDiscountPercentage.gridy = 0;
		panelPriceCal.add(textDiscountPercentage, gbc_textDiscountPercentage);
		textDiscountPercentage.setColumns(10);
		
		lblTotal = new JLabel();
		lblTotal.setText("Total:");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTotal.gridx = 2;
		gbc_lblTotal.gridy = 0;
		panelPriceCal.add(lblTotal, gbc_lblTotal);
		
		textTotalPrice = new JTextField();
		textTotalPrice.setEditable(false);
		GridBagConstraints gbc_textTotalPrice = new GridBagConstraints();
		gbc_textTotalPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTotalPrice.gridx = 3;
		gbc_textTotalPrice.gridy = 0;
		panelPriceCal.add(textTotalPrice, gbc_textTotalPrice);
		textTotalPrice.setColumns(10);
		
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
		
		JPanel panelInfoDescription = new JPanel();
		splitPaneDescription.setLeftComponent(panelInfoDescription);
		GridBagLayout gbl_panelInfoDescription = new GridBagLayout();
		gbl_panelInfoDescription.columnWidths = new int[]{0, 0};
		gbl_panelInfoDescription.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelInfoDescription.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelInfoDescription.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelInfoDescription.setLayout(gbl_panelInfoDescription);
		
		JLabel lblPrice = new JLabel("(Lager antal)");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 0;
		panelInfoDescription.add(lblPrice, gbc_lblPrice);
		
		textStock = new JTextField();
		textStock.setEditable(false);
		GridBagConstraints gbc_textStock = new GridBagConstraints();
		gbc_textStock.insets = new Insets(0, 0, 5, 0);
		gbc_textStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_textStock.gridx = 0;
		gbc_textStock.gridy = 1;
		panelInfoDescription.add(textStock, gbc_textStock);
		textStock.setColumns(10);
		
		JLabel lblStock = new JLabel("(Pris m/ rabat)");
		GridBagConstraints gbc_lblStock = new GridBagConstraints();
		gbc_lblStock.insets = new Insets(0, 0, 5, 0);
		gbc_lblStock.gridx = 0;
		gbc_lblStock.gridy = 2;
		panelInfoDescription.add(lblStock, gbc_lblStock);
		
		textPrice = new JTextField();
		textPrice.setEditable(false);
		GridBagConstraints gbc_textPrice = new GridBagConstraints();
		gbc_textPrice.insets = new Insets(0, 0, 5, 0);
		gbc_textPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPrice.gridx = 0;
		gbc_textPrice.gridy = 3;
		panelInfoDescription.add(textPrice, gbc_textPrice);
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
		
		JButton btnCheckout = new JButton("Færdigør");
		GridBagConstraints gbc_btnCheckout = new GridBagConstraints();
		gbc_btnCheckout.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCheckout.insets = new Insets(0, 0, 0, 5);
		gbc_btnCheckout.gridx = 0;
		gbc_btnCheckout.gridy = 0;
		panelSaleGridSouth.add(btnCheckout, gbc_btnCheckout);
		
		JButton btnCancel = new JButton("Afbryd");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 0;
		panelSaleGridSouth.add(btnCancel, gbc_btnCancel);

		JLabel lblNewLabel = new JLabel("New label");

	}

}
