package pl.KarolGrabowski;

import pl.KarolGrabowski.Exceptions.MovieAlreadyExistException;
import pl.KarolGrabowski.Exceptions.NullCustomerException;
import pl.KarolGrabowski.Exceptions.NullMovieExceptions;

import java.util.ArrayList;
import java.util.List;


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

    public void addMovie(Movie movie) throws NullMovieExceptions, MovieAlreadyExistException {
        if (movie == null) {
            throw new NullMovieExceptions();
        }
        if (movies.contains(movie)){
            throw new MovieAlreadyExistException();
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
}