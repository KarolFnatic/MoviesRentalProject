package pl.KarolGrabowski.Factory;


import pl.KarolGrabowski.Movie;

import java.text.ParseException;

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