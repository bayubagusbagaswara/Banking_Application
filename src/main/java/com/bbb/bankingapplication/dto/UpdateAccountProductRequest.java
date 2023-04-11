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
public class UpdateAccountProductRequest {

    private String productCode;

    private String productName;

    private String productInfo;

    private String productDescription;

    private String productShortDescription;

    private BigDecimal minimumBalance;

    private BigDecimal minimumInitialDeposit;

    private String productFeature;
}