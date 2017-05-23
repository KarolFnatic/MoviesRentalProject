package pl.KarolGrabowski;

import java.text.ParseException;
import java.util.List;

public class DataFileReader {
    public static List<Customer> readCustomersFromFile(String fileName) {

        // TODO FIX!!!
        try {
            String line = "0,1234,Adam,Miauczyński,Wroclaw,2017-05-22";
            Customer customer = new Customer(line);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}