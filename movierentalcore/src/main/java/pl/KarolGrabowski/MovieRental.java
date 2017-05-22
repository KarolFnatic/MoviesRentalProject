package pl.KarolGrabowski;

import pl.KarolGrabowski.Exceptions.NullCustomerEcxeption;

import java.util.ArrayList;
import java.util.List;

public class MovieRental {
    //</editor-fold>
    private List<Customer> customers;
    private List<Rent> rents;
    private List<Movie> movies;

    public MovieRental() {
        this.customers = new ArrayList<Customer>();
        this.movies = new ArrayList<Movie>();
        this.rents = new ArrayList<Rent>();
    }

    public void addCustomer(Customer customer) throws NullCustomerEcxeption {
        if (customer == null) {
            throw new NullCustomerEcxeption();
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
