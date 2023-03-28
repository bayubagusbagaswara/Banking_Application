package com.bbb.bankingapplication.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Slf4j
public class DateUtil {

    public static Date constructDate(String dateString, String dateFormat, Locale locale) {
        try {
            return new SimpleDateFormat(dateFormat, locale).parse(dateString);
        } catch (ParseException e) {
            log.error("Failed parsing error", e);
        }
        return null;
    }

    public static String constructDateString(Date date, String dateFormat, Locale locale) {
        return new SimpleDateFormat(dateFormat, locale).format(date);
    }

    public static String constructDateString(String date, String dateFormatOri, String dateFormatDest, Locale locale) {
        return constructDateString(constructDate(date, dateFormatOri, locale), dateFormatDest, locale);
    }

    public static String convertToddMMyy(String date) {
        return convertDate(date, "uuuuMMdd", "dd/MM/uuuu");
    }

    public static String convertDate(String date, String patternOld, String patternNew) {
        return convertDate(date, patternOld, patternNew, getLocale());
    }

    public static String convertDate(String date, String patternOld, String patternNew, Locale locale) {
        return convertDate(date, patternOld, patternNew, getZoneIdLocal(), locale);
    }

    public static String convertDate(String date, String patternOld, String patternNew, String zoneId) {
        return convertDate(date, patternOld, patternNew, zoneId, getLocale());
    }

    public static String convertDate(String date, String patternOld, String patternNew, String zoneId, Locale locale) {
        return convertDate(date, patternOld, patternNew, getZoneId(zoneId), locale);
    }

    public static String convertDate(LocalDateTime date, String patternOld, String patternNew) {
        return convertDate(date, patternOld, patternNew, getLocale());
    }

    public static String convertDate(LocalDateTime date, String patternOld, String patternNew, Locale locale) {
        return convertDate(date, patternOld, patternNew, getZoneIdLocal(), locale);
    }

    public static String convertDate(LocalDateTime date, String patternOld, String patternNew, String zoneId) {
        return convertDate(date, patternOld, patternNew, zoneId, getLocale());
    }

    public static String convertDate(LocalDateTime date, String patternOld, String patternNew, String zoneId, Locale locale) {
        return convertDate(date, patternOld, patternNew, getZoneId(zoneId), locale);
    }

    public static String convertDate(LocalDateTime date, String patternOld, String patternNew, ZoneId zoneId, Locale locale) {
        String finalDate = null;
        try {
            if (date != null) {
                DateTimeFormatter fromFormatter = DateTimeFormatter.ofPattern(patternOld);
                finalDate = convertDate(date.format(fromFormatter), patternOld, patternNew, zoneId, locale);
            }
        } catch (Exception e) {
            System.out.println("error convertDate = " + e);
            finalDate = "";
        }

        return finalDate;
    }

    public static String convertDate(long millis, String patternOld, String patternNew) {
        return convertDate(millis, patternOld, patternNew, getLocale());
    }

    public static String convertDate(long millis, String patternOld, String patternNew, Locale locale) {
        return convertDate(millis, patternOld, patternNew, getZoneIdLocal(), locale);
    }

    public static String convertDate(long millis, String patternOld, String patternNew, String zoneId) {
        return convertDate(millis, patternOld, patternNew, zoneId, getLocale());
    }

    public static String convertDate(long millis, String patternOld, String patternNew, String zoneId, Locale locale) {
        return convertDate(millis, patternOld, patternNew, getZoneId(zoneId), locale);
    }

    public static String convertDate(long millis, String patternOld, String patternNew, ZoneId zoneId, Locale locale) {
        String finalDate = null;
        if (millis > 0) {
            LocalDateTime ldt = getDateFromMillis(millis);
            finalDate = convertDate(ldt, patternOld, patternNew, zoneId, locale);
        }

        return finalDate;
    }

