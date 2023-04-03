package com.bbb.bankingapplication.dto.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequestDTO {

    // ini untuk mobile banking, setiap login pasti bawa data userProfileId, userFullName, dan userPhoneNumber
//    private Long userProfileId;
//    private String userFullName;
//    private String userPhoneNumber;

    private String transactionCategory; // TRANSFER_ONLINE, TRANSFER_SKN, TRANSFER_RTGS
    private String transactionStatus; // SUCCESS, FAILED, SUSPECT, INPROGRESS
    private String transactionDescription; // deskripsi transfer
    private Date transactioDate;
    private String transactionCurrency;
    private BigDecimal transactionAmount;
    private BigDecimal transactionFee;
    private BigDecimal transactionTotalAmount; // transactionAmount + transactionFee

    private String fromBankCode; // kode bank asal
    private String fromBankName; // nama bank asal
    private String fromAccountNumber; // nomor rekening asal
    private String fromAccountOwnerName; // nama pemilik rekening asal

    private String toBankCode; // kode bank tujuan
    private String toBankName; // nama bank tujuan
    private String toAccountNumber; // nomor rekening tujuan
    private String toAccountOwnerName; // nama pemilik rekening tujuan


}
