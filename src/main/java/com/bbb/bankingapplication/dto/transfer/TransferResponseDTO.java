package com.bbb.bankingapplication.dto.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferResponseDTO {

//    private String status;
//
//    private String message;
//
//    private String responseCode;

    private String fromAccountNumber; // nomor rekening asal
    private String toAccountNumber; // nomor rekening tujuan

    private String transactionStatus;

    private String localDateTime;

    private BigDecimal amount;

    private BigDecimal adminFee;

    private String note;


}
