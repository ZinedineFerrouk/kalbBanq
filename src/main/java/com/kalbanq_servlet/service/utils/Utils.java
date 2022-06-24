package com.kalbanq_servlet.service.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {
    private final static Locale LOCALE = Locale.FRANCE;
    private final static String DATE_FORMAT_PATTERN = "dd/MM/yyyy";
    /**
     * Return Date from String format "dd/MM/yyyy"
     *
     * @param dateString String
     * @return Date
     * @throws ParseException
     */
    public static Date dateFromString(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", LOCALE);
        Date date = formatter.parse(dateString);
        return date;
    }

    /**
     * Return String format "dd/MM/yyyy" from Date
     * @param date Date
     * @return String
     */
    public static String stringFromDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_PATTERN, LOCALE);
        String stringDate = formatter.format(date);
        return stringDate;
    }
}
