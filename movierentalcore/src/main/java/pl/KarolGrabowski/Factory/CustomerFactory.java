package pl.KarolGrabowski.Factory;

import pl.KarolGrabowski.Customer;

import java.text.ParseException;

/**
 * Created by jakubwrabel on 23/05/2017.
 *
 * Fabryka - klasa tworząca obiekty klasy {@link Customer}
 */
public class CustomerFactory implements MyFactory<Customer> {
    @Override
    public Customer create(String text) {
        try {
            return new Customer(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}