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

public class LoanPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtFieldBarcode;
	private JTable table;
	private JTextField textFieldFromDate;
	private JTextField textFieldToDate;
	private JTextField textFieldLoanDuration;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public LoanPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelFinalButtons = new JPanel();
		add(panelFinalButtons, BorderLayout.SOUTH);
		panelFinalButtons.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JButton btnNewButton = new JButton("New button");
		panelFinalButtons.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panelFinalButtons.add(btnNewButton_1);
		
		JPanel panelDescription = new JPanel();
		panelDescription.setBorder(new EmptyBorder(10, 0, 0, 10));
		add(panelDescription, BorderLayout.EAST);
		panelDescription.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDescriptionSidebar = new JPanel();
		panelDescription.add(panelDescriptionSidebar, BorderLayout.WEST);
		GridBagLayout gbl_panelDescriptionSidebar = new GridBagLayout();
		gbl_panelDescriptionSidebar.columnWidths = new int[]{10, 0};
		gbl_panelDescriptionSidebar.rowHeights = new int[]{10, 0, 0};
		gbl_panelDescriptionSidebar.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelDescriptionSidebar.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelDescriptionSidebar.setLayout(gbl_panelDescriptionSidebar);
		
		JPanel panelPicture = new JPanel();
		GridBagConstraints gbc_panelPicture = new GridBagConstraints();
		gbc_panelPicture.insets = new Insets(0, 0, 5, 0);
		gbc_panelPicture.anchor = GridBagConstraints.NORTHWEST;
		gbc_panelPicture.gridx = 0;
		gbc_panelPicture.gridy = 0;
		panelDescriptionSidebar.add(panelPicture, gbc_panelPicture);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 1;
		panelDescriptionSidebar.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panelDescription.add(scrollPane_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_6 = new JLabel("Vare Navn");
		scrollPane_1.setColumnHeaderView(lblNewLabel_6);
		
		JEditorPane dtrpnAccordingToAll = new JEditorPane();
		dtrpnAccordingToAll.setEditable(false);
		dtrpnAccordingToAll.setText("description\r\n");
		scrollPane_1.setViewportView(dtrpnAccordingToAll);
		
		JPanel panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(10, 10, 0, 0));
		add(panelMain, BorderLayout.CENTER);
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
		panelTotal.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Kunde Rabat:");
		panelTotal.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		panelTotal.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Total:");
		panelTotal.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panelTotal.add(textField_1);
		textField_1.setColumns(10);
		
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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.gridx = 0;
		gbc_formattedTextField.gridy = 0;
		panelKunde.add(formattedTextField, gbc_formattedTextField);
		
		JButton btnNewCustomer = new JButton("Ny Kunde");
		GridBagConstraints gbc_btnNewCustomer = new GridBagConstraints();
		gbc_btnNewCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewCustomer.gridx = 1;
		gbc_btnNewCustomer.gridy = 0;
		panelKunde.add(btnNewCustomer, gbc_btnNewCustomer);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panelKunde.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 1;
		panelKunde.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		panelKunde.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 2;
		panelKunde.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		panelMain.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
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
		scrollPane.setViewportView(table);

	}

}
