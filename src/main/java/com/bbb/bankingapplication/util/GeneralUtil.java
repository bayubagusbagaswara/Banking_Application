package com.bbb.bankingapplication.util;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class GeneralUtil {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static final String NUMBER = "0123456789";
    static SecureRandom rnd = new SecureRandom();

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String customRandomString(String string, int limitGenerate){
        String randomCustem = string;
        for (int i = 1; i <= limitGenerate; i++) {
            if (string.length() == i) {
                randomCustem = string + randomString(limitGenerate - i);
            }
        }
        return randomCustem;
    }

    public static String customRandomNumber(String string, int limitGenerate){
        String randomCustom = string;
        for(int i = 1; i <= limitGenerate; i++) {
            if (string.length() == i) {
                randomCustom = string + randomNumber(limitGenerate - i);
            }
        }
        return randomCustom;
    }

    public static String randomAlphabet(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(ALPHABET.charAt(rnd.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    public static String randomNumber(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(NUMBER.charAt(rnd.nextInt(NUMBER.length())));
        }
        return sb.toString();
    }

    public static String generateMudTenor(String mudT){
        String mudTenor="";
        if(mudT.length() ==1){
            mudTenor="0"+mudT+"M";
        }else if(mudT.length()==2){
            mudTenor=mudT+"M";
        }
        return mudTenor;
    }

    public static String getGenderByNik(String nik) {
        return getGenderByNik(nik, "Perempuan", "Laki-Laki");
    }

    public static String getGenderByNikForDb(String nik) {
        return getGenderByNik(nik, "FEMALE", "MALE");
    }

    public static String getGenderByNik(String nik, String male, String female) {
        return nik == null ? "" : (Integer.parseInt(nik.substring(6, 8)) > 40 ? female : male);
    }

    public static String printCustomBigDecimalFormat(BigDecimal bd, String patern) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat(patern, symbols);
        if (containsDecimalPoint(bd)) {
            return df.format(bd);
        } else {
            return String.valueOf(bd);
        }
    }

    private static boolean containsDecimalPoint(BigDecimal bd) {
        return bd.toString().contains(".");
    }

}
