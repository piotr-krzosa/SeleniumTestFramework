package selenium.test.framework.utils.files;

import org.apache.commons.io.FileUtils;
import selenium.test.framework.utils.logger.CustomLogger;

import java.io.File;
import java.io.IOException;

public class FileHelper {

    public static void copyFile(String fileToCopyPath, String destinationFilePath) {
        copyFile(new File(fileToCopyPath), new File(destinationFilePath));
    }

    public static void copyFile(File fileToCopy, String destinationFilePath) {
        copyFile(fileToCopy, new File(destinationFilePath));
    }

    public static void copyFile(File fileToCopy, File destinationFile) {
        try {
            FileUtils.copyFile(fileToCopy, destinationFile);
            CustomLogger.info("File '" + fileToCopy.getAbsolutePath() + "' was copied to '" + destinationFile.getAbsolutePath() + "'");
        } catch (IOException e) {
            e.printStackTrace();
            CustomLogger.error("File copy failed!");
        }
    }
}