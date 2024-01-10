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
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ScrollPaneConstants;

public class LoanMenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtFieldBarcode;
	private JTable tableLoan;
	private JTextField textFieldFromDate;
	private JTextField textFieldToDate;
	private JTextField textFieldLoanDuration;
	private JTextField textDiscountPercentage;
	private JTextField textTotalPrice;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textAddress;
	private JTextField textEmail;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public LoanMenuPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPaneLoan = new JSplitPane();
		add(splitPaneLoan, BorderLayout.CENTER);
		
		JPanel panelFinalButtons = new JPanel();
		add(panelFinalButtons, BorderLayout.SOUTH);
		panelFinalButtons.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JButton btnCheckOut = new JButton("Færdiggør");
		panelFinalButtons.add(btnCheckOut);
		
		JButton btnCancel = new JButton("Afbryd");
		panelFinalButtons.add(btnCancel);
		
		JPanel panelDescription = new JPanel();
		panelDescription.setBorder(new EmptyBorder(10, 0, 0, 10));
		splitPaneLoan.setRightComponent(panelDescription);
		panelDescription.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDescriptionSidebar = new JPanel();
		panelDescription.add(panelDescriptionSidebar, BorderLayout.WEST);
		GridBagLayout gbl_panelDescriptionSidebar = new GridBagLayout();
		gbl_panelDescriptionSidebar.columnWidths = new int[]{10, 0};
		gbl_panelDescriptionSidebar.rowHeights = new int[]{10, 0, 0, 0, 0, 0};
		gbl_panelDescriptionSidebar.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDescriptionSidebar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDescriptionSidebar.setLayout(gbl_panelDescriptionSidebar);
		
		JPanel panelPicture = new JPanel();
		GridBagConstraints gbc_panelPicture = new GridBagConstraints();
		gbc_panelPicture.insets = new Insets(0, 0, 5, 0);
		gbc_panelPicture.anchor = GridBagConstraints.NORTHWEST;
		gbc_panelPicture.gridx = 0;
		gbc_panelPicture.gridy = 0;
		panelDescriptionSidebar.add(panelPicture, gbc_panelPicture);
		
		JLabel lblNewLabel_7 = new JLabel("Lager Antal");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 1;
		panelDescriptionSidebar.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		panelDescriptionSidebar.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pris /m Rabat");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		panelDescriptionSidebar.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 4;
		panelDescriptionSidebar.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPaneDescription = new JScrollPane();
		scrollPaneDescription.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneDescription.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelDescription.add(scrollPaneDescription, BorderLayout.CENTER);
		
		JEditorPane dtrpnIItemDescription = new JEditorPane();
		dtrpnIItemDescription.setEditable(false);
		dtrpnIItemDescription.setText("description\r\newiof wei jei jwr ewijdescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescription descriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescription descriptiondescriptiondescription description description descriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptidescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptionondescription");
		scrollPaneDescription.setViewportView(dtrpnIItemDescription);
		
		JLabel lblNewLabel = new JLabel("Valgte Vares Navn");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelDescription.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(10, 10, 0, 0));
		splitPaneLoan.setLeftComponent(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBarcode = new JPanel();
		panelMain.add(panelBarcode, BorderLayout.NORTH);
		panelBarcode.setLayout(new BorderLayout(0, 0));
		
		txtFieldBarcode = new JTextField();
		panelBarcode.add(txtFieldBarcode, BorderLayout.CENTER);
		txtFieldBarcode.setColumns(10);
		
		JButton btnBarcodeEnter = new JButton("Enter");
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
		GridBagConstraints gbc_textTotalPrice = new GridBagConstraints();
		gbc_textTotalPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTotalPrice.gridx = 3;
		gbc_textTotalPrice.gridy = 0;
		panelTotal.add(textTotalPrice, gbc_textTotalPrice);
		textTotalPrice.setColumns(10);
		
		JPanel panelDate = new JPanel();
		panelAtBottom.add(panelDate);
		panelDate.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JLabel lblDate = new JLabel("Dato:");
		panelDate.add(lblDate);
		
		textFieldFromDate = new JTextField();
		panelDate.add(textFieldFromDate);
		textFieldFromDate.setColumns(10);
		
		textFieldToDate = new JTextField();
		panelDate.add(textFieldToDate);
		textFieldToDate.setColumns(10);
		
		textFieldLoanDuration = new JTextField();
		panelDate.add(textFieldLoanDuration);
		textFieldLoanDuration.setColumns(10);
		
		JPanel panelKunde = new JPanel();
		panelAtBottom.add(panelKunde);
		GridBagLayout gbl_panelKunde = new GridBagLayout();
		gbl_panelKunde.columnWidths = new int[]{0, 0, 0};
		gbl_panelKunde.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelKunde.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelKunde.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelKunde.setLayout(gbl_panelKunde);
		
		JFormattedTextField formattedTextFindCustomer = new JFormattedTextField();
		formattedTextFindCustomer.setText("Indsæt Tlf:");
		GridBagConstraints gbc_formattedTextFindCustomer = new GridBagConstraints();
		gbc_formattedTextFindCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextFindCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFindCustomer.gridx = 0;
		gbc_formattedTextFindCustomer.gridy = 0;
		panelKunde.add(formattedTextFindCustomer, gbc_formattedTextFindCustomer);
		
		JButton btnNewCustomer = new JButton("Opret ny Kunde");
		GridBagConstraints gbc_btnNewCustomer = new GridBagConstraints();
		gbc_btnNewCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewCustomer.gridx = 1;
		gbc_btnNewCustomer.gridy = 0;
		panelKunde.add(btnNewCustomer, gbc_btnNewCustomer);
		
		textName = new JTextField();
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.gridx = 0;
		gbc_textName.gridy = 1;
		panelKunde.add(textName, gbc_textName);
		textName.setColumns(10);
		
		textAddress = new JTextField();
		GridBagConstraints gbc_textAddress = new GridBagConstraints();
		gbc_textAddress.insets = new Insets(0, 0, 5, 0);
		gbc_textAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAddress.gridx = 1;
		gbc_textAddress.gridy = 1;
		panelKunde.add(textAddress, gbc_textAddress);
		textAddress.setColumns(10);
		
		textPhone = new JTextField();
		GridBagConstraints gbc_textPhone = new GridBagConstraints();
		gbc_textPhone.insets = new Insets(0, 0, 0, 5);
		gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPhone.gridx = 0;
		gbc_textPhone.gridy = 2;
		panelKunde.add(textPhone, gbc_textPhone);
		textPhone.setColumns(10);
		
		textEmail = new JTextField();
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 2;
		panelKunde.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);
		
		JScrollPane scrollPaneLoan = new JScrollPane();
		panelMain.add(scrollPaneLoan, BorderLayout.CENTER);
		
		tableLoan = new JTable();
		tableLoan.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Vare", "Price", "Fjern"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPaneLoan.setViewportView(tableLoan);

	}

}