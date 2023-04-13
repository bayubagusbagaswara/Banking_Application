package com.bbb.bankingapplication.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenAccountDepositRequest {

    private String messageId;
    private String cif;
    private String currency;
    private String accountOfficer;
    private String interestLiquAcct;
    private String amnestyFlag;
    private String principal;
    private String valueDate;
    private String repayAccount;
    private String nominatedAccount;
    private String maturityInstr;
    private String mudprintednam;
    private String mudbilyet;
    private String mudTenor;
    private String mudNisbah;
    private String zakat;
    private String aroOption;
    private String nroOption;
    private String qqName;
    private String taxAble;
    private String noRefferal;
    private String acopenpurpose;
    private String lock;
    private String refOutSource;
    private String refProgram;
    private String eventCode;
    private String descProdDpk;
    private String company;
}
