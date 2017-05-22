package pl.KarolGrabowski;

import org.junit.Test;
import pl.KarolGrabowski.Exceptions.NullCustomerEcxeption;

import java.util.Date;

import static org.junit.Assert.*;

public class MovieRentalTest {
    @Test
    public void addCustomer_CorrectCase() throws NullCustomerEcxeption {
        //given
        MovieRental movieRental = new MovieRental();
        Customer customer = new Customer("1234", "Adam", "Kowalski", "Wrocław", new Date());
        //when
        movieRental.addCustomer(customer);
        //then
        assertEquals(1,movieRental.getCustomers().size());
        assertTrue(movieRental.getCustomers().contains(customer));
    }
    @Test(expected = NullCustomerEcxeption.class)
    public void addCustomer_NullCustomer() throws Exception {
        //given
        MovieRental movieRental = new MovieRental();
        Customer customer = null;
        //when
        movieRental.addCustomer(customer);
        //then
    }

}