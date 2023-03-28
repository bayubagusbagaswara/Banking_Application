package com.bbb.bankingapplication.util;

import java.util.regex.Pattern;

public class Utils {

    public static boolean isPhoneEligible(String phone) {
        boolean ret = true;
        if (phone.startsWith("08") || phone.startsWith("62")) {
            return ret;
        }
        return false;
    }

    // change 08 to 62
    public static String substitutePhonePrefix(String phone) {
        if (phone.startsWith("08")) return "62".concat(phone.substring(1));
        return phone;
    }

    // masking hanya 4 digit belakang yang ditampilkan
    public static String mask(String input) {
        String result = null;

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

    public static Boolean isEmail(String proxy){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (proxy == null) return false;
        return pat.matcher(proxy).matches();
    }
}
