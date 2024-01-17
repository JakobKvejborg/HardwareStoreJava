package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CustomerCtrl;
import controller.SaleCtrl;
import model.Customer;

public class CustomerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtFindCustomer;
	private SaleCtrl saleCtrl;
	private JTextField textAddress;
	private JTextField textName;
	private JButton btnCreateCustomer;
	private JTextField textPhone;
	private JTextField textEmail;
	private CustomerCtrl customerCtrl;

	/**
	 * Create the panel.
	 */
	public CustomerPanel(ActionEvent customerUpdatedEvent, CustomerCtrl customerCtrl) {

		createLayout();
	}

	private void createLayout() {
		
		GridBagLayout gbl_panelCenterSouthWest = new GridBagLayout();
		gbl_panelCenterSouthWest.columnWidths = new int[] { 0, 85, 0 };
		gbl_panelCenterSouthWest.rowHeights = new int[] { 0, 0, 28, 0 };
		gbl_panelCenterSouthWest.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelCenterSouthWest.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_panelCenterSouthWest);
		
		
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
				if (e.getKeyCode() == 10) {
					Customer customer = saleCtrl.setCustomer(txtFindCustomer.getText());
					textName.setText(customer.getName());
					textAddress.setText(customer.getAddress());
					textPhone.setText(customer.getPhone());
					textEmail.setText(customer.getEmail());
					txtFindCustomer.setText("");
					//customerUpdatedEvent.
				}
			}
		});

		GridBagConstraints gbc_txtFindCustomer = new GridBagConstraints();
		gbc_txtFindCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_txtFindCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFindCustomer.gridx = 0;
		gbc_txtFindCustomer.gridy = 0;
		add(txtFindCustomer, gbc_txtFindCustomer);
		txtFindCustomer.setColumns(10);

		btnCreateCustomer = new JButton("Opret ny kunde");
		GridBagConstraints gbc_btnCreateCustomer = new GridBagConstraints();
		gbc_btnCreateCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreateCustomer.gridx = 1;
		gbc_btnCreateCustomer.gridy = 0;
		add(btnCreateCustomer, gbc_btnCreateCustomer);

		btnCreateCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateCustomerWindow customerWindow = new CreateCustomerWindow(customerCtrl);
				customerWindow.setVisible(true);

				if (customerWindow.isOkClicked()) {
					Customer customer = saleCtrl.setCustomer(customerWindow.getPhone());
					if (customer != null) {
						textName.setText(customer.getName());
						textAddress.setText(customer.getAddress());
						textPhone.setText(customer.getPhone());
						textEmail.setText(customer.getEmail());
					}
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
		add(textName, gbc_textName);
		textName.setColumns(10);

		textAddress = new JTextField();
		textAddress.setText("Addresse");
		textAddress.setEditable(false);
		GridBagConstraints gbc_textAddress = new GridBagConstraints();
		gbc_textAddress.insets = new Insets(0, 0, 5, 0);
		gbc_textAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAddress.gridx = 1;
		gbc_textAddress.gridy = 1;
		add(textAddress, gbc_textAddress);
		textAddress.setColumns(10);

		textPhone = new JTextField();
		textPhone.setText("Telefon Nummer");
		textPhone.setEditable(false);
		GridBagConstraints gbc_textPhone = new GridBagConstraints();
		gbc_textPhone.insets = new Insets(0, 0, 0, 5);
		gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPhone.gridx = 0;
		gbc_textPhone.gridy = 2;
		add(textPhone, gbc_textPhone);
		textPhone.setColumns(10);

		textEmail = new JTextField();
		textEmail.setText("Email");
		textEmail.setEditable(false);
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 2;
		add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);	
	}

}
