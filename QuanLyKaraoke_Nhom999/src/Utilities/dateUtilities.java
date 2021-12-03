package Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateUtilities {

    public static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("hh:mm:ss");

    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {
                DATE_FORMATER.applyPattern(pattern[0]);
            }
            if (date == null) {
                return dateUtilities.now();
            }
            return DATE_FORMATER.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            DATE_FORMATER.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = dateUtilities.now();
        }
        return DATE_FORMATER.format(date);
    }

    public static Date now() {
        return new Date();
    }
}
