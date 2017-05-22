package pl.KarolGrabowski;

import java.util.Date;

public class Rent {
    private int customerID;
    private int movieID;
    private Date date;

    public Rent(int customerID, int movieID) {
        this.customerID = customerID;
        this.movieID = movieID;
        this.date = new Date();
    }
    public int getCustomerID() {
        return customerID;
    }
    public int getMovieID() {
        return movieID;
    }
    public Date getDate() {
        return date;
    }
}
