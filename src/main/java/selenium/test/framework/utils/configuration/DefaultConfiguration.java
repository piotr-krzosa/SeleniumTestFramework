package selenium.test.framework.utils.configuration;

public class DefaultConfiguration {

    public static String TIME_FORMAT = "HH:mm:ss";
    public static String DATE_FORMAT = "yyyy-MM-dd";
    public static String DATE_TIME_FORMAT = DATE_FORMAT + " " + TIME_FORMAT;

    public static String SCREENSHOTS_PATH = "/screenshots/";
    public static String REPORTS_PATH = "/reports/";
    public static String REPORTS_SCREENSHOT_PATH = "/screenshots/";

    public static String DRIVERS_PATH = "drivers/";
    public static String CONFIGURATION_PATH = "configuration/";

    public static String PROPERTIES_FILE_NAME = "base.properties";
    public static String PROPERTIES_FILE_PATH = CONFIGURATION_PATH + PROPERTIES_FILE_NAME;

    public static String LOG4J_CONFIGURATION_FILE_NAME = "log4j2.properties";
    public static String LOG4J_CONFIGURATION_FILE_PATH = CONFIGURATION_PATH + LOG4J_CONFIGURATION_FILE_NAME;

    public static String CHROME_DRIVER_FILE_NAME = "chromedriver.exe";
    public static String CHROME_DRIVER_FILE_PATH = DRIVERS_PATH + CHROME_DRIVER_FILE_NAME;

    public static String FIREFOX_DRIVER_FILE_NAME = "geckodriver.exe";
    public static String FIREFOX_DRIVER_FILE_PATH = DRIVERS_PATH + FIREFOX_DRIVER_FILE_NAME;
}
