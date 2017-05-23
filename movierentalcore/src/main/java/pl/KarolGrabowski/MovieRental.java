package pl.KarolGrabowski;


import pl.KarolGrabowski.Exceptions.MovieAlreadyExistsException;
import pl.KarolGrabowski.Exceptions.NullCustomerException;
import pl.KarolGrabowski.Exceptions.NullMovieException;

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
        this.customers = new ArrayList<>();
        this.rents = new ArrayList<>();
        this.movies = new ArrayList<>();
    }

    public void addCustomer(Customer customer) throws NullCustomerException {
        if (customer == null) {
            throw new NullCustomerException();
        }

        customers.add(customer);
    }

    public void addMovie(Movie movie) throws NullMovieException, MovieAlreadyExistsException {
        if (movie == null) {
            throw new NullMovieException();
        }

        if(movies.contains(movie)){
            throw new MovieAlreadyExistsException();
        }

        movies.add(movie);
    }

    public void addRent(Rent rent){
        // TODO handle errors
        rents.add(rent);
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

    public void printAllData(){
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
    }
}