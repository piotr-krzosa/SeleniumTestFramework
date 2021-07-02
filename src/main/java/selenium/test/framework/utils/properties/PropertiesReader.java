package selenium.test.framework.utils.properties;

import selenium.test.framework.utils.logger.CustomLogger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public Properties readProperties(String filePath) {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        try {
            properties.load(inputStream);
            CustomLogger.info("Properties file '" + filePath + "' was read");
        } catch (IOException e) {
            e.printStackTrace();
            CustomLogger.error("Properties file '" + filePath + "' read failed!");
        }
        return properties;
    }
}
