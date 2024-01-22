package gui;

import model.Employee;
import model.Location;
import tui.TryMe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateTestDataPanel extends JPanel {

    private Employee employee;
    private Location location;


    private static final long serialVersionUID = 1L;


    /**
     * Create the panel.
     */
    public GenerateTestDataPanel(Employee employee, Location location) {
        this.employee = employee;
        this.location = location;

        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(null);
        add(panel, BorderLayout.CENTER);

        JButton button1 = new JButton();
        panel.add(button1);
        button1.setPreferredSize(new Dimension(200, 80));
        button1.setText("Generate Test Data");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TryMe.createCustomers();
                TryMe.createProducts(location);
                button1.setEnabled(false);
            }
        });


    }


}