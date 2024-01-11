package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GenerateTestDataPanel extends JPanel {

    private static final long serialVersionUID = 1L;


    /**
     * Create the panel.
     */
    public GenerateTestDataPanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(null);
        add(panel, BorderLayout.CENTER);

        JButton button1 = new JButton();
        panel.add(button1);
        button1.setPreferredSize(new Dimension(200, 80));
        button1.setText("Generate Test Data");


    }


}