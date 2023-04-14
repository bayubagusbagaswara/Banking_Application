package com.bbb.bankingapplication.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalanceInquiryCasaResponse {

    // DISPLAY INFO untuk tampilan di layar

    // COMPANY INFO
    private String companyCode;
    private String companyCodeName;

    // ACCOUNT INFO
    private String customer;

//   ACCOUNT
    private String accountNo;
    private String accountDescription;
    private String accountTittle;
    private String accountType;

//  BALANCE
    private String workingBalance;
    private String lockBalance;
    private String minimalBalance;
    private String availableBalance;
    private String currency;

    private String category;
    private String openingDate;
}
