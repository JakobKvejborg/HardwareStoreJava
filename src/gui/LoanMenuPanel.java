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

import model.LendableIF;
import model.SellableIF;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	private JTextField textFindCustomer;
	private JButton btnCheckOut;
	private JButton btnCancel;
	private JButton btnNewCustomer;
	private JButton btnBarcodeEnter;
	private Object loanCtrl;

	/**
	 * Create the panel.
	 */
	public LoanMenuPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPaneLoan = new JSplitPane();
		add(splitPaneLoan, BorderLayout.CENTER);
		
		JPanel panelFinalButtons = new JPanel();
		panelFinalButtons.setBorder(null);
		add(panelFinalButtons, BorderLayout.SOUTH);
		GridBagLayout gbl_panelFinalButtons = new GridBagLayout();
		gbl_panelFinalButtons.columnWidths = new int[]{79, 63, 0};
		gbl_panelFinalButtons.rowHeights = new int[]{21, 0};
		gbl_panelFinalButtons.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelFinalButtons.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelFinalButtons.setLayout(gbl_panelFinalButtons);
		
		btnCheckOut = new JButton("Færdiggør");
		GridBagConstraints gbc_btnCheckOut = new GridBagConstraints();
		gbc_btnCheckOut.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCheckOut.insets = new Insets(0, 0, 0, 5);
		gbc_btnCheckOut.gridx = 0;
		gbc_btnCheckOut.gridy = 0;
		panelFinalButtons.add(btnCheckOut, gbc_btnCheckOut);
		
		btnCancel = new JButton("Afbryd");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 0;
		panelFinalButtons.add(btnCancel, gbc_btnCancel);
		
		JPanel panelDescription = new JPanel();
		panelDescription.setBorder(null);
		splitPaneLoan.setRightComponent(panelDescription);
		panelDescription.setLayout(new BorderLayout(0, 0));

		
		JSplitPane splitPaneDescription = new JSplitPane();
		splitPaneDescription.setBorder(null);
		panelDescription.add(splitPaneDescription, BorderLayout.CENTER);

		
		JPanel panelDescriptionSidebar = new JPanel();
		splitPaneDescription.setLeftComponent(panelDescriptionSidebar);
		GridBagLayout gbl_panelDescriptionSidebar = new GridBagLayout();
		gbl_panelDescriptionSidebar.columnWidths = new int[] {0, 0};
		gbl_panelDescriptionSidebar.rowHeights = new int[]{10, 0, 0, 0, 0, 0};
		gbl_panelDescriptionSidebar.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDescriptionSidebar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDescriptionSidebar.setLayout(gbl_panelDescriptionSidebar);
		
		JLabel lblNewLabel_7 = new JLabel("Lager Antal");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 0;
		panelDescriptionSidebar.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panelDescriptionSidebar.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pris /m Rabat");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panelDescriptionSidebar.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 3;
		panelDescriptionSidebar.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPaneDescription = new JScrollPane();
		scrollPaneDescription.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneDescription.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		splitPaneDescription.setRightComponent(scrollPaneDescription);
		
		JEditorPane dtrpnIItemDescription = new JEditorPane();
		dtrpnIItemDescription.setEditable(false);
		dtrpnIItemDescription.setText("description\r\newiof wei jei jwr ewijdescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescription descriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescription descriptiondescriptiondescription description description descriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptidescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptionondescription");
		scrollPaneDescription.setViewportView(dtrpnIItemDescription);
		
		JLabel lblProductName = new JLabel("Varens Navn");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		panelDescription.add(lblProductName, BorderLayout.NORTH);
		
		JPanel panelMain = new JPanel();
		splitPaneLoan.setLeftComponent(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBarcode = new JPanel();
		panelMain.add(panelBarcode, BorderLayout.NORTH);
		panelBarcode.setLayout(new BorderLayout(0, 0));
		
		txtFieldBarcode = new JTextField();
		panelBarcode.add(txtFieldBarcode, BorderLayout.CENTER);
		txtFieldBarcode.setColumns(10);
		txtFieldBarcode.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == 10) {
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
		textTotalPrice.setEditable(false);
		GridBagConstraints gbc_textTotalPrice = new GridBagConstraints();
		gbc_textTotalPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTotalPrice.gridx = 3;
		gbc_textTotalPrice.gridy = 0;
		panelTotal.add(textTotalPrice, gbc_textTotalPrice);
		textTotalPrice.setColumns(10);
		
		JPanel panelDate = new JPanel();
		panelAtBottom.add(panelDate);
		GridBagLayout gbl_panelDate = new GridBagLayout();
		gbl_panelDate.columnWidths = new int[]{25, 96, 96, 0, 0};
		gbl_panelDate.rowHeights = new int[]{19, 0};
		gbl_panelDate.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelDate.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelDate.setLayout(gbl_panelDate);
		
		JLabel lblDate = new JLabel("Dato:");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 0;
		panelDate.add(lblDate, gbc_lblDate);
		
		textFieldFromDate = new JTextField();
		textFieldFromDate.setEditable(false);
		GridBagConstraints gbc_textFieldFromDate = new GridBagConstraints();
		gbc_textFieldFromDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFromDate.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldFromDate.gridx = 1;
		gbc_textFieldFromDate.gridy = 0;
		panelDate.add(textFieldFromDate, gbc_textFieldFromDate);
		textFieldFromDate.setColumns(10);
		
		textFieldToDate = new JTextField();
		textFieldToDate.setEditable(false);
		GridBagConstraints gbc_textFieldToDate = new GridBagConstraints();
		gbc_textFieldToDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldToDate.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldToDate.gridx = 2;
		gbc_textFieldToDate.gridy = 0;
		panelDate.add(textFieldToDate, gbc_textFieldToDate);
		textFieldToDate.setColumns(10);
		
		textFieldLoanDuration = new JTextField();
		textFieldLoanDuration.setEditable(false);
		GridBagConstraints gbc_textFieldLoanDuration = new GridBagConstraints();
		gbc_textFieldLoanDuration.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLoanDuration.gridwidth = 2;
		gbc_textFieldLoanDuration.gridx = 3;
		gbc_textFieldLoanDuration.gridy = 0;
		panelDate.add(textFieldLoanDuration, gbc_textFieldLoanDuration);
		textFieldLoanDuration.setColumns(10);
		
		JPanel panelCustomer = new JPanel();
		panelAtBottom.add(panelCustomer);
		GridBagLayout gbl_panelCustomer = new GridBagLayout();
		gbl_panelCustomer.columnWidths = new int[]{0, 0, 0};
		gbl_panelCustomer.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelCustomer.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelCustomer.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCustomer.setLayout(gbl_panelCustomer);
		
		textFindCustomer = new JTextField();
		textFindCustomer.setText("Indsæt Tlf:");
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
		
		GridBagConstraints gbc_textFindCustomer = new GridBagConstraints();
		gbc_textFindCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_textFindCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFindCustomer.gridx = 0;
		gbc_textFindCustomer.gridy = 0;
		panelCustomer.add(textFindCustomer, gbc_textFindCustomer);
			
		btnNewCustomer = new JButton("Opret ny Kunde");
		GridBagConstraints gbc_btnNewCustomer = new GridBagConstraints();
		gbc_btnNewCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewCustomer.gridx = 1;
		gbc_btnNewCustomer.gridy = 0;
		panelCustomer.add(btnNewCustomer, gbc_btnNewCustomer);
		
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
					
				"Vare", "Pris", "Fjern"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1615048397567041604L;
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPaneLoan.setViewportView(tableLoan);

	}
	private void barcodeEntered() {
    	String barcode = txtFieldBarcode.getText();
        //LendableIF product = loanCtrl.addProduct(barcode);
        //TODO there are multiple missing parts like LoanCrtl not existing yet that needs doing
        //- before this can be finished!
        
        //loanTableModel.setData(saleCtrl.getLoan());
        
        //DefaultTableModel model = (DefaultTableModel) tableLoan.getModel();
        //model.addRow(new Object[]{product.getName(), 1, product.getPrice(LocalDateTime.now()), "???"});
        //setProductDescription(txtpnProductDescription);
        }

}
