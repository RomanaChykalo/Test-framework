package util;

import lombok.extern.log4j.Log4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

@Log4j
public class CSVUtil {
    public static void writeDataToCSV(Object[][] datas, String filePath) {
        try {
            FileWriter out = new FileWriter(new File(filePath));
            try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader("email", "password"))) {
                Arrays.stream(datas).forEach((data) -> {
                    try {
                        printer.printRecord(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
    public static void deleteFile(String filePath){
        File file= new File(filePath);
        file.delete();
    }
}
