package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import controller.ProductCtrl;
import model.AbstractProduct;
import model.LeaseableIF;
import model.OrderContainer;
import model.ProductContainer;
import model.Sale;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ProductsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textBarcode;
	private JTable table;
	private JButton btnBarcodeEnter;
	private ProductTable productTable;
	private static String[] COL_NAMES = { "Vare", "Antal", "Pris", "Rabat", "Fjern" };
	private ProductCtrl productCtrl;

	private class ProductTable extends AbstractTableModel {

		private ArrayList<AbstractProduct> products;

		@Override
		public String getColumnName(int col) {
			return COL_NAMES[col];
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return ProductContainer.getInstance().getProducts().size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 5;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		public void setData(ArrayList<AbstractProduct> products) {
			if (products == null) {
				products = new ArrayList<>();
			}
			this.products = products;
			super.fireTableDataChanged();
		}

	
	}

	/**
	 * Create the panel.
	 */
	public ProductsPanel() {
		setBorder(new EmptyBorder(10, 10, 35, 10));
		setLayout(new BorderLayout(0, 0));
		setVisible(true);
		
		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		textBarcode = new JTextField();
		panel_1.add(textBarcode, BorderLayout.CENTER);
		textBarcode.setText("Indtast stregkode");
		textBarcode.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == 10) {
//        			barcodeEntered();
        		}
        	}
        });
		
		panel_1.add(textBarcode, BorderLayout.CENTER);
		textBarcode.setColumns(10);
		textBarcode.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
//					barcodeEntered();
				}
			}
		});
		
		btnBarcodeEnter = new JButton("Enter");
		btnBarcodeEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productTable.setData(ProductContainer.getInstance().getProducts()); 
//					barcodeEntered();

			
//		JButton btnEnter = new JButton("Find produkt");
//		btnEnter.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				productTable.setData(ProductContainer.getInstance().getProducts()); // updates the jtable
////				barcodeEntered()
//			}
		}
		});
		panel_1.add(btnBarcodeEnter, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{108, 85, 85, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 21, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnAddProduct = new JButton("Tilføj nyt produkt      ");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateProductWindow createProductWindow = new CreateProductWindow(productCtrl);
				createProductWindow.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAddProduct = new GridBagConstraints();
		gbc_btnAddProduct.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddProduct.gridx = 0;
		gbc_btnAddProduct.gridy = 0;
		panel_2.add(btnAddProduct, gbc_btnAddProduct);
		
		JButton btnAddLoanProduct = new JButton("Tilføj udlånsprodukt");
		GridBagConstraints gbc_btnAddLoanProduct = new GridBagConstraints();
		gbc_btnAddLoanProduct.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddLoanProduct.gridx = 1;
		gbc_btnAddLoanProduct.gridy = 0;
		panel_2.add(btnAddLoanProduct, gbc_btnAddLoanProduct);
		
		JButton btnAddLeasingProduct = new JButton("Tilføj leasingprodukt");
		GridBagConstraints gbc_btnAddLeasingProduct = new GridBagConstraints();
		gbc_btnAddLeasingProduct.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddLeasingProduct.gridx = 2;
		gbc_btnAddLeasingProduct.gridy = 0;
		panel_2.add(btnAddLeasingProduct, gbc_btnAddLeasingProduct);
		
		JButton btnAddUniqueProduct = new JButton("Tilføj garantiprodukt");
		GridBagConstraints gbc_btnAddUniqueProduct = new GridBagConstraints();
		gbc_btnAddUniqueProduct.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddUniqueProduct.gridx = 0;
		gbc_btnAddUniqueProduct.gridy = 1;
		panel_2.add(btnAddUniqueProduct, gbc_btnAddUniqueProduct);
		
		JButton btnAddCompositeProduct = new JButton("Tilføj produktpakke  ");
		GridBagConstraints gbc_btnAddCompositeProduct = new GridBagConstraints();
		gbc_btnAddCompositeProduct.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddCompositeProduct.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAddCompositeProduct.gridx = 1;
		gbc_btnAddCompositeProduct.gridy = 1;
		panel_2.add(btnAddCompositeProduct, gbc_btnAddCompositeProduct);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		productTable = new ProductTable();
		table = new JTable(50, 5);
		table.setModel(productTable);
		scrollPane.setViewportView(table);
		
		
		JPanel panel_4 = new JPanel();
		splitPane.setRightComponent(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblProductLabel = new JLabel("Produkt");
		lblProductLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblProductLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1, BorderLayout.CENTER);
		
		JTextPane txtpnVarensBeskrivelseHer = new JTextPane();
		txtpnVarensBeskrivelseHer.setText("Varens beskrivelse her.");
		txtpnVarensBeskrivelseHer.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane_1.setViewportView(txtpnVarensBeskrivelseHer);

		textBarcode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (!textBarcode.getText().isEmpty()) {
					textBarcode.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textBarcode.getText().isEmpty()) {
					textBarcode.setText("Indtast stregkode");
				}
			}
		});

		
	}
}