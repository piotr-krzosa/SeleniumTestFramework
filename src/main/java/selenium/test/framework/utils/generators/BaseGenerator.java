package selenium.test.framework.utils.generators;

import java.util.Date;
import java.util.Random;

public class BaseGenerator {

    public static Date getRandomDate() {
        // TODO date generator - date between startDate and endDate
        return new Date();
    }

    public static boolean getRandomBoolean() {
        return new Random().nextBoolean();
    }

    // TODO check why timestamp is not unique
    public static String getTimestamp() {
        return String.valueOf(new Date().getTime());
    }

    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public static String getRandomString(int length) {
        char[] chars = "qwertyuiopasdfghjklzxcvbnmęóąśłżźćń ".toCharArray();

        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}