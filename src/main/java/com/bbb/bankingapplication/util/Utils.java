package com.bbb.bankingapplication.util;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

@Slf4j
public class Utils {

    private static final String defaultValueDate = "20160121";

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

    public static Boolean isEmail(String proxy){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (proxy == null) return false;
        return pat.matcher(proxy).matches();
    }


    // melakukan format saldo
    public static String formatBalance(String convert ){
        String pattern = "###,###,###,###,###,###,###";
        StringBuilder formatB = new StringBuilder();

        for (int i = 0; i < 50; i++) {
            // ambil string karakter dari string input
            String loop = convert.substring(i, i+1);
            String stop = loop + "stop";

            if (stop.equalsIgnoreCase(".stop") || stop.equalsIgnoreCase(",stop")) {
                i = 51;
                loop = "";
            }
            // tambahkan string loop ke formatB
            formatB.append(loop);
        }

        BigDecimal formatBalParse = new BigDecimal(formatB.toString());
        DecimalFormat df = new DecimalFormat(pattern);
        String formatBalance = df.format(formatBalParse);

        // replace koma menjadi titik
        return formatBalance.replace(",", ".");
    }

    // ubah kode Mud Tenor menjadi String (Kalimat)
    public static String mudTenorToPeriod(String mudTenor){
        String periode = "";
        if (mudTenor.equalsIgnoreCase("01M")) {
            periode = "1 Bulan";
        } else if (mudTenor.equalsIgnoreCase("03M")) {
            periode = "3 Bulan";
        } else if (mudTenor.equalsIgnoreCase("06M")) {
            periode = "6 Bulan";
        } else if (mudTenor.equalsIgnoreCase("12M")) {
            periode = "12 Bulan";
        }
        return periode;
    };

    // ubah mud tenor (String) menjadi time period (integer)
    public static int mudTenorToTimePeriod(String mudTenor){
        int timePeriode = 0;

        if (mudTenor.equalsIgnoreCase("01M")) {
            timePeriode = 1;
        } else if (mudTenor.equalsIgnoreCase("03M")) {
            timePeriode = 3;
        } else if (mudTenor.equalsIgnoreCase("06M")) {
            timePeriode = 6;
        } else if (mudTenor.equalsIgnoreCase("12M")) {
            timePeriode = 12;
        }
        return timePeriode;
    }

    public static String systemDepositMaturity(String systemDeposit){
        String maturity = "";
        if (systemDeposit.equalsIgnoreCase("Automatic Roll Over")) {
            maturity = "AUTOMATIC ROLLOVER";
        } else if (systemDeposit.equalsIgnoreCase("Non Automatic Roll Over")) {
            maturity = "PAYMENT TO NOMINATED ACCOUNT";
        } else if (systemDeposit.equalsIgnoreCase("Automatic Roll Over + Bagi Hasil")) {
            maturity = "AUTOMATIC ROLLOVER";
        }
        return maturity;
    }

    public static String systemDepositAroOption(String systemDeposit) {
        String aroOption = "";

        if (systemDeposit.equalsIgnoreCase("Automatic Roll Over")
                || systemDeposit.equalsIgnoreCase("Amend Automatic Roll Over")) {
            aroOption = "1";
        } else if (systemDeposit.equalsIgnoreCase("Non Automatic Roll Over")) {
            aroOption = "";
        } else if (systemDeposit.equalsIgnoreCase("Automatic Roll Over + Bagi Hasil")
                || systemDeposit.equalsIgnoreCase("Amend Automatic Roll Over + Bagi Hasil")) {
            aroOption = "2";
        } else if (systemDeposit.equalsIgnoreCase("Amend Non Automatic Roll Over")) {
            aroOption = "0";
        }
        return aroOption;
    }

