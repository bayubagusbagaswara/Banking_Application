package com.bbb.bankingapplication.util;

import com.bbb.bankingapplication.model.enumerator.Language;
import com.bbb.bankingapplication.model.enumerator.TransactionCurrency;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.bbb.bankingapplication.util.AppConstant.LOCALE_ENG;
import static com.bbb.bankingapplication.util.AppConstant.LOCALE_IDN;

public class ConstructorUtil {

    private static int length;

    private ConstructorUtil() {
    }

    final static DecimalFormat df = new DecimalFormat("#,###", new DecimalFormatSymbols(Locale.ITALIAN));

    // cek gender and convert
    public static String salutation(String gender, String language) {
        String salutation;
        if ("".equalsIgnoreCase(gender) || gender == null) {
            salutation = "";
        } else if (gender.equalsIgnoreCase("M") && Language.INDONESIA.getLanguageName().equals(language)) {
            salutation = "Bpk.";
        } else if (gender.equalsIgnoreCase("M") && Language.ENGLISH.getLanguageName().equals(language)) {
            salutation = "Mr.";
        } else if (gender.equalsIgnoreCase("F") && Language.INDONESIA.getLanguageName().equals(language)) {
            salutation = "Ibu";
        } else if (gender.equalsIgnoreCase("F") && Language.ENGLISH.getLanguageName().equals(language)) {
            salutation = "Ms.";
        } else {
            salutation = "";
        }
        return salutation;
    }

