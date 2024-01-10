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

public class SaleMenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldBarcode;
	private JTextField txtFindCustomer;
	private JTextField textFieldDiscountPercentage;
	private JTable tableSale;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textAddress;
	private JTextField textFieldEmail;
	private JTextField textFieldTotalPrice;
	private JLabel lblKundeRabat;
	private JLabel lblTotal;

	/**
	 * Create the panel.
	 */
	public SaleMenuPanel() {
		
		
		setLayout(new BorderLayout(0, 0));
	
	
		JSplitPane splitPaneSale = new JSplitPane();
		add(splitPaneSale, BorderLayout.CENTER);
		
		JPanel panelSaleNorthWest = new JPanel();
		splitPaneSale.setLeftComponent(panelSaleNorthWest);
		panelSaleNorthWest.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorthWest = new JPanel();
		panelSaleNorthWest.add(panelNorthWest, BorderLayout.NORTH);
		panelNorthWest.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPaneNorthWest = new JSplitPane();
		panelNorthWest.add(splitPaneNorthWest, BorderLayout.NORTH);
		
		textFieldBarcode = new JTextField();
		splitPaneNorthWest.setLeftComponent(textFieldBarcode);
		textFieldBarcode.setColumns(10);
		
		JButton btnEnterKey = new JButton("Enter");
		splitPaneNorthWest.setRightComponent(btnEnterKey);
		
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
		
		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 1;
		gbc_textFieldEmail.gridy = 2;
		panelCenterSouthWest.add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
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
		
		lblKundeRabat = new JLabel();
		lblKundeRabat.setText("Kunde Rabat");
		GridBagConstraints gbc_lblKundeRabat = new GridBagConstraints();
		gbc_lblKundeRabat.insets = new Insets(0, 0, 0, 5);
		gbc_lblKundeRabat.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblKundeRabat.gridx = 0;
		gbc_lblKundeRabat.gridy = 0;
		panelPriceCal.add(lblKundeRabat, gbc_lblKundeRabat);
		
		textFieldDiscountPercentage = new JTextField();
		textFieldDiscountPercentage.setEditable(false);
		GridBagConstraints gbc_textFieldDiscountPercentage = new GridBagConstraints();
		gbc_textFieldDiscountPercentage.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldDiscountPercentage.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDiscountPercentage.gridx = 1;
		gbc_textFieldDiscountPercentage.gridy = 0;
		panelPriceCal.add(textFieldDiscountPercentage, gbc_textFieldDiscountPercentage);
		textFieldDiscountPercentage.setColumns(10);
		
		lblTotal = new JLabel();
		lblTotal.setText("Total:");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTotal.gridx = 2;
		gbc_lblTotal.gridy = 0;
		panelPriceCal.add(lblTotal, gbc_lblTotal);
		
		textFieldTotalPrice = new JTextField();
		GridBagConstraints gbc_textFieldTotalPrice = new GridBagConstraints();
		gbc_textFieldTotalPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTotalPrice.gridx = 3;
		gbc_textFieldTotalPrice.gridy = 0;
		panelPriceCal.add(textFieldTotalPrice, gbc_textFieldTotalPrice);
		textFieldTotalPrice.setColumns(10);
		
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
		
		JScrollPane scrollPaneWest = new JScrollPane();
		splitPaneSale.setRightComponent(scrollPaneWest);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		scrollPaneWest.setColumnHeaderView(lblNewLabel_5);
		
		JSplitPane splitPane_1 = new JSplitPane();
		scrollPaneWest.setViewportView(splitPane_1);
		
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
