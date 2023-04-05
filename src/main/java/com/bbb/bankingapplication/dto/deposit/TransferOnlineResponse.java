package com.bbb.bankingapplication.dto.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferOnlineResponse {

    private String amount;
    private String currency;

    private String beneficiaryAccountNumber;
    private String sourceAccountNumber;

    private String transactionDate;
    private String receiptNumber;
    private String transactionId;
}
