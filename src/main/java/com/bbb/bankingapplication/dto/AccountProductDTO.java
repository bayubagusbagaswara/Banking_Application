package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountProductDTO {

    private String id;

    private String productCodeNumber;

    private String productCodeName;

    private String productTitle;

    private String productInfo;

    private String productDescription;

    private String productShortDescription;

    private BigDecimal minimumBalance;

    private BigDecimal minimumInitialDeposit;

    private String productFeature;

    private LocalDateTime createdAt;
    private String createdBy;

    private LocalDateTime updatedAt;
    private String updatedBy;

}
