package gui;

import model.Employee;
import model.Location;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class MainWindowTemp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowTemp frame = new MainWindowTemp();
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
	public MainWindowTemp() {

		Employee user = new Employee("ProjectGroup", "UCN", "11234567", "noreply@UCN.dk", "PG");
		Location location = new Location("Hjem & Fix", "Pioner Alle 2");
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Vestbjerg Byggecenter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 560);
		setSize(new Dimension(1600, 800));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelSaleMenu = new SaleMenuPanel(user, location); // maybe wrong "user, location"
		tabbedPane.addTab("Salg", null, panelSaleMenu, null);
		
		JPanel panelLoan = new LoanMenuPanel();
		tabbedPane.addTab("Lån", null, panelLoan, null);
		
		JPanel panelLease = new LeaseMenuPanel(user, location);
		tabbedPane.addTab("Lease", null, panelLease, null);
		
		JPanel productsPanel = new ProductsPanel();
		tabbedPane.addTab("Lagerstyring", productsPanel);
		
		JPanel panelTestData = new GenerateTestDataPanel(user, location); // TODO
		tabbedPane.addTab("Generer test data", null, panelTestData, null);
		
	}

}
