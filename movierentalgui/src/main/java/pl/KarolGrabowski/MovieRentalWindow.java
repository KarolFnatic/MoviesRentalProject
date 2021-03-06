package pl.KarolGrabowski;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by jakubwrabel on 24/05/2017.
 * <p>
 * Okno stworzone w Swingu do wyświetlania danych wypożyczalni filmów
 * </p>
 */
public class MovieRentalWindow extends JFrame {
    private JList<Customer> customerJList;
    private JList<Movie> movieJList;
    private JList<Rent> rentJList;

    private MovieRental movieRental;

    /***
     * Konstruktor klasy {@link MovieRentalWindow}, przyjmuje obiekt {@link MovieRental} - wypożyczalnię filmów
     * dla której ma być ustawione, "wypożyczalnię dla której ma być to okno"
     */
    public MovieRentalWindow(MovieRental movieRental) throws HeadlessException {
        this.movieRental = movieRental;

        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setTitle("Wypożyczalnia filmów");

        customerJList = new JList<>();
        customerJList.setPreferredSize(new Dimension(300, 200));
        add(customerJList);

        movieJList = new JList<>();
        movieJList.setPreferredSize(new Dimension(300, 200));
        add(movieJList);

        rentJList = new JList<>();
        rentJList.setPreferredSize(new Dimension(300, 200));
        add(rentJList);

        JButton btnAddCustomer = new JButton("Dodaj klienta");
        add(btnAddCustomer);

        JButton btnEditCustomer = new JButton("Edytuj klienta");
        add(btnEditCustomer);

        JButton btnAddMovie = new JButton("Dodaj film");
        add(btnAddMovie);

        JButton btneditMovie = new JButton("Edytuj film");
        add(btneditMovie);

        MovieRentalWindow movieRentalWindow = this;

        btnAddCustomer.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEditCustomerWindow(movieRental, movieRentalWindow, null);
            }
        });

        btnAddMovie.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddMovieWindow(movieRental,movieRentalWindow, null);
            }
        });

        btnEditCustomer.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer selectedCustomer = customerJList.getSelectedValue();

                if (selectedCustomer == null) {
                    JOptionPane.showMessageDialog(btnAddCustomer, "Nie wybrano klienta!");
                } else {
                    new AddEditCustomerWindow(movieRental, movieRentalWindow, selectedCustomer);
                }
            }
        });
        btneditMovie.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie selectedMovie = movieJList.getSelectedValue();

                if (selectedMovie ==null){
                    JOptionPane.showMessageDialog(btnAddMovie, "Nie wybrano filmu!");
                }else{
                    new AddMovieWindow(movieRental,movieRentalWindow,selectedMovie);
                }
            }
        });



        showCustomers();
        showMovies();
        showRents();
        repaint();
    }

    /***
     * Metoda main do stworzenia wypożyczalni i wyświetlenia dla niej okna
     */
    public static void main(String[] args) {
        MovieRental movieRental = new MovieRental();
        new MovieRentalWindow(movieRental);
    }

    /***
     * metoda wyciągająca wszystkich klientów z wypożyczalni i wyświetlająca ich w customerJList (liście w okienku)
     */
    public void showCustomers() {
        // wyciągnięcie listy klientów z wypożyczalni
        java.util.List<Customer> customerList = movieRental.getCustomers();

        // ZAMIANA LISTY KLIENTÓW NA TALBLICĘ KLIENTÓW
        Customer[] customersArray = new Customer[customerList.size()];
        for (int i = 0; i < customersArray.length; i++) {
            customersArray[i] = customerList.get(i);
        }

        // ZAMIANA LISTY KLIENTÓW NA TALBLICĘ KLIENTÓW - 2 sposób
        Customer[] customersArray2 = customerList.toArray(new Customer[customerList.size()]);

        // ustawienie tablicy klientów jako danych, które ma wyświetlać customerJList - Swingowa lista
        customerJList.setListData(customersArray);
    }

    /***
     * metoda wyciągająca wszystkie wypożyczenia z wypożyczalni i wyświetlająca je w rentsJList (liście w okienku)
     */
    public void showRents() {
        java.util.List<Rent> rentsList = movieRental.getRents();
        Rent[] rentsArray = rentsList.toArray(new Rent[rentsList.size()]);
        rentJList.setListData(rentsArray);
    }

    /***
     * metoda wyciągająca wszystkie filmy z wypożyczalni i wyświetlająca je w movieJList (liście w okienku)
     */
    public void showMovies() {
        java.util.List<Movie> movieList = movieRental.getMovies();
        Movie[] moviesArray = movieList.toArray(new Movie[movieList.size()]);
        movieJList.setListData(moviesArray);
    }
}