package selenium.test.framework.utils.test;

import java.util.HashMap;

public class TestHelper {

    public static String getResultName(int status){
        HashMap<Integer, String> resultNames = new HashMap<Integer, String>();
        resultNames.put(1,"PASS");
        resultNames.put(2,"FAILURE");
        resultNames.put(3,"SKIP");

        return resultNames.get(status);
    }
}
