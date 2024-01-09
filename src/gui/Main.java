package gui;

import model.Employee;
import model.Location;
import model.Sale;
import tui.MainMenuTUI;


/**
 * Where the program is run from.
 * creates a dummy employee and starts the saleTUI with that employee.
 *
 * @author Penrose
 * @version 09/01/2023
 * @since 08/12/2023
 */
public class Main {

    public static void main(String[] args) {
        Employee user = new Employee("ProjectGroup", "UCN", "11234567", "noreply@UCN.dk", "PG");
        Location location = new Location("Hjem & Fix", "Pioner Alle 2");
        // MainMenuTUI mainMenuTUI = new MainMenuTUI(user, location); //OLD TUI
        SaleGUI saleGUI = new SaleGUI(user, location);

//		mainMenuTUI.start(); // OLD TUI
        saleGUI.setVisible(true); // NEW GUI

    }
}
