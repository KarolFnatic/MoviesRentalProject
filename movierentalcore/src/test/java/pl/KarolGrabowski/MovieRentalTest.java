package pl.KarolGrabowski;

import org.junit.Test;
import pl.KarolGrabowski.Exceptions.MovieAlreadyExistException;
import pl.KarolGrabowski.Exceptions.NullCustomerException;
import pl.KarolGrabowski.Exceptions.NullMovieExceptions;

import java.util.Date;

import static org.junit.Assert.*;

public class MovieRentalTest {
    @Test
    public void addMovie_NullMovie() throws Exception {
        //given
        MovieRental movieRental = new MovieRental();
        Movie movie = null;
        //when
        movieRental.addMovie(movie);
        //then
    }
    @Test
    public void addMovie_CorrectCase() throws NullMovieExceptions, MovieAlreadyExistException {
        //given
        MovieRental movieRental = new MovieRental();
        Movie movie = new Movie("Action", "Terminator", "bla");
        //when
        movieRental.addMovie(movie);
        //then
        assertEquals(1,movieRental.getMovies().size());
        assertTrue(movieRental.getMovies().contains(movie));
    }

    @Test
    public void addCustomer_CorrectCase() throws NullCustomerException {
        //given
        MovieRental movieRental = new MovieRental();
        Customer customer = new Customer("1234", "Adam", "Kowalski", "Wrocław", new Date());
        //when
        movieRental.addCustomer(customer);
        //then
        assertEquals(1,movieRental.getCustomers().size());
        assertTrue(movieRental.getCustomers().contains(customer));
    }
    @Test(expected = NullCustomerException.class)
    public void addCustomer_NullCustomer() throws Exception {
        //given
        MovieRental movieRental = new MovieRental();
        Customer customer = null;
        //when
        movieRental.addCustomer(customer);
        //then
    }
    @Test(expected = MovieAlreadyExistException.class)
    public void addMovie_duplicate() throws NullMovieExceptions, MovieAlreadyExistException {
        // given
        MovieRental movieRental = new MovieRental();
        Movie movie = new Movie("Action", "Terminator", "bla");

        // when
        movieRental.addMovie(movie);
        movieRental.addMovie(movie);
    }

}