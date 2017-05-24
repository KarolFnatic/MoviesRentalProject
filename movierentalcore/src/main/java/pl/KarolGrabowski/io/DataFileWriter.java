package pl.KarolGrabowski.io;


import pl.KarolGrabowski.CsvObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataFileWriter {

    public static void writeObjectToFile(String fileName, List<? extends CsvObject> dataList) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            for (CsvObject csvObject : dataList) {
                fileWriter.write(csvObject.toCSVString() + System.lineSeparator());
            }

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}