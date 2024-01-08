package tui;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Desktop;

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

	private static final long serialVersionUID = 1L;
	private JTextField Barcode;

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
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Sale Menu", null, panel, null);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Barcode = new JTextField();
		panel.add(Barcode);
		Barcode.setColumns(10);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);

		JTextPane textPane = new JTextPane();
		panel.add(textPane);

		JLabel lblNewLabel = new JLabel("New label");
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Loan Menu", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Lend Menu", null, panel_3, null);

	}
}
