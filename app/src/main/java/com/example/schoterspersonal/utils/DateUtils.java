package com.example.schoterspersonal.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    private static final String DATE_FORMAT_DDMMMYYYY = "dd MMM yyyy";

    private static final String PLACEHOLDER_SPACE = " ";

    private static final String IDENTIFIER_SPLIT_DATE_TIME = "T";

    private DateUtils() { }

    /**
     * get formatted date string from date string
     * @param dateString e.g. 2019-10-25T08:40:51.620Z
     * @return date string with format dd MMM yyyy hh:mm:ss e.g. 20 Oct 2019 08:40:51
     */
    public static String formatDateTime(String dateString) {
        String formattedDateTime;
        String[] temp = dateString.split(IDENTIFIER_SPLIT_DATE_TIME);
        temp[0] = getFormatDDMMMYYYYFromYYYY_MM_DD(temp[0]);
        temp[1] = temp[1].substring(0, 8);
        formattedDateTime = temp[0] + PLACEHOLDER_SPACE + temp[1];
        return formattedDateTime;
    }

    /**
     * get formatted date string from date string
     * @param dateString e.g. 2019-10-25
     * @return date string with format dd MMM yyyy e.g. 20 Oct 2019
     */
    private static String getFormatDDMMMYYYYFromYYYY_MM_DD(String dateString) {
        Date date = getDateUseYYYY_MM_DD(dateString);
        return getDateReturnFormatDDMMMYYYY(date);
    }

    /**
     * get date from date string
     * @param dateString e.g. 2019-10-25
     * @return date with format yyyy-MM-dd
     */
    private static Date getDateUseYYYY_MM_DD(String dateString) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD,
                Locale.ENGLISH);
            return simpleDateFormat.parse(dateString);
        } catch (Exception e) {
            return new Date();
        }
    }

    /**
     * get string date from date
     * @param date
     * @return string wit format dd MMM yyyy
     */
    private static String getDateReturnFormatDDMMMYYYY(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_DDMMMYYYY,
            Locale.ENGLISH);
        return simpleDateFormat.format(date);
    }

}
