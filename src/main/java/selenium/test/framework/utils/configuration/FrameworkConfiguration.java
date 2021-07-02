package selenium.test.framework.utils.configuration;

import selenium.test.framework.utils.files.PathHelper;

public class FrameworkConfiguration {

    public static void configure(){
        System.setProperty("log4j.configurationFile", new PathHelper().getResourceFilePath(
                DefaultConfiguration.LOG4J_CONFIGURATION_FILE_PATH));
    }

}
