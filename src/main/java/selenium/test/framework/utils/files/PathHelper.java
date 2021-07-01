package selenium.test.framework.utils.files;

import java.io.File;
import java.nio.file.Paths;

public class PathHelper {

    public String getResourceFilePath(String fileName) {
        return Paths.get(new File(getClass().getClassLoader().getResource(fileName).getFile()).getAbsolutePath()).toString();
    }

    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }
}
