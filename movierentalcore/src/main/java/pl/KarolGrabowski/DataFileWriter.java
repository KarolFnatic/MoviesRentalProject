package pl.KarolGrabowski;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataFileWriter {
    public static void writeObjectToFile(String fileName, List<CsvObject> dataList) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            for (CsvObject csvObject : dataList) {
                fileWriter.write(CsvObject.toCSVString() + System.lineSeparator());
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}