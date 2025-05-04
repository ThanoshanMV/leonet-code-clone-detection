package org.java.feature.extractor.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public final class MyCSVReader {
    
    public static List<String[]> readCSV (Reader reader) {
        CSVReader csvReader = new CSVReader(reader);
        try {
            List<String[]> list = csvReader.readAll();
            reader.close();
            csvReader.close();
            return list;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }
}
