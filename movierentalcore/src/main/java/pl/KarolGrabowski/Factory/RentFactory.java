package pl.KarolGrabowski.Factory;

import pl.KarolGrabowski.Rent;

import java.text.ParseException;

/**
 * Created by jakubwrabel on 23/05/2017.
 * <p>
 * Fabryka - klasa tworząca obiekty klasy {@link Rent}
 */
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