package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CustomerCtrl;
import model.Customer;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateCustomerWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFieldEmail;
	private JTextField txtFieldPhone;
	private JTextField txtFieldAddress;
	private JTextField txtFieldName;
	private CustomerCtrl customerCtrl;
	private Customer customer = null;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			CreateCustomerWindow dialog = new CreateCustomerWindow(new CustomerCtrl());
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public CreateCustomerWindow(CustomerCtrl customerCtrl) {
		setResizable(false);
		setModal(true);
		this.customerCtrl = customerCtrl;
		createLayout();
	}

	private void createLayout() {
		setTitle("Opret ny kunde");
		setBounds(100, 100, 320, 178);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 244, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblName = new JLabel("Navn:");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.EAST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 0;
			gbc_lblName.gridy = 0;
			contentPanel.add(lblName, gbc_lblName);
		}
		{
			txtFieldName = new JTextField();
			GridBagConstraints gbc_txtFieldName = new GridBagConstraints();
			gbc_txtFieldName.insets = new Insets(0, 0, 5, 0);
			gbc_txtFieldName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFieldName.gridx = 1;
			gbc_txtFieldName.gridy = 0;
			contentPanel.add(txtFieldName, gbc_txtFieldName);
			txtFieldName.setColumns(10);
		}
		{
			JLabel lblAdress = new JLabel("Adresse:");
			GridBagConstraints gbc_lblAdress = new GridBagConstraints();
			gbc_lblAdress.anchor = GridBagConstraints.EAST;
			gbc_lblAdress.insets = new Insets(0, 0, 5, 5);
			gbc_lblAdress.gridx = 0;
			gbc_lblAdress.gridy = 1;
			contentPanel.add(lblAdress, gbc_lblAdress);
		}
		{
			txtFieldAddress = new JTextField();
			GridBagConstraints gbc_txtFieldAddress = new GridBagConstraints();
			gbc_txtFieldAddress.insets = new Insets(0, 0, 5, 0);
			gbc_txtFieldAddress.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFieldAddress.gridx = 1;
			gbc_txtFieldAddress.gridy = 1;
			contentPanel.add(txtFieldAddress, gbc_txtFieldAddress);
			txtFieldAddress.setColumns(10);
		}
		{
			JLabel lblPhone = new JLabel("Telefon:");
			GridBagConstraints gbc_lblPhone = new GridBagConstraints();
			gbc_lblPhone.anchor = GridBagConstraints.EAST;
			gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
			gbc_lblPhone.gridx = 0;
			gbc_lblPhone.gridy = 2;
			contentPanel.add(lblPhone, gbc_lblPhone);
		}
		{
			txtFieldPhone = new JTextField();
			GridBagConstraints gbc_txtFieldPhone = new GridBagConstraints();
			gbc_txtFieldPhone.insets = new Insets(0, 0, 5, 0);
			gbc_txtFieldPhone.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFieldPhone.gridx = 1;
			gbc_txtFieldPhone.gridy = 2;
			contentPanel.add(txtFieldPhone, gbc_txtFieldPhone);
			txtFieldPhone.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("Email:");
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
			gbc_lblEmail.anchor = GridBagConstraints.EAST;
			gbc_lblEmail.gridx = 0;
			gbc_lblEmail.gridy = 3;
			contentPanel.add(lblEmail, gbc_lblEmail);
		}
		{
			txtFieldEmail = new JTextField();
			GridBagConstraints gbc_txtFieldEmail = new GridBagConstraints();
			gbc_txtFieldEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFieldEmail.gridx = 1;
			gbc_txtFieldEmail.gridy = 3;
			contentPanel.add(txtFieldEmail, gbc_txtFieldEmail);
			txtFieldEmail.setColumns(10);
		}
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					okClicked();
				}
			});
			okButton.setActionCommand("OK");
			
			JButton cancelButton = new JButton("Anuller");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancelClicked();
				}
			});
			cancelButton.setActionCommand("Anuller");

			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				getRootPane().setDefaultButton(okButton);
				buttonPane.add(okButton);
			}
			{

				buttonPane.add(cancelButton);
			}
		}
	}

	private void okClicked() {
//		if (txtFieldName.getText().equals("") || txtFieldAddress.getText().equals("") || txtFieldPhone.getText().equals("")
//				|| txtFieldEmail.getText().equals("")) {
//			//TODO complain about the textfields being empty
//		} else {
//			customer = customerCtrl.createCustomer(txtFieldName.getText(), txtFieldAddress.getText(),
//					txtFieldPhone.getText(), txtFieldEmail.getText());
			this.dispose();
//		}

	}

	public Customer getCustomer() {
		return customer;
	}

	private void cancelClicked() {
		this.dispose();
	}

	public String getName() {
		return txtFieldName.getText();
	}
	
	public String getAddress() {
		return txtFieldAddress.getText();
	}
	
	public String getPhone() {
		return txtFieldPhone.getText();
	}
	
	public String getEmail() {
		return txtFieldEmail.getText();
	}
}
