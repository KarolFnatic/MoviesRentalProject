package pl.KarolGrabowski;

import pl.KarolGrabowski.Exceptions.NullCustomerException;
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