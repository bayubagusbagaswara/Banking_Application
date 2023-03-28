package com.bbb.bankingapplication.util;

public class Utils {

    public static boolean isPhoneEligible(String phone){
        boolean ret = true;
        if (phone.startsWith("08") || phone.startsWith("62")) {
            return ret;
        }
        return false;
    }

    public static String substitutePhonePrefix(String phone) {
        if (phone.startsWith("08")) return "62".concat(phone.substring(1));
        return phone;
    }
}
