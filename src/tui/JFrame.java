package tui;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
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

public class JFrame extends javax.swing.JFrame {
	
//	right-click and select 'Open with' > 'WindowBuilder Editor'

	private static final long serialVersionUID = 1L;
	private JTextField textField;

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
	public JFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("436px"),},
			new RowSpec[] {
				RowSpec.decode("263px"),}));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "1, 1, fill, fill");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Main Menu", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Sale Menu", null, panel, null);
						GridBagLayout gbl_panel = new GridBagLayout();
						gbl_panel.columnWidths = new int[]{424, 7, 0};
						gbl_panel.rowHeights = new int[]{19, 0, 0, 0};
						gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
						gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
						panel.setLayout(gbl_panel);
						
								JTextPane textPane = new JTextPane();
								GridBagConstraints gbc_textPane = new GridBagConstraints();
								gbc_textPane.insets = new Insets(0, 0, 5, 0);
								gbc_textPane.anchor = GridBagConstraints.WEST;
								gbc_textPane.gridx = 1;
								gbc_textPane.gridy = 0;
								panel.add(textPane, gbc_textPane);
								
								JPanel panel_4 = new JPanel();
								panel_4.setLayout(null);
								GridBagConstraints gbc_panel_4 = new GridBagConstraints();
								gbc_panel_4.insets = new Insets(0, 0, 0, 5);
								gbc_panel_4.fill = GridBagConstraints.BOTH;
								gbc_panel_4.gridx = 0;
								gbc_panel_4.gridy = 2;
								panel.add(panel_4, gbc_panel_4);
								
								JButton button = new JButton("New button");
								button.setBounds(58, 56, 85, 21);
								panel_4.add(button);

		JLabel lblNewLabel = new JLabel("New label");
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Loan Menu", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Lend Menu", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(162, 32, 85, 21);
		panel_3.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(20, 111, 96, 67);
		panel_3.add(textField);
		textField.setColumns(10);

	}
}
