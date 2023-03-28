package com.bbb.bankingapplication.util;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class AmountUtil {

    public static final String COMMA_DELIMITER_WITH_DECIMAL = "#,##0.00";
    public static final String COMMA_DELIMITER_WITHOUT_DECIMAL = "#,##0";
    public static final String NO_DELIMITER_WITH_DECIMAL = "#0.00";
    public static final String NO_DELIMITER_WITHOUT_DECIMAL = "#0";

    private AmountUtil() {
    }

    public static String formatAmount(BigDecimal value) {
        return formatAmount(value.doubleValue(), "#,##0.00");
    }

    public static String formatAmount(BigDecimal value, String format) {
        return formatAmount(value.doubleValue(), format);
    }

    public static String formatAmount(Double value) {
        return formatAmount(value, "#,##0.00");
    }

    public static String formatAmount(Double value, String format) {
        if (value != null && !StringUtils.isEmpty(format)) {
            DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
            dfs.setDecimalSeparator(',');
            dfs.setGroupingSeparator('.');
            DecimalFormat df = new DecimalFormat(format, dfs);
            return df.format(value);
        } else {
            return "";
        }
    }

    public static String formatAmount(Long value) {
        return formatAmount(value, "#,##0.00");
    }

    public static String formatAmountDivideHundred(Long value) {
        if (value != null && value != 0L) {
            BigDecimal bVal = (new BigDecimal(value)).divide(new BigDecimal(100));
            bVal = bVal.setScale(2, RoundingMode.HALF_UP);
            return formatAmount(bVal.doubleValue(), "#,##0.00");
        } else {
            return formatAmount(value, "#,##0.00");
        }
    }

    public static String formatAmount(Long value, String format) {
        if (value != null && !StringUtils.isEmpty(format)) {
            DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
            dfs.setDecimalSeparator(',');
            dfs.setGroupingSeparator('.');
            DecimalFormat df = new DecimalFormat(format, dfs);
            return df.format(value);
        } else {
            return "";
        }
    }

    public static String formatAmount(String value) {
        return formatAmount(Double.valueOf(value), "#,##0.00");
    }

    public static String formatAmount(String value, String format) {
        return formatAmount(Double.valueOf(value), format);
    }

    public static String formatAmountWithCurrency(BigDecimal value, String currency) {
        return currency + " " + formatAmount(value, "#,##0.00");
    }

    public static String formatAmountWithCurrency(BigDecimal value, String format, String currency) {
        return currency + " " + formatAmount(value, format);
    }

    public static String formatAmountWithCurrency(Double value, String currency) {
        return currency + " " + formatAmount(value, "#,##0.00");
    }

    public static String formatAmountWithCurrency(Double value, String format, String currency) {
        return currency + " " + formatAmount(value, format);
    }

    public static String formatAmountWithCurrency(Long value, String currency) {
        return currency + " " + formatAmount(value, "#,##0.00");
    }

    public static String formatAmountWithCurrency(Long value, String format, String currency) {
        return currency + " " + formatAmount(value, format);
    }

    public static String formatAmountWithCurrency(String value, String currency) {
        return currency + " " + formatAmount(value, "#,##0.00");
    }

    public static String formatAmountWithCurrency(String value, String format, String currency) {
        return currency + " " + formatAmount(value, format);
    }

    public static String formatAmount2(BigDecimal amount, String pattern) {
        if (amount != null && pattern != null && pattern.trim().length() != 0) {
            Locale currentLocale = Locale.getDefault();
            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
            otherSymbols.setDecimalSeparator('.');
            otherSymbols.setGroupingSeparator(',');
            DecimalFormat df = new DecimalFormat(pattern, otherSymbols);
            return df.format(amount);
        } else {
            return "";
        }
    }

    public static String formatAmount2(BigDecimal value) {
        return formatAmount2(value, "#,##0.00");
    }
}
