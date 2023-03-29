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
public class OpeningDepositResponse {

    private String id;

    private BigDecimal totalTransaction;

    private String accountNumber;

    private String currency;

    private String accountAlias;

    private String terminal;

    private String depositPurpose;

    private String accountType;

    private String structNumber;

    private String transactionStatus;

    // detail tabungan dto
    DepositDetailDTO depositDetailDTO;

}
