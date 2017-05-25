package pl.KarolGrabowski;
import pl.KarolGrabowski.Exceptions.NullCustomerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class AddEditCustomerWindow extends JFrame {
    private MovieRental movieRental;
    private MovieRentalWindow movieRentalWindow;
    private Customer customerToEdit;

    public AddEditCustomerWindow(MovieRental movieRental, MovieRentalWindow movieRentalWindow, Customer customerToEdit) throws HeadlessException {
        this.movieRental = movieRental;
        this.movieRentalWindow = movieRentalWindow;
        this.customerToEdit = customerToEdit;

        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setTitle("Dodaj/edytuj klienta");

        JLabel lblFirstName = new JLabel("Imię");
        add(lblFirstName);

        JTextField txtFirstName = new JTextField();
        txtFirstName.setPreferredSize(new Dimension(200, 50));
        add(txtFirstName);

        JLabel lblLastName = new JLabel("Nazwisko");
        add(lblLastName);

        JTextField txtLastName = new JTextField();
        txtLastName.setPreferredSize(new Dimension(200, 50));
        add(txtLastName);

        JLabel lblPesel = new JLabel("Pesel");
        add(lblPesel);

        JTextField txtPesel = new JTextField();
        txtPesel.setPreferredSize(new Dimension(200, 50));
        add(txtPesel);

        JLabel lblCity = new JLabel("Miasto");
        add(lblCity);

        JTextField txtCity = new JTextField();
        txtCity.setPreferredSize(new Dimension(200, 50));
        add(txtCity);

        JButton button = new JButton("Dodaj");
        add(button);

        if (customerToEdit != null) {
            txtCity.setText(customerToEdit.getCity());
            txtFirstName.setText(customerToEdit.getFirstName());
            txtLastName.setText(customerToEdit.getLastName());
            txtPesel.setText(customerToEdit.getPesel());
        }

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = txtFirstName.getText();
                String lastName = txtLastName.getText();
                String pesel = txtPesel.getText();
                String city = txtCity.getText();

                Customer customer = new Customer(pesel, firstName, lastName, city, new Date());
                try {
                    movieRental.addCustomer(customer);
                    movieRentalWindow.showCustomers();

                    JOptionPane.showMessageDialog(button, "Udało się stworzyć klienta!");
                } catch (NullCustomerException e1) {
                    e1.printStackTrace();
                }

                // Zamknięcie okna
                setVisible(false);
                dispose();

                movieRental.printAllData();
            }
        });

    }

}