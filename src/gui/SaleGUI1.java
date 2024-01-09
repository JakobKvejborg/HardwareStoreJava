package gui;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

public class SaleGUI1 extends JFrame {
	
//	right-click and select 'Open with' > 'WindowBuilder Editor'

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SaleGUI1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("436px"),},
			new RowSpec[] {
				RowSpec.decode("263px"),}));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "1, 1, fill, fill");
		
		JPanel MainMenu = new JPanel();
		tabbedPane.addTab("Main Menu", null, MainMenu, null);
		GridBagLayout gbl_MainMenu = new GridBagLayout();
		gbl_MainMenu.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_MainMenu.rowHeights = new int[]{0, 0, 0, 0};
		gbl_MainMenu.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_MainMenu.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		MainMenu.setLayout(gbl_MainMenu);
		
		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 6;
		gbc_splitPane.gridy = 2;
		MainMenu.add(splitPane, gbc_splitPane);
		
		JPanel SaleMenu = new JPanel();
		tabbedPane.addTab("Sale Menu", null, SaleMenu, null);
		SaleMenu.setLayout(new BorderLayout(0, 0));
		
		JPanel north = new JPanel();
		SaleMenu.add(north, BorderLayout.NORTH);
		
		JPanel south = new JPanel();
		SaleMenu.add(south, BorderLayout.SOUTH);
		
		JPanel west = new JPanel();
		SaleMenu.add(west, BorderLayout.WEST);
		
		JPanel east = new JPanel();
		SaleMenu.add(east, BorderLayout.EAST);
		
		JPanel center = new JPanel();
		SaleMenu.add(center, BorderLayout.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		center.add(splitPane_1);

		JLabel lblNewLabel = new JLabel("New label");
		
		JPanel LoanMenu = new JPanel();
		tabbedPane.addTab("Loan Menu", null, LoanMenu, null);
		LoanMenu.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 10, 139, 19);
		LoanMenu.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Enter");
		btnNewButton_3.setBounds(148, 9, 57, 21);
		LoanMenu.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Færdiggør Salg");
		btnNewButton_4.setBounds(10, 205, 85, 21);
		LoanMenu.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Afbryd");
		btnNewButton_5.setBounds(97, 205, 85, 21);
		LoanMenu.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("Kunderabat");
		lblNewLabel_1.setBounds(10, 165, 73, 13);
		LoanMenu.add(lblNewLabel_1);
		
		table = new JTable();
		table.setBounds(10, 39, 195, 116);
		LoanMenu.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(239, 40, 45, 43);
		LoanMenu.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(239, 81, 45, 49);
		LoanMenu.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(239, 129, 45, 41);
		LoanMenu.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 162, 139, 19);
		LoanMenu.add(textField_3);
		
		JPanel LendMenu = new JPanel();
		tabbedPane.addTab("Lend Menu", null, LendMenu, null);
		LendMenu.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(162, 32, 85, 21);
		LendMenu.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(20, 111, 96, 67);
		LendMenu.add(textField);
		textField.setColumns(10);

	}
}
