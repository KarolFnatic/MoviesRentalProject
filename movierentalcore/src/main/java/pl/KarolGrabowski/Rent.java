package pl.KarolGrabowski;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Rent implements CsvObject {
    public static final String CSV_SEPARATOR = ",";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    private int customerId;
    private int movieId;
    private Date date;

    /***
     * Konstruktor przyjmujący napis (Stringa) w formacie "0,0,2017-05-24" tj. "customerId,movieId,date"
     * Tworzy na podstawie tego Stringa obiekt klasy Rent o takich samych danych
     */
    public Rent(String text) throws ParseException {
        String[] split = text.split(CSV_SEPARATOR);

        this.customerId = Integer.parseInt(split[0]);
        this.movieId = Integer.parseInt(split[1]);

        String dateString = split[2];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        this.date = simpleDateFormat.parse(dateString);
    }

    /***
     * Konstruktor przyjmujący customerId i movieId, tworzy obiekt klasy Rent o takich wartościach
     */
    public Rent(int customerId, int movieId) {
        this.customerId = customerId;
        this.movieId = movieId;
        this.date = new Date();
    }

    /***
     * Metoda do zamiany wypożyczenia na napis (String) w formacie "0,0,2017-05-24" tj. "customerId,movieId,date"
     */
    public String toCSVString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(customerId);
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(movieId);
        stringBuilder.append(CSV_SEPARATOR);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        String formattedDate = simpleDateFormat.format(date);
        stringBuilder.append(formattedDate);

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "customerId: " + customerId + ", movieId: " + movieId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getMovieId() {
        return movieId;
    }

    public Date getDate() {
        return date;
    }
}