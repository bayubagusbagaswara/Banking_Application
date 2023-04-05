package com.bbb.bankingapplication.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferOnlineRequest {

    // amount
    private String amount;

    // currency, IDR
    private String currency;

    // tanggal transaksi
    private String transactionDate;

    // bank code penerima
    private String beneficiaryBankCode;
    // bank name penerima
    private String beneficiaryBankName;

    // nomor rekening penerima
    private String beneficiaryAccountNumber;
    // email penerima
//    private String beneficiaryEmail;
    // nama rekening penerima
    private String beneficiaryAccountName;
    // alamat penerima
//    private String beneficiaryAddress;
    // phone number pengirim
//    private String beneficiaryPhoneNumber;


    // nomor rekening pengirim
    private String sourceAccountNumber;
    // nama rekening pengirim
    private String sourceAccountName;

}
