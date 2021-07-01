package selenium.test.framework.utils.files;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileHelper {

    public static void copyFile(File fileToCopy, String destinationFilePath) {
        copyFile(fileToCopy, new File(destinationFilePath));
    }

    public static void copyFile(File fileToCopy, File destinationFile) {
        try {
            FileUtils.copyFile(fileToCopy, destinationFile);
            // TODO log
        } catch (IOException e) {
            e.printStackTrace();
            // TODO log
        }
    }
}