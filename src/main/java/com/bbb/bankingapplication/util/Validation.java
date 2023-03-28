package com.bbb.bankingapplication.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Validation {

    private static final String NUMBER_PATTERN = ".*[0-9].*";
    private static final String LOWERCASE_PATTERN = ".*[a-z].*";
    private static final String UPPERCASE_PATTERN = ".*[A-Z].*";

    public static boolean isNumber(String strnum) {
        if (strnum == null) {
            return false;
        }
        try {
            int number = Integer.parseInt(strnum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isAlphaOrAlphaNumeric(String str) {
        if (str == null) {
            return false;
        }
        if ((str.matches(UPPERCASE_PATTERN) && str.matches(LOWERCASE_PATTERN)) || (str.matches(UPPERCASE_PATTERN) || str.matches(LOWERCASE_PATTERN)) ) {
            return true;
        } else {
            return str.matches(UPPERCASE_PATTERN) && str.matches(LOWERCASE_PATTERN) && str.matches(NUMBER_PATTERN);
        }
    }

    public static boolean isAlphaNumericWithAtLeastOneUpperCase(String str) {
        if (str == null) {
            return false;
        }
        return str.matches(UPPERCASE_PATTERN) && str.matches(NUMBER_PATTERN) && str.matches(LOWERCASE_PATTERN);
    }
}
