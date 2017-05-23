package pl.KarolGrabowski;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;


public class DataFileReader {
    public static List<Customer> readCustomersFromFile(String fileName) throws IOException {

        List<String> fileLines = Files.readLines(new File(fileName), Charsets.UTF_8);



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