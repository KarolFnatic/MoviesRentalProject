package pl.KarolGrabowski.Factory;


import pl.KarolGrabowski.Movie;

import java.text.ParseException;

/**
 * Created by jakubwrabel on 23/05/2017.
 *
 * Fabryka - klasa tworząca obiekty klasy {@link Movie}
 */
public class MovieFactory implements MyFactory<Movie> {
    @Override
    public Movie create(String text) {
        try {
            return new Movie(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}