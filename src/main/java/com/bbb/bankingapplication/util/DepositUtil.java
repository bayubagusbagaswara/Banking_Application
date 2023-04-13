package com.bbb.bankingapplication.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;

public class DepositUtil {

    private static final String defaultValueDate = "20160121";

    public static String formatBalance(String convert ){
        String pattern = "###,###,###,###,###,###,###";
        StringBuilder formatB = new StringBuilder();
        for(int i = 0; i<50; i++){
            String loop = convert.substring(i, i+1);
            String stop = loop + "stop";
            if (stop.equalsIgnoreCase(".stop") || stop.equalsIgnoreCase(",stop")){
                i = 51;
                loop = "";
            }
            formatB.append(loop);
        }
        BigDecimal formatBalParse = new BigDecimal(formatB.toString());
        DecimalFormat df = new DecimalFormat(pattern);
        String formatBalance = df.format(formatBalParse);
        return formatBalance.replace(",", ".");
    }

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
    }

    public static  int mudTenorToTimePeriod(String mudTenor){
        int timePeriode = 0;
        if (mudTenor.equalsIgnoreCase("01M")) {
            timePeriode = 1;
        } else if (mudTenor.equalsIgnoreCase("03M")) {
            timePeriode = 3;
        } else if (mudTenor.equalsIgnoreCase("06")) {
            timePeriode = 6;
        } else if (mudTenor.equalsIgnoreCase("12M")) {
            timePeriode = 12;
        }
        return timePeriode;
    }

    public static String systemDepositMaturity(String systemDeposit){
        String maturity = "";
        if(systemDeposit.equalsIgnoreCase("Automatic Roll Over")) {
            maturity = "AUTOMATIC ROLLOVER";
        } else if (systemDeposit.equalsIgnoreCase("Non Automatic Roll Over")) {
            maturity = "PAYMENT TO NOMINATED ACCOUNT";
        } else if (systemDeposit.equalsIgnoreCase("Automatic Roll Over + Bagi Hasil")) {
            maturity = "AUTOMATIC ROLLOVER";
        }
        return maturity;
    }

    public static String systemDepositAroOption(String systemDeposit){
        String aroOption = "";
        if(systemDeposit.equalsIgnoreCase("Automatic Roll Over")
                || systemDeposit.equalsIgnoreCase("Ammend Automatic Roll Over")) {
            aroOption = "1";
        } else if (systemDeposit.equalsIgnoreCase("Non Automatic Roll Over")) {
            aroOption = "";
        } else if (systemDeposit.equalsIgnoreCase("Automatic Roll Over + Bagi Hasil")
                || systemDeposit.equalsIgnoreCase("Ammend Automatic Roll Over + Bagi Hasil"))  {
            aroOption = "2";
        } else if (systemDeposit.equalsIgnoreCase("Ammend Non Automatic Roll Over")) {
            aroOption = "0";
        }
        return aroOption;
    }

    public static String systemDepositNroOption(String systemDeposit) {
        String nroOption = "";
        if(systemDeposit.equalsIgnoreCase("Automatic Roll Over")) {
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
        for(int i=0; i<maturityDate.length(); i++){
            String add = maturityDate.substring(i,i+1);
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

    public static String douDateFormDbConvert(String maturityDate){
        var input = maturityDate+"h";
        StringBuilder tanggal = new StringBuilder();
        StringBuilder bulan = new StringBuilder();
        StringBuilder tahun = new StringBuilder();
        var douDate = "";

        for(int i=0; i<input.length()-1; i++) {
            String add = input.substring(i, i+1);
            if(i==0 || i==1) {
                tanggal.append(add);
            } else if (i >=3 && i<= input.length()-7) {
                bulan.append(add);
            } else if (i >= input.length()-6) {
                tahun.append(add);
            }
        }

        String formattedDate = tahun.toString().trim()+"-"+monthFullToNumber(bulan.toString())+"-"+ tanggal.toString().trim();
        LocalDate maturity = LocalDate.parse(formattedDate);
        boolean tes = LocalDate.now().isBefore(maturity);
        if (tes) {
            douDate = "1";
        } else {
            douDate = "0";
        }
        return douDate;

    }
    public static String aroToSystemDepo(String aroOption) {
        var aro = "Automatic Roll Over";
        var aroplus = "Automatic Roll Over + Bagi Hasil";
        var noaro = "Non Automatic Roll Over";
        var systemDepo = "";
        if (aroOption.equalsIgnoreCase("")) {
            systemDepo = noaro;
        } else if (aroOption.equalsIgnoreCase("1")) {
            systemDepo = aro;
        } else if (aroOption.equalsIgnoreCase("2")) {
            systemDepo =aroplus;
        }
        return systemDepo;
    }
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
    public static String constractDateDeposito(String date, String language){
        /**format yang muncul esb yyyyMMdd**/
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(4,6));
        int dated = Integer.parseInt(date.substring(6,date.length()));
        var maturityDate  = new Date(year-1900,month-1,dated).getTime();

        return ConstructorUtil.constructDateWithOutTime(maturityDate, language,false);
    }

    public static String getValueDate(Boolean valueDateDefault){
        var valueDate = defaultValueDate;
        if(valueDateDefault==false){
            valueDate = DateUtil.formatCurrentDate("yyyyMMdd");
        }
        return valueDate;
    }

}