    public static String formatDateTime(long timeMillis, String language, String pattern) {
        var localDateTime = Instant.ofEpochMilli(timeMillis).atZone(ZoneId.systemDefault()).toLocalDateTime();
        var locale = Locale.getDefault();
        if (language.equals(Language.INDONESIA.getLanguageName())) {
            locale = new Locale("in", "ID");
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern, locale));
    }

    public static String checkingNullableValue(String object) {
        return StringUtils.isEmpty(object) ? "" : object;
    }

    public static String decimalFormatParser(BigDecimal nominal, String currency) {
        String result;
        nominal = nominal != null ? nominal : BigDecimal.valueOf(0);

        if(nominal.compareTo(BigDecimal.ZERO) == 0){
            result = currency + " 0,00";
        } else {
            result = currency +""+df.format(nominal);
        }
        return result;
    }

    public static String monthInIndo(int month) {
        switch (month) {
            case 0:
                return "Jan";
            case 1 :
                return "Feb";
            case 2 :
                return "Mar";
            case 3 :
                return "Apr";
            case 4 :
                return "Mei";
            case 5 :
                return "Jun";
            case 6 :
                return "Jul";
            case 7 :
                return "Agu";
            case 8 :
                return "Sep";
            case 9 :
                return "Okt";
            case 10 :
                return "Nov";
            case 11 :
                return "Des";
            default :
                return "";
        }
    }

    public static String monthInEng(int month) {
        switch (month) {
            case 0 :
                return "Jan";
            case 1 :
                return "Feb";
            case 2 :
                return "Mar";
            case 3 :
                return "Apr";
            case 4 :
                return "May";
            case 5 :
                return "Jun";
            case 6 :
                return "Jul";
            case 7 :
                return "Aug";
            case 8 :
                return "Sep";
            case 9 :
                return "Oct";
            case 10 :
                return "Nov";
            case 11 :
                return "Dec";
            default :
                return "";
        }
    }

    public static String monthFullNameInIndo(int month) {
        switch (month) {
            case 0:
                return "Januari";
            case 1 :
                return "Februari";
            case 2 :
                return "Maret";
            case 3 :
                return "April";
            case 4 :
                return "Mei";
            case 5 :
                return "Juni";
            case 6 :
                return "Juli";
            case 7 :
                return "Agustus";
            case 8 :
                return "September";
            case 9 :
                return "Oktober";
            case 10 :
                return "November";
            case 11 :
                return "Desember";
            default :
                return "";
        }
    }

    public static String monthFullNameInEng(int month) {
        switch (month) {
            case 0 :
                return "January";
            case 1 :
                return "February";
            case 2 :
                return "March";
            case 3 :
                return "April";
            case 4 :
                return "May";
            case 5 :
                return "June";
            case 6 :
                return "July";
            case 7 :
                return "August";
            case 8 :
                return "September";
            case 9 :
                return "October";
            case 10 :
                return "November";
            case 11 :
                return "December";
            default :
                return "";
        }
    }


    public static String constructDateWithTime(long dateTime, String language, boolean isFullName) {
        String dateConstruct;
        Date date = new Date(dateTime);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(dateTime));
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        String stringMonth = language.equals(Language.INDONESIA.getLanguageName()) ? monthInIndo(month) : monthInEng(month);
        if (isFullName) {
            stringMonth = language.equals(Language.INDONESIA.getLanguageName()) ? monthFullNameInIndo(month) : monthFullNameInEng(month);
        }

        dateConstruct = new SimpleDateFormat("dd").format(date.getTime()) + " " +
                (stringMonth) +
                " " + year + " " + new SimpleDateFormat("HH").format(date.getTime()) + ":"
                + new SimpleDateFormat("mm").format(date.getTime());
        return dateConstruct;
    }

    public static String constructDateWithOutTime(long dateTime, String language, boolean isFullName) {
        String dateConstruct;

        // convert long to Date
        Date date = new Date(dateTime);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(dateTime));
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        String stringMonth = language.equals(Language.INDONESIA.getLanguageName()) ? monthInIndo(month) : monthInEng(month);
        if (isFullName) {
            stringMonth = language.equals(Language.INDONESIA.getLanguageName()) ? monthFullNameInIndo(month) : monthFullNameInEng(month);
        }

        dateConstruct = new SimpleDateFormat("dd").format(date.getTime()) + " " + (stringMonth) + " " + year;
        return dateConstruct;
    }

    public static String constructDateOnlyYear(long dateTime, String language, boolean isFullName) {
        String dateConstruct;
        Date date = new Date(dateTime);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(dateTime));
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        String stringMonth = language.equals(Language.INDONESIA.getLanguageName()) ? monthInIndo(month) : monthInEng(month);

        if (isFullName) {
            stringMonth = language.equals(Language.INDONESIA.getLanguageName()) ? monthFullNameInIndo(month) : monthFullNameInEng(month);
        }

        dateConstruct = new SimpleDateFormat("yyyy").format(date.getTime());
        return dateConstruct;
    }

    public static String maskString(String text, int start, int end, char maskChar) {

        // jika variable text bernilai kosong
        if (text.isEmpty()) {
            return "";
        }

        if (start < 0) {
            start = 0;
        }

        if (start > end){
            return text;
        }

        int maskLength = end - start;

        if (maskLength == 0){
            return text;
        }

        StringBuilder sbMaskString = new StringBuilder(maskLength);
        for (int i = 0 ; i <maskLength ; i++) {
            sbMaskString.append(maskChar);
        }
        return (text.substring(0, start) + sbMaskString + text.substring(start + maskLength)).replaceAll("(.{" + 4 + "})", "$1 ").trim();
    }

    public static String constructDateOnlyTime(long dateTime) {
        Date date = new Date(dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
        String timezone = tz.getDisplayName(false, TimeZone.SHORT, new Locale("id", "ID"));

        return sdf.format(date).concat(" ").concat(timezone);
    }

    public static String mask(String input) {
        String result;
        if (input != null) {
            if (!input.isEmpty()) {
                result = input.replaceAll(".(?=.{4})", "*");
            }
            else {
                result = "";
            }
        }
        else {
            result = "";
        }

        return result;
    }

    public static String constructTransactionStatus(String transactionStatus) {
        String result;

        switch (transactionStatus) {
            case "SUCCESS" :
                result =  "Berhasil";
                break;
            case "FAILED" :
                result =  "Gagal";
                break;
            case "SUSPECT" :
                result =  "Tertunda";
                break;
            default :
                result = "";
                break;
        }

        return result;
    }

    public static String constructTransactionCategory(String transactionCategory){
        String result = "";

        switch (transactionCategory) {
            case "ZISWAF_ZAKAT" :
                result =  "Zakat";
                break;
            case "ZISWAF_INFAQ" :
                result =  "Infaq";
                break;
            case "ZISWAF_WAKAF" :
                result =  "Wakaf";
                break;
            case "ZISWAF_PAKET_PUASA" :
                result =  "Paket Berbuka & Sahur";
                break;
            default :
                var myStr= transactionCategory.replaceFirst("ZISWAF_","");
                myStr= myStr.replace("_"," ");

                while (myStr.charAt(0)==' ') {
                    myStr=myStr.substring(1);
                }

                // panjang string
                int myStrLength = myStr.length();

                for (int i = 0; i < myStrLength ; i++) {
                    if (i==0) {
                        String CharAt = "" + myStr.charAt(i);
                        result = result.concat(CharAt.toUpperCase()) ;
                    } else if (myStr.charAt(i-1) == ' ') {
                        String CharAt = "" + myStr.charAt(i);
                        result = result.concat(CharAt.toUpperCase()) ;
                    } else {
                        String CharAt = "" + myStr.charAt(i);
                        result = result.concat(CharAt.toLowerCase());
                    }
                }
                break;
        }
        return result;
    }

    public static String constructSubject(String subject, String transactionCategory, String transactionStatus){
        return subject.concat(" ")
                .concat(constructTransactionCategory(transactionCategory)).concat(" ")
                .concat(constructTransactionStatus(transactionStatus));
    }

    public static String constructSubject(String subject, String transactionStatus){
        return subject.concat(" ")
                .concat(" ")
                .concat(constructTransactionStatus(transactionStatus));
    }

    public static Map<String, Object> mapRemoveSpecialCharacter(Map<String, Object> data){
        Map<String, Object> response = new HashMap<>();

        for (Map.Entry<String, Object> s : data.entrySet()) {
            String key = s.getKey();
            response.put(key.replaceAll("[^a-zA-Z0-9]", ""), s.getValue());
        }

        return response;
    }

    public static String constructDateOnlyTime(long dateTime, String language) {
        language = !StringUtils.isEmpty(language) ? language : Language.INDONESIA.getLanguageName();

        Date date = new Date(dateTime);
        SimpleDateFormat sdf = null;
        String timezone = null;
        Locale locale = Locale.getDefault();
        String pattern = "HH:mm:ss";

        if (Language.INDONESIA.getLanguageName().equals(language)) {
            sdf = new SimpleDateFormat(pattern, LOCALE_IDN);
            TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
            timezone = tz.getDisplayName(false, TimeZone.SHORT, LOCALE_IDN);
        } else if (Language.ENGLISH.getLanguageName().equals(language)) {
            sdf = new SimpleDateFormat(pattern, LOCALE_ENG);
            TimeZone tz = TimeZone.getTimeZone(ZoneId.systemDefault());
            timezone = tz.getDisplayName(false, TimeZone.SHORT, LOCALE_ENG);
        } else {
            sdf = new SimpleDateFormat(pattern, locale);
            TimeZone tz = TimeZone.getTimeZone(ZoneId.systemDefault());
            timezone = tz.getDisplayName(false, TimeZone.SHORT, locale);
        }

        return sdf.format(date).concat(" ").concat(timezone);
    }

    public static String constructDateWithOutTime(long dateTime, String pattern, String language) {
        language = !StringUtils.isEmpty(language) ? language : Language.INDONESIA.getLanguageName();
        pattern = !StringUtils.isEmpty(pattern) ? pattern : "dd MMM yyyy";
        Date date = new Date(dateTime);
        SimpleDateFormat sdf = null;
        Locale locale = Locale.getDefault();

        if (Language.INDONESIA.getLanguageName().equals(language)) {
            sdf = new SimpleDateFormat(pattern, LOCALE_IDN);
        } else if (Language.ENGLISH.getLanguageName().equals(language)) {
            sdf = new SimpleDateFormat(pattern, LOCALE_ENG);
        } else {
            sdf = new SimpleDateFormat(pattern, locale);
        }

        return sdf.format(date);
    }


    public static String formatAmount(String language, BigDecimal amount, Boolean isSymbol, Boolean isSpacingSymbolAndAmount, Boolean isDecimal) {
        // reference : https://stackoverflow.com/questions/6670337/need-space-between-currency-symbol-and-amount
        amount = amount != null ? amount : BigDecimal.ZERO;
        language = !StringUtils.isEmpty(language) ? language : Language.INDONESIA.getLanguageName();

        Locale locale = Locale.getDefault();

        if (Language.INDONESIA.getLanguageName().equals(language)) {
            locale = LOCALE_IDN;
        } else if (Language.ENGLISH.getLanguageName().equals(language)) {
            locale = LOCALE_ENG;
        }

        String symbol = Currency.getInstance(locale).getSymbol(locale);
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(locale);
        decimalFormat.setGroupingUsed(true);

        if (isSymbol) {
            if (isSpacingSymbolAndAmount) {
                decimalFormat.setPositivePrefix(symbol + " ");
                decimalFormat.setNegativePrefix("-" + symbol + " ");
            } else {
                decimalFormat.setPositivePrefix(symbol + "");
                decimalFormat.setNegativePrefix("-" + symbol + "");
            }
        } else {
            decimalFormat.setPositivePrefix("");
            decimalFormat.setNegativePrefix("-");
        }

//        if (isRounding) {
//            decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);
//        } else {
//            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
//        }

        if (isDecimal) {
            decimalFormat.setMinimumFractionDigits(2);
            decimalFormat.setMaximumFractionDigits(2);
        } else {
            decimalFormat.setMinimumFractionDigits(0);
            decimalFormat.setMaximumFractionDigits(0);
        }

        return decimalFormat.format(amount);
    }

    public static String checkStringIsNull(String res, String defaultRes) {
        String result = null;
        if (!StringUtils.isEmpty(res)) {
            result = res;
        } else {
            result = defaultRes;
        }

        return result;
    }

    public static BigDecimal checkBigDecimalIsNull(BigDecimal req) {
        BigDecimal result = null;
        if (req != null) {
            result = req;
        } else {
            result = BigDecimal.ZERO;
        }

        return result;
    }

    public static String constructAmountDisplay(String currency, BigDecimal amount, Boolean flagWithSymbol){
        String symbol = currency;
        String amountDisplay = amount.toPlainString();
        if(TransactionCurrency.IDR.name().equalsIgnoreCase(currency)){
            symbol = Currency.getInstance(TransactionCurrency.IDR.name()).getSymbol(LOCALE_IDN);
        }

        BigDecimal amount1 = new BigDecimal(amount.toPlainString());

//        int scale = amount1.stripTrailingZeros().scale();
        int scale = amount1.toPlainString().indexOf(".") != -1 ? Integer.valueOf(amount1.toPlainString().substring(amount1.toPlainString().indexOf(".") + 1).length()) : Integer.valueOf(BigDecimal.ZERO.toPlainString());

        String formatAmount = AmountUtil.COMMA_DELIMITER_WITHOUT_DECIMAL;
        if(scale > 0){
            formatAmount = AmountUtil.COMMA_DELIMITER_WITH_DECIMAL;
        }
        amountDisplay = AmountUtil.formatAmount(amount1, formatAmount);

        if(flagWithSymbol){
            return symbol.concat(" ").concat(amountDisplay);
        }

        return amountDisplay;
    }


}
