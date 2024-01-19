package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CustomerCtrl;
import controller.ProductCtrl;
import model.AbstractProduct;
import model.Customer;

public class CreateProductWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JLabel lblErrorLabelCCW;
	private ProductCtrl productCtrl;
	private AbstractProduct product = null;
	private boolean okClicked = false;
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	private JTextField textFieldBarcode;
	private JTextField textFieldPurchasePrice;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			CreateProductWindow dialog = new CreateProductWindow();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public CreateProductWindow(ProductCtrl productCtrl) {
		setResizable(false);
		setModal(true);
		this.productCtrl = productCtrl;
		createLayout();
	}
			private void createLayout() {
				setTitle("Opret nyt produkt");
				setBounds(100, 100, 555, 405);
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
					textFieldName = new JTextField();
					GridBagConstraints gbc_txtFieldName = new GridBagConstraints();
					gbc_txtFieldName.insets = new Insets(0, 0, 5, 0);
					gbc_txtFieldName.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtFieldName.gridx = 1;
					gbc_txtFieldName.gridy = 0;
					contentPanel.add(textFieldName, gbc_txtFieldName);
					textFieldName.setColumns(10);
				}
				{
					textFieldName = new JTextField();
					GridBagConstraints gbc_textFieldName = new GridBagConstraints();
					gbc_textFieldName.insets = new Insets(0, 0, 5, 0);
					gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
					gbc_textFieldName.gridx = 1;
					gbc_textFieldName.gridy = 0;
					contentPanel.add(textFieldName, gbc_textFieldName);
					textFieldName.setColumns(10);
				}
				{
					JLabel lblDescription = new JLabel("Beskrivelse:");
					GridBagConstraints gbc_lblDescription = new GridBagConstraints();
					gbc_lblDescription.anchor = GridBagConstraints.EAST;
					gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
					gbc_lblDescription.gridx = 0;
					gbc_lblDescription.gridy = 1;
					contentPanel.add(lblDescription, gbc_lblDescription);
				}
				{
					textFieldDescription = new JTextField();
					GridBagConstraints gbc_txtFieldAddress = new GridBagConstraints();
					gbc_txtFieldAddress.insets = new Insets(0, 0, 5, 0);
					gbc_txtFieldAddress.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtFieldAddress.gridx = 1;
					gbc_txtFieldAddress.gridy = 1;
					contentPanel.add(textFieldDescription, gbc_txtFieldAddress);
					textFieldDescription.setColumns(10);
				} 
				{
					textFieldDescription = new JTextField();
					GridBagConstraints gbc_textFieldDescription = new GridBagConstraints();
					gbc_textFieldDescription.insets = new Insets(0, 0, 5, 0);
					gbc_textFieldDescription.fill = GridBagConstraints.HORIZONTAL;
					gbc_textFieldDescription.gridx = 1;
					gbc_textFieldDescription.gridy = 1;
					contentPanel.add(textFieldDescription, gbc_textFieldDescription);
					textFieldDescription.setColumns(10);
				}
				{
					JLabel lblBarcode = new JLabel("Barkode:");
					GridBagConstraints gbc_lblBarcode = new GridBagConstraints();
					gbc_lblBarcode.anchor = GridBagConstraints.EAST;
					gbc_lblBarcode.insets = new Insets(0, 0, 5, 5);
					gbc_lblBarcode.gridx = 0;
					gbc_lblBarcode.gridy = 2;
					contentPanel.add(lblBarcode, gbc_lblBarcode);
				}
				{
					textFieldBarcode = new JTextField();
					GridBagConstraints gbc_txtFieldPhone = new GridBagConstraints();
					gbc_txtFieldPhone.insets = new Insets(0, 0, 5, 0);
					gbc_txtFieldPhone.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtFieldPhone.gridx = 1;
					gbc_txtFieldPhone.gridy = 2;
					contentPanel.add(textFieldBarcode, gbc_txtFieldPhone);
					textFieldBarcode.setColumns(10);
				}
				{
					textFieldBarcode = new JTextField();
					GridBagConstraints gbc_textFieldBarcode = new GridBagConstraints();
					gbc_textFieldBarcode.insets = new Insets(0, 0, 5, 0);
					gbc_textFieldBarcode.fill = GridBagConstraints.HORIZONTAL;
					gbc_textFieldBarcode.gridx = 1;
					gbc_textFieldBarcode.gridy = 2;
					contentPanel.add(textFieldBarcode, gbc_textFieldBarcode);
					textFieldBarcode.setColumns(10);
				}
				{
					JLabel lblPruchasePrice = new JLabel("Indkøbspris:");
					GridBagConstraints gbc_lblPruchasePrice = new GridBagConstraints();
					gbc_lblPruchasePrice.insets = new Insets(0, 0, 0, 5);
					gbc_lblPruchasePrice.anchor = GridBagConstraints.EAST;
					gbc_lblPruchasePrice.gridx = 0;
					gbc_lblPruchasePrice.gridy = 3;
					contentPanel.add(lblPruchasePrice, gbc_lblPruchasePrice);
				}
				{
					textFieldPurchasePrice = new JTextField();
					GridBagConstraints gbc_txtFieldEmail = new GridBagConstraints();
					gbc_txtFieldEmail.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtFieldEmail.gridx = 1;
					gbc_txtFieldEmail.gridy = 3;
					contentPanel.add(textFieldPurchasePrice, gbc_txtFieldEmail);
					{
						textFieldPurchasePrice = new JTextField();
						GridBagConstraints gbc_textFieldPurchasePrice = new GridBagConstraints();
						gbc_textFieldPurchasePrice.fill = GridBagConstraints.HORIZONTAL;
						gbc_textFieldPurchasePrice.gridx = 1;
						gbc_textFieldPurchasePrice.gridy = 3;
						contentPanel.add(textFieldPurchasePrice, gbc_textFieldPurchasePrice);
						textFieldPurchasePrice.setColumns(10);
					}
					textFieldPurchasePrice.setColumns(10);
				}
			}
				{

					JPanel buttonPane = new JPanel();
					buttonPane.setBorder(new EmptyBorder(0, 0, 5, 5));
					getContentPane().add(buttonPane, BorderLayout.SOUTH);
					
					JButton cancelButton = new JButton("Anuller");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cancelClicked();
						}
					});
					JButton okButton = new JButton("OK");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							okClicked();
						}
					});
					buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
					{
						lblErrorLabelCCW = new JLabel("");
						lblErrorLabelCCW.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
						lblErrorLabelCCW.setForeground(new Color(255, 0, 0));
						buttonPane.add(lblErrorLabelCCW);
					}
					{
						JPanel panel = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel.getLayout();
						flowLayout.setHgap(4);
						flowLayout.setVgap(0);
						buttonPane.add(panel);
					}
					okButton.setActionCommand("OK");
					{
						getRootPane().setDefaultButton(okButton);
						buttonPane.add(okButton);
					}
					{
						JPanel panel = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panel.getLayout();
						flowLayout.setHgap(2);
						flowLayout.setVgap(0);
						buttonPane.add(panel);
					}
					cancelButton.setActionCommand("Anuller");
					{
						buttonPane.add(cancelButton);
					}
				}
			

			public boolean isOkClicked() {
				return okClicked;
			}
			
			private void okClicked() {
				okClicked = true;

				if (textFieldName.getText().isEmpty() || textFieldDescription.getText().isEmpty() || textFieldBarcode.getText().isEmpty() || textFieldPurchasePrice.getText().isEmpty()) {
					lblErrorLabelCCW.setText("En fejl er opstået "); //TODO Change to other error message
				} else {
					setVisible(false);
					product = productCtrl.createProduct(textFieldName.getText(), textFieldDescription.getText(), textFieldBarcode.getText(), textFieldPurchasePrice.getText());
					this.dispose(); //TODO this.dispose() is causing errors
			}
		}

			public AbstractProduct getProduct() {
				return product;
			}

			private void cancelClicked() {
				okClicked = false;
				setVisible(false);
			}

			public String getName() {
				return textFieldName.getText();
			}
			
			public String getAddress() {
				return textFieldDescription.getText();
			}
			
			public String getPhone() {
				return textFieldBarcode.getText();
			}
			
			public String getEmail() {
				return textFieldPurchasePrice.getText();
			}
		}

	
}
