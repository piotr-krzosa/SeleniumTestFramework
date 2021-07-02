package selenium.test.framework.utils.data;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import selenium.test.framework.utils.files.PathHelper;
import selenium.test.framework.utils.logger.CustomLogger;

import java.io.FileReader;
import java.util.List;

public class CSVDataReader {

    public List<String[]> readCSVData(String filePath) {

        List<String[]> data = null;

        try {
            CSVReader csvReader = new CSVReaderBuilder(
                    new FileReader(new PathHelper().getResourceFilePath(filePath))
            ).withSkipLines(1).build();

            data = csvReader.readAll();
            CustomLogger.info("CSV data file '" + filePath + "' read successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            CustomLogger.info("CSV data file '" + filePath + "' read failed!");
        }

        return data;

    }

}