    public static String systemDepositNroOption(String systemDeposit){
        String nroOption = "";
        if (systemDeposit.equalsIgnoreCase("Automatic Roll Over")) {
            nroOption = "";
        } else if (systemDeposit.equalsIgnoreCase("Non Automatic Roll Over")) {
            nroOption = "1";
        } else if (systemDeposit.equalsIgnoreCase("Automatic Roll Over + Bagi Hasil")) {
            nroOption = "";
        }
        return nroOption;
    }

    public static String douDate(String maturityDate) {
        String douDate;
        StringBuilder formattedDate = new StringBuilder();

        for (int i = 0; i < maturityDate.length(); i++) {
            String add = maturityDate.substring(i, i+1);
            formattedDate.append(add);
        }

        LocalDate maturity = LocalDate.parse(formattedDate.toString());
        boolean tes = LocalDate.now().isBefore(maturity);

        if (tes) {
            douDate = "1";
        } else {
            douDate = "0";
        }
        return douDate;
    }

    public static String douDateFormDbConvert (String maturityDate){
        String input = maturityDate+"h";
        StringBuilder date = new StringBuilder();
        StringBuilder month = new StringBuilder();
        StringBuilder year = new StringBuilder();
        String douDate;

        for(int i =0; i < input.length()-1; i++){
            String add = input.substring(i, i+1);

            if (i==0 || i==1) {
                date.append(add);
            } else if (i >= 3 && i <= input.length() - 7) {
                month.append(add);
            } else if (i >= input.length() - 6) {
                year.append(add);
            }
        }

        // tanggal sudah diformat
        String formattedDate = year.toString().trim()+"-"+monthFullToNumber(month.toString())+"-"+ date.toString().trim();

        LocalDate maturity = LocalDate.parse(formattedDate);

        boolean tes = LocalDate.now().isBefore(maturity);

        if (tes) {
            douDate = "1";
        } else {
            douDate = "0";
        }
        return douDate;
    }

    public static String aroToSystemDeposit(String aroOption) {
        String aro = "Automatic Roll Over";
        String aroPlus = "Automatic Roll Over + Bagi Hasil";
        String nonAro = "Non Automatic Roll Over";

        String systemDepo = "";

        if (aroOption.equalsIgnoreCase("")) {
            systemDepo = nonAro;
        } else if (aroOption.equalsIgnoreCase("1")) {
            systemDepo = aro;
        } else if (aroOption.equalsIgnoreCase("2")) {
            systemDepo = aroPlus;
        }

        return systemDepo;
    }

    // convert month name to number
    public static String monthFullToNumber(String month) {
        switch (month) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03" ;
            case "Apr":
                return "04" ;
            case "Mei":
                return "05" ;
            case "Jun":
                return "06" ;
            case "Jul":
                return "07" ;
            case "Agt":
                return "08" ;
            case "Sep":
                return "09" ;
            case "Okt":
                return "10" ;
            case "Nov":
                return "11";
            case "Des":
                return "12";
            default :
                return "";
        }
    }

    public static String constractDateDeposit(String date, String language){
        /**format yang muncul esb yyyyMMdd**/

        // ambil karakter dari 0 sampai 3 (yyyy)
        int year = Integer.parseInt(date.substring(0, 4));

        // ambil karakter dari 4 sampai 6
        int month = Integer.parseInt(date.substring(4, 6));

        // ambil karakter dari 6 sampai maksimal panjang data
//        int dated = Integer.parseInt(date.substring(6, date.length()));
        int dated = Integer.parseInt(date.substring(6));

//        var maturityDate  = new Date(year-1900,month-1,dated).getTime();
        long time = new Date(year - 1900, month - 1, dated).getTime();

        return ConstructorUtil.constructDateWithOutTime(time, language, false);
    }

    public static String getValueDate(Boolean valueDateDefault) {
        String valueDate = defaultValueDate;
        if (!valueDateDefault) {
            valueDate = DateUtil.formatCurrentDate("yyyyMMdd");
        }
        return valueDate;
    }

}
