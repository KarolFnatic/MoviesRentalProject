package pl.KarolGrabowski;


import pl.KarolGrabowski.Exceptions.MovieAlreadyExistsException;
import pl.KarolGrabowski.Exceptions.NullCustomerException;
import pl.KarolGrabowski.Exceptions.NullMovieException;
import pl.KarolGrabowski.Factory.CustomerFactory;
import pl.KarolGrabowski.Factory.MovieFactory;
import pl.KarolGrabowski.Factory.RentFactory;
import pl.KarolGrabowski.io.DataFileReader;
import pl.KarolGrabowski.io.DataFileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 22/05/2017.
 */
public class MovieRental {
    private List<Customer> customers;
    private List<Rent> rents;
    private List<Movie> movies;

    public MovieRental() {
        this.rents = new ArrayList<>();
        this.movies = new ArrayList<>();

        readDataFromFile();
    }

    private void readDataFromFile() {
        DataFileReader<Customer> customerDataFileReader = new DataFileReader<>(new CustomerFactory());

        try {
            this.customers = customerDataFileReader.readFromFile("customers.csv");
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania klientów z pliku");
            this.customers = new ArrayList<>();
        }

        DataFileReader<Movie> movieDataFileReader = new DataFileReader<>(new MovieFactory());

        try {
            this.movies = movieDataFileReader.readFromFile("movies.csv");
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania filmów z pliku");
            this.movies = new ArrayList<>();
        }

        DataFileReader<Rent> rentDataFileReader = new DataFileReader<>(new RentFactory());

        try {
            this.rents = rentDataFileReader.readFromFile("rents.csv");
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania wypożyczeń z pliku");
            this.rents = new ArrayList<>();
        }
    }

    public void addCustomer(Customer customer) throws NullCustomerException {
        if (customer == null) {
            throw new NullCustomerException();
        }

        customers.add(customer);
        saveCustomersToFile();
    }

    public void addMovie(Movie movie) throws NullMovieException, MovieAlreadyExistsException {
        if (movie == null) {
            throw new NullMovieException();
        }

        if (movies.contains(movie)) {
            throw new MovieAlreadyExistsException();
        }

        movies.add(movie);
        saveMoviesToFile();
    }

    public void addRent(Rent rent) {
        // TODO handle errors
        rents.add(rent);
        saveRentsToFile();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void printAllData() {
        System.out.println("====== WYPOŻYCZALNIA =====");
        System.out.println("--- CUSTOMERS ---");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        System.out.println("--- MOVIES ---");
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        System.out.println("--- RENTS ---");
        for (Rent rent : rents) {
            System.out.println(rent);
        }
        System.out.println("==========================");
    }

    public void saveCustomersToFile() {
        DataFileWriter.writeObjectToFile("customers.csv", customers);
    }

    public void saveMoviesToFile() {
        DataFileWriter.writeObjectToFile("movies.csv", movies);
    }

    public void saveRentsToFile() {
        DataFileWriter.writeObjectToFile("rents.csv", rents);
    }
}