package pl.KarolGrabowski.Factory;

import pl.KarolGrabowski.Rent;

import java.text.ParseException;

public class RentFactory implements MyFactory<Rent> {
    @Override
    public Rent create(String text) {
        try {
            return new Rent(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}