    public static String convertDate(String date, String patternOld, String patternNew, ZoneId zoneId, Locale locale) {
        String finalDate = null;
        try {
            if (date != null) {
                DateTimeFormatter fromFormatter = DateTimeFormatter.ofPattern(patternOld);
                LocalDateTime formatedDate = LocalDateTime.parse(date, fromFormatter).atZone(getZoneIdLocal()).withZoneSameInstant(zoneId).toLocalDateTime();
                finalDate = convertDate(formatedDate, patternNew, zoneId, locale);
            }
        } catch (Exception e) {
            System.out.println("error convertDate = " + e);
            finalDate = "";
        }

        return finalDate;
    }

    public static String convertDate(LocalDateTime date, String patternNew, ZoneId zoneId, Locale locale) {
        String finalDate = null;
        try {
            if (date != null) {
                DateTimeFormatter toFormatter = DateTimeFormatter.ofPattern(patternNew, locale);
                finalDate = date.format(toFormatter);
            }
        } catch (Exception e) {
            System.out.println("error convertDate = " + e);
            finalDate = "";
        }

        return finalDate;
    }

    public static String formatCurrentDate(String pattern) {
        return formatCurrentDate(pattern, getLocale());
    }

    public static String formatCurrentDate(String pattern, Locale locale) {
        return formatCurrentDate(pattern, getZoneIdLocal(), locale);
    }

    public static String formatCurrentDate(String pattern, String zoneId) {
        return formatCurrentDate(pattern, zoneId, getLocale());
    }

    public static String formatCurrentDate(String pattern, String zoneId, Locale locale) {
        return formatCurrentDate(pattern, getZoneId(zoneId), locale);
    }

    public static String formatCurrentDate(String pattern, ZoneId zoneId, Locale locale) {
        String finalDate = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
            LocalDateTime now = getCurrentDate(zoneId);
            finalDate = formatter.format(now);
        } catch (Exception e) {
            System.out.println("error convertDate = " + e);
            finalDate = "";
        }


        return finalDate;
    }

    public static LocalDateTime getCurrentDate() {
        return getCurrentDate(getZoneIdLocal());
    }

    public static LocalDateTime getCurrentDate(String zoneId) {
        return getCurrentDate(getZoneId(zoneId));
    }

    public static LocalDateTime getCurrentDate(ZoneId zoneId) {
        return getDateFromMillis(getCurrentMillis(zoneId));
    }

    public static LocalDateTime getDateFromMillis(long millis) {
        return getDateFromMillis(millis, getZoneIdLocal());
    }

    public static LocalDateTime getDateFromMillis(long millis, String zoneId) {
        return getDateFromMillis(millis, getZoneId(zoneId));
    }

    public static LocalDateTime getDateFromMillis(long millis, ZoneId zoneId) {
        return Instant.ofEpochMilli(millis).atZone(zoneId).toLocalDateTime();
    }

    public static long getCurrentMillis() {
        return getCurrentMillis(getZoneIdLocal());
    }

    public static long getCurrentMillis(String zoneId) {
        return getCurrentMillis(getZoneId(zoneId));
    }

    public static long getCurrentMillis(ZoneId zoneId) {
        return LocalDateTime.now().atZone(zoneId).toInstant().toEpochMilli();
    }

    public static Locale getLocale() {
        return getLocale("in_ID");
    }

    public static Locale getLocale(String locale) {
        var localeSplit = locale.split("_");
        return getLocale(localeSplit[0], localeSplit[1]);
    }

    public static Locale getLocale(String locale1, String locale2) {
        return new Locale(locale1, locale2);
    }

    public static ZoneId getZoneIdLocal() {
        return ZoneId.systemDefault();
    }

    public static ZoneId getZoneId() {
        return getZoneId("Asia/Jakarta");
    }

    public static ZoneId getZoneId(String zoneId) {
        return ZoneId.of(zoneId);
    }

//    public static boolean isJSONValid(String test) {
//        try {
//            new JSONObject(test);
//        } catch (JsonEOFException ex) {
//            try {
//                new JSONArray(test);
//            } catch (JsonEOFException ex1) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static String convertToyyyyMMuu(String date) {
        return convertDate(date, "uuuuMMdd", "yyyyMMuu");
    }

}
