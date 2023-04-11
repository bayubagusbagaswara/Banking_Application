package com.bbb.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDTO {

    private String id;

    private String userProfileId;

    private String accountNumber;

    private String accountStatus;

    private String productName;

    private String productType;

    private String productCode;

    private String currencyCode;

    private Instant createdAt;
    private Instant updatedAt;

    private String createdBy;
    private String updatedBy;
}
