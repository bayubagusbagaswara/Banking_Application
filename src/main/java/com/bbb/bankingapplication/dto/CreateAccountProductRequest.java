package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountProductRequest {

    private String productCodeNumber;

    private String productCodeName;

    private String productTitle;

    private String productDescription;

    private String productShortDescription;

    private BigDecimal minimumBalance;

    private BigDecimal minimumInitialDeposit;

}
