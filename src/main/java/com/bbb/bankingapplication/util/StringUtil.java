package com.bbb.bankingapplication.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class StringUtil {

    public static final String PATTERN_AMOUNT_FIVE_DEC = "#,##0.00000";
    public static final String PATTERN_AMOUNT_TWO_DEC = "#,##0.00";

    public static String formatAmount(BigDecimal amount, String pattern) {
        if (amount == null || pattern == null || pattern.trim().length()==0) {
            return "";
        }

        Locale currentLocale = Locale.getDefault();
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator(',');
        DecimalFormat df = new DecimalFormat(pattern, otherSymbols);
        return df.format(amount);
    }

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


    public static String responseStrngValueMinLast3Digits(String input, String tagStop) {
        var res0 = "";
        var res1 = "";
        if(input!=null) {
            for (int i = 0; i <= input.length(); i++) {
                var tag = input.substring(i, i + 1);
                if (!tag.equalsIgnoreCase(tagStop)) {
                    res1 = input.substring(i, input.length() - 3);
                    res0 = input.substring(0, i);
                    break;
                }
            }
        }
        return res1;
    }

    public static String upperCaseWords(String sentence) {
        if(sentence.isEmpty() || sentence.isBlank()){
            return "";
        } else if (sentence==null) {
            return "";
        }
        String[] words = sentence.replaceAll("\\s+", " ").trim().split(" ");
        StringBuilder newSentence = new StringBuilder();
        if(sentence!=null) {
            for (String word : words) {
                for (int i = 0; i < word.length(); i++)
                    newSentence.append((i == 0) ? word.substring(i, i + 1).toUpperCase() :
                            (i != word.length() - 1) ? word.substring(i, i + 1).toLowerCase() : word.substring(i, i + 1).toLowerCase().toLowerCase() + " ");
            }
            newSentence = new StringBuilder(newSentence.substring(0, newSentence.length() - 1));
        }
        return newSentence.toString();
    }

    public static String upperCaseFirstWord(String sentence) {

        String newSentence = "";
        var tag = 0;
        if(sentence!=null) {
            for (int i = 0; i < sentence.length(); i++){
                var word = sentence.substring(i,i+1);
                if(word.equals(" ")){
                    tag = i;
                    newSentence = newSentence+sentence.substring(i,sentence.length());
                    break;
                }else {
                    newSentence = newSentence + word.toUpperCase();
                }
            }
            var firsWord = newSentence.substring(0,tag);
            var afterTheFirstWord = newSentence.substring(tag,sentence.length());
            afterTheFirstWord = upperCaseWords(afterTheFirstWord);
            newSentence = firsWord+" "+afterTheFirstWord;

        }

        return newSentence;
    }

    public static String responseStrngValueMinLast2Digits(String input) {
        var res0 = "";
        var res1 = "";
        if(input!=null) {
            for (int i = 0; i <= input.length(); i++) {
                var tag = input.substring(i, i + 1);
                if (!tag.equalsIgnoreCase(".")) {
                    res1 = input.substring(i, input.length() - 3);
                    res0 = input.substring(0, i);
                    break;
                }
            }
        }
        return res1;
    }

    public static String removeComma(String balance){
        return balance.replace(",","");
    }
}
