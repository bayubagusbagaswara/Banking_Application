package com.bbb.bankingapplication.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDepositResponse {

    private String id;

    private BigDecimal adminFee; // biaya admin

    private String resourceSaving; // tambungan sumber

    private String transactionStatus;

    private String depositPurpose; // tujuan deposit

    private String accountOwnerName; // nama pemilik account deposit

    private String depositSystem;

    private String accountType;

    private String accountAlias;

    private String coreRefNo;

    private String bankName;

    //    DetailTransaksiDto listDetail;

}
