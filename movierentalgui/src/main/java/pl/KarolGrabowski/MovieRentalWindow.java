package pl.KarolGrabowski;

import javax.swing.*;
import java.awt.*;

public class MovieRentalWindow extends JFrame {

    private JList<Customer> customerJList;
    private JList<Movie> movieJList;
    private JList<Rent> rentJList;
    private MovieRental movieRental;

    public MovieRentalWindow(MovieRental movieRental) throws HeadlessException {
        this.movieRental = movieRental;

        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        customerJList = new JList<>();
        add(customerJList);

        movieJList = new JList<>();
        add(movieJList);

        rentJList=new JList<>();
        add(rentJList);

        showCustomers();
    }

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
    public void showMovies() {
        // wyciągnięcie listy filmów z wypożyczalni
        java.util.List<Movie> movieList = movieRental.getMovies();

        // ZAMIANA LISTY FILMÓW NA TALBLICĘ FILMÓW
        Movie[] moviesArray = new Movie[][movieList.size()];
        for (int i = 0; i < moviesArray.length; i++) {
            moviesArray[i] = movieList.get(i);
        }

        // ZAMIANA LISTY KLIENTÓW NA TALBLICĘ KLIENTÓW - 2 sposób
        Customer[] customersArray2 = movieList.toArray(new Customer[movieList.size()]);

        // ustawienie tablicy klientów jako danych, które ma wyświetlać movieJList - Swingowa lista
        movieJList.setListData(moviesArray);
    }
    public void showRent() {
        // wyciągnięcie listy filmów z wypożyczalni
        java.util.List<Rent> rentList = movieRental.getRents();

        // ZAMIANA LISTY FILMÓW NA TALBLICĘ FILMÓW
        Rent[] rentsArray = new Rent[rentList.size()];
        for (int i = 0; i < rentsArray.length; i++) {
            rentsArray[i] = rentList.get(i);
        }

        // ZAMIANA LISTY KLIENTÓW NA TALBLICĘ KLIENTÓW - 2 sposób
        Customer[] customersArray2 = rentList.toArray(new Customer[rentList.size()]);

        // ustawienie tablicy klientów jako danych, które ma wyświetlać movieJList - Swingowa lista
        rentJList.setListData(rentsArray);
    }


}