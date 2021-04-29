package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateHelper {
    public DateHelper() {
    }

    public static Date currentGMTTime() {
        return new Date();
    }

    public static String getDateDisplayString(TimeZone tz, Long time) {
        return time == null ? null : getDateDisplayString(tz, new Date(time));
    }

    public static String getDateDisplayString(TimeZone tz, Date time) {
        return time == null ? null : getDateDisplayString(tz, time, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateDisplayString(TimeZone tz, Long time, String formatString) {
        return time == null ? null : getDateDisplayString(tz, new Date(time), formatString);
    }

    public static String getDateDisplayString(TimeZone tz, Date time, String formatString) {
        if (time == null) {
            return null;
        } else {
            DateFormat df = new SimpleDateFormat(formatString);
            df.setTimeZone(tz);
            return df.format(time);
        }
    }

    public static Date parseDataString(String dateString, String formatString) {
        DateFormat df = new SimpleDateFormat(formatString);
        df.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            return df.parse(dateString);
        } catch (ParseException var4) {
            return null;
        }

    }
}