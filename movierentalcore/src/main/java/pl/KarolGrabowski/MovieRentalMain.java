package pl.KarolGrabowski;

import pl.KarolGrabowski.Exceptions.MovieAlreadyExistsException;
import pl.KarolGrabowski.Exceptions.NullCustomerException;
import pl.KarolGrabowski.Exceptions.NullMovieException;

import java.util.Date;

public class MovieRentalMain {
    public static void main(String[] args) throws NullCustomerException, NullMovieException, MovieAlreadyExistsException {
        MovieRental movieRental = new MovieRental();
        movieRental.printAllData();
        System.out.println("---DODAJ KLIENTA---");
        movieRental.addCustomer(new Customer("1234", "Adam", "Kowalski", "Wrocław",new Date()));
        System.out.println("----DODAJ FILM---");
        movieRental.addMovie(new Movie("Transformers", "SciFi","bla"));

        movieRental.printAllData();

        movieRental.saveCustomersToFile();
    }
}