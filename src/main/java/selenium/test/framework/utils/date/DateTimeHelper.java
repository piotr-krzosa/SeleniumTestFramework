package selenium.test.framework.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHelper {

    public static String getDateInFormat(String format){
        return getDateInFormat(new Date(), format);
    }

    public static String getDateInFormat(Date date, String format){
        return new SimpleDateFormat(format).format(date);
    }

    public static String getDateInFormat(String timestamp, String format){
        Date date = new Date();
        date.setTime(Long.parseLong(timestamp));
        return getDateInFormat(date, format);
    }

    public static String removeSpecialSignsFromFormat(String format){
        return format.replaceAll(":","-");
    }
}
