package pl.KarolGrabowski.Factory;

import pl.KarolGrabowski.Customer;

import java.text.ParseException;

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