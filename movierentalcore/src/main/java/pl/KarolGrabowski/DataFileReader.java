package pl.KarolGrabowski;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class DataFileReader {
    public static List<Customer> readCustomersFromFile(String fileName) throws IOException {
        List<Customer> customers = new ArrayList<>();

        try {
            List<String> fileLines = Files.readLines(new File(fileName), Charsets.UTF_8);

            for (String line : fileLines) {
                Customer customer = new Customer(line);
                customers.add(customer);
            }
        } catch (ParseException e) {
            throw new IOException();
        }

        return customers;
    }

}